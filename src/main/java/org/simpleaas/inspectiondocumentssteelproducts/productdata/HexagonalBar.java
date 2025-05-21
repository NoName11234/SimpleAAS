package org.simpleaas.inspectiondocumentssteelproducts.productdata;

import java.util.HashMap;

public class HexagonalBar {
    private final String widthAcrossFlats;
    private final String length;
    private final HashMap<String, String> standardReferences = new HashMap<>();

    public HexagonalBar(String widthAcrossFlats, String length) {
        this.widthAcrossFlats = widthAcrossFlats;
        this.length = length;
    }

    public String getWidthAcrossFlats() {
        return widthAcrossFlats;
    }

    public String getLength() {
        return length;
    }

    public HexagonalBar addStandardReference(String shortId, String value) {
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
