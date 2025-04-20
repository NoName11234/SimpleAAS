package org.simpleaas.nameplate.nameplate3_0.assetspecificproperty;

import org.simpleaas.helper.FileModel;

import java.util.HashMap;

/**
 * Represents an asset specific property.
 */
public class AssetSpecificProperty {
    private final HashMap<String, String> arbitraryProperties = new HashMap<>();
    private final HashMap<String, HashMap<String, String>> arbitraryMlps = new HashMap<>();
    private final HashMap<String, FileModel> arbitraryFiles = new HashMap<>();
    private final HashMap<String, GuidelineSpecificProperty> guidelineSpecificProperties = new HashMap<>();

    public AssetSpecificProperty addArbitraryProperty(String shortId, String value) {
        this.arbitraryProperties.put(shortId, value);
        return this;
    }

    public HashMap<String, String> getArbitraryProperties() {
        return this.arbitraryProperties;
    }

    public boolean areArbitraryPropertiesPresent() {
        return !this.arbitraryProperties.isEmpty();
    }

    public AssetSpecificProperty addArbitraryMlp(String shortId, HashMap<String, String> values) {
        this.arbitraryMlps.put(shortId, values);
        return this;
    }

    public HashMap<String, HashMap<String, String>> getArbitraryMlps() {
        return this.arbitraryMlps;
    }

    public boolean areArbitraryMlpsPresent() {
        return !this.arbitraryMlps.isEmpty();
    }

    public AssetSpecificProperty addArbitraryFile(String shortId, FileModel file) {
        this.arbitraryFiles.put(shortId, file);
        return this;
    }

    public HashMap<String, FileModel> getArbitraryFiles() {
        return this.arbitraryFiles;
    }

    public boolean areArbitraryFilesPresent() {
        return !this.arbitraryFiles.isEmpty();
    }

    public AssetSpecificProperty addGuidelineSpecificProperty(String shortId, GuidelineSpecificProperty guidelineSpecificProperty) {
        this.guidelineSpecificProperties.put(shortId, guidelineSpecificProperty);
        return this;
    }

    public HashMap<String, GuidelineSpecificProperty> getGuidelineSpecificProperties() {
        return this.guidelineSpecificProperties;
    }

    public boolean areGuidelineSpecificPropertiesPresent() {
        return !this.guidelineSpecificProperties.isEmpty();
    }
}
