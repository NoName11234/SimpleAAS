package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.*;

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

            }
            case Property property -> {

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
}
