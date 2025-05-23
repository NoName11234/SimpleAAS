package org.simpleaas.helper;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultLangStringTextType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ElementUtils {
    public static List<Property> getProperties(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), semanticId))
                .toList();
    }

    public static List<String> getPropertyValues(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), semanticId))
                .map(Property::getValue)
                .toList();
    }

    public static Optional<Property> getProperty(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), semanticId))
                .findAny();
    }

    public static Optional<String> getPropertyValue(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), semanticId))
                .map(Property::getValue)
                .findAny();
    }

    public static Optional<MultiLanguageProperty> getMlp(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof MultiLanguageProperty)
                .map(se -> ((MultiLanguageProperty)se))
                .filter(mlp -> compareSemanticId(mlp.getSemanticId(), semanticId))
                .findAny();
    }

    public static HashMap<String, String> getMlpValue(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof MultiLanguageProperty)
                .map(se -> ((MultiLanguageProperty)se))
                .filter(mlp -> compareSemanticId(mlp.getSemanticId(), semanticId))
                .map(ElementUtils::convertMlp)
                .findAny().orElse(new HashMap<>());
    }

    public static Optional<SubmodelElementCollection> getSmc(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .filter(smc -> compareSemanticId(smc.getSemanticId(), semanticId))
                .findAny();
    }

    public static List<SubmodelElementCollection> getSmcs(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .filter(smc -> compareSemanticId(smc.getSemanticId(), semanticId))
                .toList();
    }

    public static Optional<SubmodelElementList> getSml(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof SubmodelElementList)
                .map(se -> ((SubmodelElementList)se))
                .filter(sml -> compareSemanticId(sml.getSemanticId(), semanticId))
                .findAny();
    }

    public static Optional<File> getFile(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof File)
                .map(se -> ((File)se))
                .filter(file -> compareSemanticId(file.getSemanticId(), semanticId))
                .findAny();
    }

    public static Optional<ReferenceElement> getReferenceElement(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof ReferenceElement)
                .map(se -> ((ReferenceElement)se))
                .filter(re -> compareSemanticId(re.getSemanticId(), semanticId))
                .findAny();
    }

    public static boolean compareSemanticId(Reference reference, String semanticId) {
        for(Key key: reference.getKeys()) {
            if(key.getValue().equals(semanticId)) {
                return true;
            }
        }

        return false;
    }

    public static HashMap<String, String> convertMlp(MultiLanguageProperty mlp) {
        HashMap<String, String> values = new HashMap<>();

        for(LangStringTextType value: mlp.getValue()) {
            values.put(value.getLanguage(), value.getText());
        }

        return values;
    }

    public static List<LangStringTextType> convertHashMap(HashMap<String, String> valueMap) {
        List<LangStringTextType> valueList = new ArrayList<>();

        for(String key: valueMap.keySet()) {
            valueList.add(new DefaultLangStringTextType.Builder()
                    .language(key)
                    .text(valueMap.get(key))
                    .build());
        }

        return valueList;
    }

    public static Optional<FileModel> getFileModel(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof File)
                .map(se -> ((File)se))
                .filter(f -> compareSemanticId(f.getSemanticId(), semanticId))
                .map(f -> new FileModel(f.getValue(), f.getContentType()))
                .findAny();
    }
}
