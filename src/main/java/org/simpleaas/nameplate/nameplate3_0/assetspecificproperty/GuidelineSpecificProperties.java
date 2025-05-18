package org.simpleaas.nameplate.nameplate3_0.assetspecificproperty;

import org.simpleaas.helper.FileModel;

import java.util.HashMap;

/**
 * Represents a guideline specific property.
 */
public class GuidelineSpecificProperties {
    private final String guidelineForConformityDeclaration;
    private final HashMap<String, String> arbitraryProperties = new HashMap<>();
    private final HashMap<String, FileModel> arbitraryFiles = new HashMap<>();
    private final HashMap<String, HashMap<String, String>> arbitraryMlps = new HashMap<>();

    public GuidelineSpecificProperties(String guidelineForConformityDeclaration) {
        this.guidelineForConformityDeclaration = guidelineForConformityDeclaration;
    }

    public String getGuidelineForConformityDeclaration() {
        return this.guidelineForConformityDeclaration;
    }

    public GuidelineSpecificProperties addArbitraryProperty(String shortId, String value) {
        this.arbitraryProperties.put(shortId, value);
        return this;
    }

    public HashMap<String, String> getArbitraryProperties() {
        return this.arbitraryProperties;
    }

    public boolean areArbitraryPropertiesPresent() {
        return !this.arbitraryProperties.isEmpty();
    }

    public GuidelineSpecificProperties addArbitraryFile(String shortId, FileModel file) {
        this.arbitraryFiles.put(shortId, file);
        return this;
    }

    public HashMap<String, FileModel> getArbitraryFiles() {
        return this.arbitraryFiles;
    }

    public boolean areArbitraryFilesPresent() {
        return !this.arbitraryFiles.isEmpty();
    }

    public GuidelineSpecificProperties addArbitraryMlp(String shortId, HashMap<String, String> values) {
        this.arbitraryMlps.put(shortId, values);
        return this;
    }

    public HashMap<String, HashMap<String, String>> getArbitraryMlps() {
        return this.arbitraryMlps;
    }

    public boolean areArbitraryMlpsPresent() {
        return !this.arbitraryMlps.isEmpty();
    }
}
