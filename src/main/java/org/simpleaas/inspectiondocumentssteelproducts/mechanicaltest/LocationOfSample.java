package org.simpleaas.inspectiondocumentssteelproducts.mechanicaltest;

import java.util.HashMap;

public class LocationOfSample {
    private final String shortId;
    private final HashMap<String, String> location = new HashMap<>();

    public LocationOfSample(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return shortId;
    }

    public LocationOfSample addLocationOfSample(String language, String location) {
        this.location.put(language, location);
        return this;
    }

    public HashMap<String, String> getLocationOfSample() {
        return location;
    }
}
