package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.*;

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
    private SubmodelElement createCopy() {
        switch (original) {
            case AnnotatedRelationshipElement annotatedRelationshipElement -> {

            }
            case RelationshipElement relationshipElement -> {
                var relElemBuilder = new DefaultRelationshipElement.Builder();

                relElemBuilder.idShort(relationshipElement.getIdShort());

                for(LangStringNameType displayName: relationshipElement.getDisplayName()) {
                    relElemBuilder.displayName(copyLangStringNameType(displayName));
                }

                relElemBuilder.category(relationshipElement.getCategory());

                for(LangStringTextType description: relationshipElement.getDescription()) {
                    relElemBuilder.description(copyLangStringTextType(description));
                }

                if(relationshipElement.getSemanticId() != null) {
                    relElemBuilder.semanticId(copyReference(relationshipElement.getSemanticId()));
                }

                for(Reference supplementalSemanticId: relationshipElement.getSupplementalSemanticIds()) {
                    relElemBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
                }

                for(Qualifier qualifier: relationshipElement.getQualifiers()) {
                    relElemBuilder.qualifiers(copyQualifier(qualifier));
                }

                for(EmbeddedDataSpecification dataSpecification: relationshipElement.getEmbeddedDataSpecifications()) {
                    relElemBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
                }

                for(Extension extension: relationshipElement.getExtensions()) {
                    if(extension instanceof DefaultExtension de) {
                        relElemBuilder.extensions(copyExtension(de));
                    }
                }

                if(relationshipElement.getFirst() != null) {
                    relElemBuilder.first(copyReference(relationshipElement.getFirst()));
                }

                if(relationshipElement.getSecond() != null) {
                    relElemBuilder.second(copyReference(relationshipElement.getSecond()));
                }

                return relElemBuilder.build();
            }
            case Property property -> {
                var propertyBuilder = new DefaultProperty.Builder();

                propertyBuilder.idShort(property.getIdShort());

                for(LangStringNameType displayName: property.getDisplayName()) {
                    propertyBuilder.displayName(copyLangStringNameType(displayName));
                }

                propertyBuilder.category(property.getCategory());

                for(LangStringTextType description: property.getDescription()) {
                    propertyBuilder.description(copyLangStringTextType(description));
                }

                if(property.getSemanticId() != null) {
                    propertyBuilder.semanticId(copyReference(property.getSemanticId()));
                }

                for(Reference supplementalSemanticId: property.getSupplementalSemanticIds()) {
                    propertyBuilder.supplementalSemanticIds(copyReference(supplementalSemanticId));
                }

                for(Qualifier qualifier: property.getQualifiers()) {
                    propertyBuilder.qualifiers(copyQualifier(qualifier));
                }

                for(EmbeddedDataSpecification dataSpecification: property.getEmbeddedDataSpecifications()) {
                    propertyBuilder.embeddedDataSpecifications(copyEmbeddedDataSpecification(dataSpecification));
                }

                for(Extension extension: property.getExtensions()) {
                    if(extension instanceof DefaultExtension de) {
                        propertyBuilder.extensions(copyExtension(de));
                    }
                }

                propertyBuilder.valueType(property.getValueType());

                propertyBuilder.value(property.getValue());

                if(property.getValueId() != null) {
                    propertyBuilder.valueId(copyReference(property.getValueId()));
                }

                return propertyBuilder.build();
            }
            case MultiLanguageProperty multiLanguageProperty -> {

            }
            case Range range -> {

            }
            case Blob blob -> {

            }
            case File file -> {

            }
            case ReferenceElement referenceElement -> {

            }
            case Capability capability -> {

            }
            case SubmodelElementList submodelElementList -> {

            }
            case SubmodelElementCollection submodelElementCollection -> {

            }
            case Entity entity -> {

            }
            case BasicEventElement basicEventElement -> {

            }
            case Operation operation -> {

            }
            case OperationVariable operationVariable -> {

            }
            default -> throw new IllegalStateException("Unsupported submodel element sub type: " + original.getClass().getName());
        }
    }

    /**
     * Create a copy of an Extension.
     * @param original the original Extension to be copied
     * @return copied Extension
     */
    private Extension copyExtension(DefaultExtension original) {
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
    private LangStringNameType copyLangStringNameType(LangStringNameType original) {
        var builder = new DefaultLangStringNameType.Builder();

        builder.text(original.getText()).language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a LangStringTextType.
     * @param original the original LangStringTextType to be copied
     * @return copied LangStringTextType
     */
    private LangStringTextType copyLangStringTextType(LangStringTextType original) {
        var builder = new DefaultLangStringTextType.Builder();

        builder.text(original.getText()).language(original.getLanguage());

        return builder.build();
    }

    /**
     * Create a copy of a Reference.
     * @param original the original Reference to be copied
     * @return copied Reference
     */
    private Reference copyReference(Reference original) {
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
    private Key copyKey(Key original) {
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
    private Qualifier copyQualifier(Qualifier original) {
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
    private EmbeddedDataSpecification copyEmbeddedDataSpecification(EmbeddedDataSpecification original) {
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
    private DataSpecificationContent copyDataSpecificationIec61360(DefaultDataSpecificationIec61360 original) {
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
    private LangStringShortNameTypeIec61360 copyLangStringShortNameTypeIec61360(DefaultLangStringShortNameTypeIec61360 original) {

    }

    /**
     * Create a copy of a LangStringPreferredNameTypeIec61360.
     * @param original the LangStringPreferredNameTypeIec61360 to be copied
     * @return copied LangStringPreferredNameTypeIec61360
     */
    private LangStringPreferredNameTypeIec61360 copyLangStringPreferredNameTypeIec61360(DefaultLangStringPreferredNameTypeIec61360 original) {
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
    private LevelType copyLevelType(DefaultLevelType original) {
        var builder = new DefaultLevelType.Builder();

        builder.max(original.getMax()).min(original.getMin()).nom(original.getNom()).typ(original.getTyp());

        return builder.build();
    }

    /**
     * Create a copy of a LangStringDefinitionTypeIec61360.
     * @param original the LangStringDefinitionTypeIec61360 to be copied
     * @return copied LangStringDefinitionTypeIec61360
     */
    private LangStringDefinitionTypeIec61360 copyLangStringDefinitionTypeIec61360(DefaultLangStringDefinitionTypeIec61360 original) {
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
    private ValueList copyValueList(DefaultValueList original) {
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
    private ValueReferencePair copyValueReferencePair(DefaultValueReferencePair original) {
        var builder = new DefaultValueReferencePair.Builder();

        builder.value(original.getValue());

        if(original.getValueId() != null) {
            builder.valueId(copyReference(original.getValueId()));
        }

        return builder.build();
    }
}
