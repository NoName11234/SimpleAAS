package org.simpleaas.nameplate.nameplate2_0.assetspecificproperty;

import org.eclipse.digitaltwin.aas4j.v3.model.Property;
import org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.guidelinespecificproperty.GuidelineSpecificPropertyCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetSpecificPropertyCollection {
    private final List<Property> arbitraryProperties = new ArrayList<>();
    private final HashMap<String, GuidelineSpecificPropertyCollection> guidelineSpecificPropertyCollections = new HashMap<>();

    public AssetSpecificPropertyCollection addArbitraryProperty(Property property) {
        this.arbitraryProperties.add(property);
        return this;
    }

    public List<Property> getArbitraryProperties() {
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