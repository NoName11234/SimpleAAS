package org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.guidelinespecificproperty;

import java.util.HashMap;

public class GuidelineSpecificPropertyCollection {
    private final String guidelineForConformityDeclaration;
    private final HashMap<String, String> arbitraryProperties = new HashMap<>();

    public GuidelineSpecificPropertyCollection(String guidelineForConformityDeclaration) {
        this.guidelineForConformityDeclaration = guidelineForConformityDeclaration;
    }

    public String getGuidelineForConformityDeclaration() {
        return this.guidelineForConformityDeclaration;
    }

    public GuidelineSpecificPropertyCollection addArbitraryProperty(String shortId, String value) {
        this.arbitraryProperties.put(shortId, value);
        return this;
    }

    public HashMap<String, String> getArbitraryProperties() {
        return this.arbitraryProperties;
    }

    public boolean areArbitraryPropertiesPresent() {
        return !this.arbitraryProperties.isEmpty();
    }
}
