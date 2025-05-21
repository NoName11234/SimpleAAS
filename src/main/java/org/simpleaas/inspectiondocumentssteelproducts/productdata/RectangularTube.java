package org.simpleaas.inspectiondocumentssteelproducts.productdata;

import java.util.HashMap;

public class RectangularTube {
    private final String wallThickness;
    private final String height;
    private final String width;
    private final String length;
    private final HashMap<String, String> standardReferences = new HashMap<>();

    public RectangularTube(String wallThickness, String height, String width, String length) {
        this.wallThickness = wallThickness;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getWallThickness() {
        return wallThickness;
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

    public RectangularTube addStandardReference(String shortId, String value) {
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
