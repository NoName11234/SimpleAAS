package org.simpleaas.inspectiondocumentssteelproducts.data.productdata;

import java.util.HashMap;

public class Profile {
    private final String profileSpecification;
    private final String height;
    private final String width;
    private final String length;
    private final HashMap<String, String> standardReferences = new HashMap<>();

    public Profile(String profileSpecification, String height, String width, String length) {
        this.profileSpecification = profileSpecification;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getProfileSpecification() {
        return profileSpecification;
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

    public Profile addStandardReference(String shortId, String value) {
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
