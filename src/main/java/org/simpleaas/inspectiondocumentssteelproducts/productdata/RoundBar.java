package org.simpleaas.inspectiondocumentssteelproducts.productdata;

import java.util.HashMap;

public class RoundBar {
    private final String outerDiameter;
    private final String length;
    private final HashMap<String, String> standardReferences = new HashMap<>();

    public RoundBar(String outerDiameter, String length) {
        this.outerDiameter = outerDiameter;
        this.length = length;
    }

    public String getOuterDiameter() {
        return outerDiameter;
    }
    public String getLength() {
        return length;
    }

    public RoundBar addStandardReference(String shortId, String value) {
        this.standardReferences.put(shortId, value);
        return this;
    }

    public HashMap<String, String> getStandardReferences() {
        return this.standardReferences;
    }

    public boolean areStandardReferencesPresent() {
        return !this.standardReferences.isEmpty();
    }
}
