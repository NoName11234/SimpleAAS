package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

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
}
