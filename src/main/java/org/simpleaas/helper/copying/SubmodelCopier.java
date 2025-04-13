package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

/**
 * Class for copying submodels.
 */
public class SubmodelCopier {
    /**
     * The original submodel to be copied.
     */
    private Submodel original;

    /**
     * @param original the original submodel to be copied
     */
    public SubmodelCopier(Submodel original) {
        this.original = original;
    }
}
