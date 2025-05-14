package org.simpleaas.nameplate.nameplate3_0.assetspecificproperty;

import org.simpleaas.helper.FileModel;

import java.util.HashMap;

/**
 * Represents an asset specific property.
 */
public class AssetSpecificPropertyCollection {
    private final HashMap<String, String> arbitraryProperties = new HashMap<>();
    private final HashMap<String, HashMap<String, String>> arbitraryMlps = new HashMap<>();
    private final HashMap<String, FileModel> arbitraryFiles = new HashMap<>();
    private final HashMap<String, GuidelineSpecificPropertyCollection> guidelineSpecificProperties = new HashMap<>();

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

    public AssetSpecificPropertyCollection addArbitraryMlp(String shortId, HashMap<String, String> values) {
        this.arbitraryMlps.put(shortId, values);
        return this;
    }

    public HashMap<String, HashMap<String, String>> getArbitraryMlps() {
        return this.arbitraryMlps;
    }

    public boolean areArbitraryMlpsPresent() {
        return !this.arbitraryMlps.isEmpty();
    }

    public AssetSpecificPropertyCollection addArbitraryFile(String shortId, FileModel file) {
        this.arbitraryFiles.put(shortId, file);
        return this;
    }

    public HashMap<String, FileModel> getArbitraryFiles() {
        return this.arbitraryFiles;
    }

    public boolean areArbitraryFilesPresent() {
        return !this.arbitraryFiles.isEmpty();
    }

    public AssetSpecificPropertyCollection addGuidelineSpecificProperty(String shortId, GuidelineSpecificPropertyCollection guidelineSpecificPropertyCollection) {
        this.guidelineSpecificProperties.put(shortId, guidelineSpecificPropertyCollection);
        return this;
    }

    public HashMap<String, GuidelineSpecificPropertyCollection> getGuidelineSpecificProperties() {
        return this.guidelineSpecificProperties;
    }

    public boolean areGuidelineSpecificPropertiesPresent() {
        return !this.guidelineSpecificProperties.isEmpty();
    }
}
