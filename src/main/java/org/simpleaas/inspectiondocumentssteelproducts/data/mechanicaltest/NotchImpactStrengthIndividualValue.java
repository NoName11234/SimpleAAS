package org.simpleaas.inspectiondocumentssteelproducts.data.mechanicaltest;

public class NotchImpactStrengthIndividualValue {
    private final String shortId;
    private final String individualValue;

    public NotchImpactStrengthIndividualValue(String shortId, String individualValue) {
        this.shortId = shortId;
        this.individualValue = individualValue;
    }

    public String getShortId() {
        return this.shortId;
    }

    public String getIndividualValue() {
        return this.individualValue;
    }
}
