package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.*;

import java.util.Arrays;

/**
 * Class for copying submodel elements.
 */
public class SubmodelElementCopier {
    /**
     * The original submodel element to be copied.
     */
    private SubmodelElement original;

    /**
     * @param original the original submodel element to be copied
     */
    public SubmodelElementCopier(SubmodelElement original) {
        this.original = original;
    }

    /**
     * Creates a copy of the original submodel element.
     * @return copied submodel element
     */
    public SubmodelElement createCopy() {
        switch (original) {
            case AnnotatedRelationshipElement annotatedRelationshipElement -> {
                return copyAnnotatedRelationshipElement(annotatedRelationshipElement);
            }
            case RelationshipElement relationshipElement -> {
                return copyRelationshipElement(relationshipElement);
            }
            case Property property -> {
                return copyProperty(property);
            }
            case MultiLanguageProperty multiLanguageProperty -> {
                return copyMultiLanguageProperty(multiLanguageProperty);
            }
            case Range range -> {
                return copyRange(range);
            }
            case Blob blob -> {
                return copyBlob(blob);
            }
            case File file -> {
                return copyFile(file);
            }
            case ReferenceElement referenceElement -> {
                return copyReferenceElement(referenceElement);
            }
            case Capability capability -> {
                return copyCapability(capability);
            }
            case SubmodelElementList submodelElementList -> {
                return copySubmodelElementList(submodelElementList);
            }
            case SubmodelElementCollection submodelElementCollection -> {
                return copySubmodelElementCollection(submodelElementCollection);
            }
            case Entity entity -> {
                return copyEntity(entity);
            }
            default -> throw new IllegalStateException("Unsupported submodel element sub type: " + original.getClass().getName());
        }
    }

    /**
     * Creates a copy of a DataElement.
     * @param original  the original DataElement to be copied
     * @return copied DataElement
     */
    private DataElement copyDataElement(DataElement original) {
        switch(original) {
            case Property property -> {
                return copyProperty(property);
            }
            case MultiLanguageProperty mlp -> {
                return copyMultiLanguageProperty(mlp);
            }
            case Range range -> {
                return copyRange(range);
            }
            case Blob blob -> {
                return copyBlob(blob);
            }
            case File file -> {
                return copyFile(file);
            }
            case ReferenceElement refElem -> {
                return copyReferenceElement(refElem);
            }
            default -> throw new IllegalStateException("Unsupported data element sub type: " + original.getClass().getName());
        }
    }

    /**
     * Creates a copy of a SubmodelElementList.
     * @param original  the original SubmodelElementList to be copied
     * @return copied SubmodelElementList
     */
    private SubmodelElementList copySubmodelElementList(SubmodelElementList original) {
        var smlBuilder = new DefaultSubmodelElementList.Builder();

        smlBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            smlBuilder.displayName(copyLangStringNameType(displayName));
        }

        smlBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            smlBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            smlBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            smlBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            smlBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            smlBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                smlBuilder.extensions(copyExtension(de));
            }
        }

        smlBuilder.typeValueListElement(original.getTypeValueListElement());

        smlBuilder.valueTypeListElement(original.getValueTypeListElement());

        smlBuilder.orderRelevant(original.getOrderRelevant());

        for(SubmodelElement value: original.getValue()) {
            SubmodelElementCopier subElemCopier = new SubmodelElementCopier(value);
            smlBuilder.value(subElemCopier.createCopy());
        }

        return smlBuilder.build();
    }

    /**
     * Creates a copy of a SubmodelElementCollection.
     * @param original  the original SubmodelElementCollection to be copied
     * @return copied SubmodelElementCollection
     */
    private SubmodelElementCollection copySubmodelElementCollection(SubmodelElementCollection original) {
        var smcBuilder = new DefaultSubmodelElementCollection.Builder();

        smcBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            smcBuilder.displayName(copyLangStringNameType(displayName));
        }

        smcBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            smcBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            smcBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            smcBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            smcBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            smcBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                smcBuilder.extensions(copyExtension(de));
            }
        }

        for(SubmodelElement value: original.getValue()) {
            SubmodelElementCopier subElemCopier = new SubmodelElementCopier(value);
            smcBuilder.value(subElemCopier.createCopy());
        }

        return smcBuilder.build();
    }

    /**
     * Creates a copy of an Entity.
     * @param original  the original Entity to be copied
     * @return copied Entity
     */
    private Entity copyEntity(Entity original) {
        var entityBuilder = new DefaultEntity.Builder();

        entityBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            entityBuilder.displayName(copyLangStringNameType(displayName));
        }

        entityBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            entityBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            entityBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            entityBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            entityBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            entityBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                entityBuilder.extensions(copyExtension(de));
            }
        }

        entityBuilder.entityType(original.getEntityType());

        for(SubmodelElement statement: original.getStatements()) {
            SubmodelElementCopier subElemCopier = new SubmodelElementCopier(statement);
            entityBuilder.statements(subElemCopier.createCopy());
        }

        return entityBuilder.build();
    }

    /**
     * Creates a copy of a Capability.
     * @param original  the original Capability to be copied
     * @return copied Capability
     */
    private Capability copyCapability(Capability original) {
        var capBuilder = new DefaultCapability.Builder();

        capBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            capBuilder.displayName(copyLangStringNameType(displayName));
        }

        capBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            capBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            capBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            capBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            capBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            capBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                capBuilder.extensions(copyExtension(de));
            }
        }

        return capBuilder.build();
    }

    /**
     * Creates a copy of a ReferenceElement.
     * @param original  the original ReferenceElement to be copied
     * @return copied ReferenceElement
     */
    private ReferenceElement copyReferenceElement(ReferenceElement original) {
        var refElemBuilder = new DefaultReferenceElement.Builder();

        refElemBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            refElemBuilder.displayName(copyLangStringNameType(displayName));
        }

        refElemBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            refElemBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            refElemBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            refElemBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            refElemBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            refElemBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                refElemBuilder.extensions(copyExtension(de));
            }
        }

        refElemBuilder.value(copyReference(original.getValue()));

        return refElemBuilder.build();
    }

    /**
     * Creates a copy of a File.
     * @param original the original File to be copied
     * @return copied File
     */
    private File copyFile(File original) {
        var fileBuilder = new DefaultFile.Builder();

        fileBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            fileBuilder.displayName(copyLangStringNameType(displayName));
        }

        fileBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            fileBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            fileBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            fileBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            fileBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            fileBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                fileBuilder.extensions(copyExtension(de));
            }
        }

        fileBuilder.contentType(original.getContentType());

        fileBuilder.value(original.getValue());

        return fileBuilder.build();
    }

    /**
     * Creates a copy of a Blob.
     * @param original the original Blob to be copied
     * @return copied Blob
     */
    private Blob copyBlob(Blob original) {
        var blobBuilder = new DefaultBlob.Builder();

        blobBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            blobBuilder.displayName(copyLangStringNameType(displayName));
        }

        blobBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            blobBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            blobBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            blobBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            blobBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            blobBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                blobBuilder.extensions(copyExtension(de));
            }
        }

        blobBuilder.value(Arrays.copyOf(original.getValue(), original.getValue().length));

        return blobBuilder.build();
    }

    /**
     * Creates a copy of a Range.
     * @param original the original Range to be copied
     * @return copied Range
     */
    private Range copyRange(Range original) {
        var rangeBuilder = new DefaultRange.Builder();

        rangeBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            rangeBuilder.displayName(copyLangStringNameType(displayName));
        }

        rangeBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            rangeBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            rangeBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            rangeBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            rangeBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            rangeBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                rangeBuilder.extensions(copyExtension(de));
            }
        }

        rangeBuilder.valueType(original.getValueType());

        rangeBuilder.max(original.getMax());

        rangeBuilder.min(original.getMin());

        return rangeBuilder.build();
    }

    /**
     * Create a copy of a MultiLanguageProperty.
     * @param original the original MultiLanguageProperty to be copied
     * @return copied MultiLanguageProperty
     */
    private MultiLanguageProperty copyMultiLanguageProperty(MultiLanguageProperty original) {
        var mlpBuilder = new DefaultMultiLanguageProperty.Builder();

        mlpBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            mlpBuilder.displayName(copyLangStringNameType(displayName));
        }

        mlpBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            mlpBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            mlpBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            mlpBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            mlpBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            mlpBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                mlpBuilder.extensions(copyExtension(de));
            }
        }

        for(LangStringTextType value: original.getValue()) {
            mlpBuilder.value(copyLangStringTextType(value));
        }

        if(original.getValueId() != null) {
            mlpBuilder.valueId(copyReference(original.getValueId()));
        }

        return mlpBuilder.build();
    }

    /**
     * Create a copy of an AnnotatedRelationshipElement.
     * @param original the original AnnotatedRelationshipElement to be copied
     * @return copied AnnotatedRelationshipElement
     */
    private AnnotatedRelationshipElement copyAnnotatedRelationshipElement(AnnotatedRelationshipElement original) {
        var anRelElemBuilder = new DefaultAnnotatedRelationshipElement.Builder();

        anRelElemBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            anRelElemBuilder.displayName(copyLangStringNameType(displayName));
        }

        anRelElemBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            anRelElemBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            anRelElemBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            anRelElemBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            anRelElemBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            anRelElemBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                anRelElemBuilder.extensions(copyExtension(de));
            }
        }

        for(DataElement dataElement: original.getAnnotations()){
            anRelElemBuilder.annotations(copyDataElement(dataElement));
        }

        if(original.getFirst() != null){
            anRelElemBuilder.first(copyReference(original.getFirst()));
        }

        if(original.getSecond() != null){
            anRelElemBuilder.second(copyReference(original.getSecond()));
        }

        return anRelElemBuilder.build();
    }

    /**
     * Create a copy of a RelationshipElement.
     * @param original the original RelationshipElement to be copied
     * @return copied RelationshipElement
     */
    private RelationshipElement copyRelationshipElement(RelationshipElement original) {
        var relElemBuilder = new DefaultRelationshipElement.Builder();

        relElemBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            relElemBuilder.displayName(copyLangStringNameType(displayName));
        }

        relElemBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            relElemBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            relElemBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            relElemBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            relElemBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            relElemBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                relElemBuilder.extensions(copyExtension(de));
            }
        }

        if(original.getFirst() != null) {
            relElemBuilder.first(copyReference(original.getFirst()));
        }

        if(original.getSecond() != null) {
            relElemBuilder.second(copyReference(original.getSecond()));
        }

        return relElemBuilder.build();
    }

    /**
     * Create a copy of a Property.
     * @param original the original Property to be copied
     * @return copied Property
     */
    private Property copyProperty(Property original) {
        var propertyBuilder = new DefaultProperty.Builder();

        propertyBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            propertyBuilder.displayName(copyLangStringNameType(displayName));
        }

        propertyBuilder.category(original.getCategory());

        for(LangStringTextType description: original.getDescription()) {
            propertyBuilder.description(copyLangStringTextType(description));
        }

        if(original.getSemanticId() != null) {
            propertyBuilder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            propertyBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            propertyBuilder.qualifiers(copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification dataSpecification: original.getEmbeddedDataSpecifications()) {
            propertyBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
        }

        for(Extension extension: original.getExtensions()) {
            if(extension instanceof DefaultExtension de) {
                propertyBuilder.extensions(copyExtension(de));
            }
        }

        propertyBuilder.valueType(original.getValueType());

        propertyBuilder.value(original.getValue());

        if(original.getValueId() != null) {
            propertyBuilder.valueId(copyReference(original.getValueId()));
        }

        return propertyBuilder.build();
    }

    /**
     * Create a copy of an Extension.
     * @param original the original Extension to be copied
     * @return copied Extension
     */
    public static Extension copyExtension(Extension original) {
        var builder = new DefaultExtension.Builder();

        builder.value(original.getValue());

        builder.name(original.getName());

        builder.valueType(original.getValueType());

        if(original.getSemanticId() != null) {
            builder.semanticId(copyReference(original.getSemanticId()));
        }

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            builder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        for(Reference refersTo: original.getRefersTo()) {
            builder.refersTo(copyReference(refersTo));
        }

        return builder.build();
    }

    /**
     * Create a copy of a LangStringNameType.
     * @param original the original LangStringNameType to be copied
     * @return copied LangStringNameType
     */
    public static LangStringNameType copyLangStringNameType(LangStringNameType original) {
        var builder = new DefaultLangStringNameType.Builder();

        builder.text(original.getText()).language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a LangStringTextType.
     * @param original the original LangStringTextType to be copied
     * @return copied LangStringTextType
     */
    public static LangStringTextType copyLangStringTextType(LangStringTextType original) {
        var builder = new DefaultLangStringTextType.Builder();

        builder.text(original.getText()).language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a Reference.
     * @param original the original Reference to be copied
     * @return copied Reference
     */
    public static Reference copyReference(Reference original) {
        var builder = new DefaultReference.Builder();

        builder.type(original.getType());

        for(Key key: original.getKeys()) {
            builder.keys(copyKey(key));
        }

        if(original.getReferredSemanticId() != null) {
            builder.referredSemanticId(copyReference(original.getReferredSemanticId()));
        }

        return builder.build();
    }

    /**
     * Create a copy of a Key.
     * @param original the original Key to be copied
     * @return copied Key
     */
    private static Key copyKey(Key original) {
        var builder = new DefaultKey.Builder();

        builder.type(original.getType());

        builder.value(original.getValue());

        return builder.build();
    }

    /**
     * Create a copy of a Qualifier.
     * @param original the original Qualifier to be copied
     * @return copied Qualifier
     */
    public static Qualifier copyQualifier(Qualifier original) {
        var builder = new DefaultQualifier.Builder();

        builder.type(original.getType());

        builder.value(original.getValue());

        builder.valueType(original.getValueType());

        if(original.getSemanticId() != null) {
            builder.semanticId(copyReference(original.getSemanticId()));
        }

        builder.kind(original.getKind());

        for(Reference supplementalSemanticId: original.getSupplementalSemanticIds()) {
            builder.supplementalSemanticIds(copyReference(supplementalSemanticId));
        }

        if(original.getValueId() != null) {
            builder.valueId(copyReference(original.getValueId()));
        }

        return builder.build();
    }

    /**
     * Create a copy of EmbeddedDataSpecification.
     * @param original the original EmbeddedDataSpecification to be copied
     * @return copied EmbeddedDataSpecification
     */
    public static EmbeddedDataSpecification copyEmbeddedDataSpecification(EmbeddedDataSpecification original) {
        var builder =  new DefaultEmbeddedDataSpecification.Builder();

        if(original.getDataSpecificationContent() != null) {
            if(original.getDataSpecificationContent() instanceof DefaultDataSpecificationIec61360 dds) {
                builder.dataSpecificationContent(copyDataSpecificationIec61360(dds));
            }
        }

        if(original.getDataSpecification() != null) {
            builder.dataSpecification(copyReference(original.getDataSpecification()));
        }

        return builder.build();
    }

    /**
     * Create a copy of a DataSpecificationIec61360.
     * @param original the original DataSpecificationIec61360 to be copied
     * @return copied DataSpecificationIec61360
     */
    private static DataSpecificationContent copyDataSpecificationIec61360(DefaultDataSpecificationIec61360 original) {
        var builder = new DefaultDataSpecificationIec61360.Builder();

        builder.value(original.getValue());
        builder.valueFormat(original.getValueFormat());

        if(original.getValueList() != null) {
            if(original.getValueList() instanceof DefaultValueList dvl) {
                builder.valueList(copyValueList(dvl));
            }
        }

        builder.dataType(original.getDataType());

        for(LangStringDefinitionTypeIec61360 definition: original.getDefinition()) {
            if(definition instanceof DefaultLangStringDefinitionTypeIec61360 dlsdt) {
                builder.definition(copyLangStringDefinitionTypeIec61360(dlsdt));
            }
        }

        if(original.getLevelType() != null) {
            if(original.getLevelType() instanceof DefaultLevelType dlt) {
                builder.levelType(copyLevelType(dlt));
            }
        }

        for(LangStringPreferredNameTypeIec61360 preferredName: original.getPreferredName()) {
            if(preferredName instanceof DefaultLangStringPreferredNameTypeIec61360 dlspn) {
                builder.preferredName(copyLangStringPreferredNameTypeIec61360(dlspn));
            }
        }

        for(LangStringShortNameTypeIec61360 shortName: original.getShortName()) {
            if(shortName instanceof DefaultLangStringShortNameTypeIec61360 dlssnt) {
                builder.shortName(copyLangStringShortNameTypeIec61360(dlssnt));
            }
        }

        builder.sourceOfDefinition(original.getSourceOfDefinition());

        builder.symbol(original.getSymbol());

        builder.unit(original.getUnit());

        if(original.getUnitId() != null) {
            builder.unitId(copyReference(original.getUnitId()));
        }

        return builder.build();
    }

    /**
     * Create a copy of a LangStringShortNameTypeIec61360.
     * @param original the LangStringShortNameTypeIec61360 to be copied
     * @return copied LangStringShortNameTypeIec61360
     */
    private static LangStringShortNameTypeIec61360 copyLangStringShortNameTypeIec61360(DefaultLangStringShortNameTypeIec61360 original) {
        var builder = new DefaultLangStringShortNameTypeIec61360.Builder();

        builder.text(original.getText());

        builder.language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a LangStringPreferredNameTypeIec61360.
     * @param original the LangStringPreferredNameTypeIec61360 to be copied
     * @return copied LangStringPreferredNameTypeIec61360
     */
    private static LangStringPreferredNameTypeIec61360 copyLangStringPreferredNameTypeIec61360(DefaultLangStringPreferredNameTypeIec61360 original) {
        var builder = new DefaultLangStringPreferredNameTypeIec61360.Builder();

        builder.text(original.getText());

        builder.language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a LevelType.
     * @param original the LevelType to be copied
     * @return copied LevelType
     */
    private static LevelType copyLevelType(DefaultLevelType original) {
        var builder = new DefaultLevelType.Builder();

        builder.max(original.getMax()).min(original.getMin()).nom(original.getNom()).typ(original.getTyp());

        return builder.build();
    }

    /**
     * Create a copy of a LangStringDefinitionTypeIec61360.
     * @param original the LangStringDefinitionTypeIec61360 to be copied
     * @return copied LangStringDefinitionTypeIec61360
     */
    private static LangStringDefinitionTypeIec61360 copyLangStringDefinitionTypeIec61360(DefaultLangStringDefinitionTypeIec61360 original) {
        var builder = new DefaultLangStringDefinitionTypeIec61360.Builder();

        builder.text(original.getText());

        builder.language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a ValueList.
     * @param original the ValueList to be copied
     * @return copied ValueList
     */
    private static ValueList copyValueList(DefaultValueList original) {
        var builder = new DefaultValueList.Builder();

        for(ValueReferencePair valueReferencePair: original.getValueReferencePairs()) {
            if(valueReferencePair instanceof DefaultValueReferencePair dvrp){
                builder.valueReferencePairs(copyValueReferencePair(dvrp));
            }
        }

        return builder.build();
    }

    /**
     * Create a copy of a ValueReferencePair.
     * @param original the ValueReferencePair to be copied
     * @return copied ValueReferencePair
     */
    private static ValueReferencePair copyValueReferencePair(DefaultValueReferencePair original) {
        var builder = new DefaultValueReferencePair.Builder();

        builder.value(original.getValue());

        if(original.getValueId() != null) {
            builder.valueId(copyReference(original.getValueId()));
        }

        return builder.build();
    }
}
