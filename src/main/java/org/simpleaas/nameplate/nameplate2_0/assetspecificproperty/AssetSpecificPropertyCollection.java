package org.simpleaas.nameplate.nameplate2_0.assetspecificproperty;

import org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.guidelinespecificproperty.GuidelineSpecificPropertyCollection;

import java.util.HashMap;

public class AssetSpecificPropertyCollection {
    private final HashMap<String, String> arbitraryProperties = new HashMap<>();
    private final HashMap<String, GuidelineSpecificPropertyCollection> guidelineSpecificPropertyCollections = new HashMap<>();

    public AssetSpecificPropertyCollection addArbitraryProperty(String shortId, String value) {
        this.arbitraryProperties.put(shortId, value);
        return this;
    }

    public HashMap<String, String> getArbitraryProperties() {
        return this.arbitraryProperties;
    }

    public boolean areArbitraryPropertiesPresent() {
        return !this.arbitraryProperties.isEmpty();
    }

    public AssetSpecificPropertyCollection addGuidelineSpecificPropertyCollection(String shortId, GuidelineSpecificPropertyCollection collection) {
        this.guidelineSpecificPropertyCollections.put(shortId, collection);
        return this;
    }

    public HashMap<String, GuidelineSpecificPropertyCollection> getGuidelineSpecificPropertyCollections() {
        return this.guidelineSpecificPropertyCollections;
    }

    public boolean areGuidelineSpecificPropertyCollectionsPresent() {
        return !this.guidelineSpecificPropertyCollections.isEmpty();
    }
}