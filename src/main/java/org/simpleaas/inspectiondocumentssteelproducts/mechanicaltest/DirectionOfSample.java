package org.simpleaas.inspectiondocumentssteelproducts.mechanicaltest;

import java.util.HashMap;

public class DirectionOfSample {
    private final String shortId;
    HashMap<String, String> direction = new HashMap<>();

    public DirectionOfSample(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return shortId;
    }

    public DirectionOfSample addDirectionOfSample(String language, String direction) {
        this.direction.put(language, direction);
        return this;
    }

    public HashMap<String, String> getDirectionOfSample() {
        return direction;
    }
}
