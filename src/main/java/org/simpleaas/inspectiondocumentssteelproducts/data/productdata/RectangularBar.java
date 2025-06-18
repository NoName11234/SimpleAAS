package org.simpleaas.inspectiondocumentssteelproducts.data.productdata;

import java.util.HashMap;

public class RectangularBar {
    private final String height;
    private final String width;
    private final String length;
    private final HashMap<String, String> standardReferences = new HashMap<>();

    public RectangularBar(String height, String width, String length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getLength() {
        return length;
    }

    public RectangularBar addStandardReference(String shortId, String value) {
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
