package org.simpleaas.inspectiondocumentssteelproducts.data.productdata;

import java.util.HashMap;

public class Tube {
    private final String wallThickness;
    private final String outerDiameter;
    private final String length;
    public final HashMap<String, String> standardReferences = new HashMap<>();

    public Tube(String wallThickness, String outerDiameter, String length) {
        this.wallThickness = wallThickness;
        this.outerDiameter = outerDiameter;
        this.length = length;
    }

    public String getWallThickness() {
        return wallThickness;
    }
    public String getOuterDiameter() {
        return outerDiameter;
    }
    public String getLength() {
        return length;
    }

    public Tube addStandardReference(String shortId, String value) {
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
