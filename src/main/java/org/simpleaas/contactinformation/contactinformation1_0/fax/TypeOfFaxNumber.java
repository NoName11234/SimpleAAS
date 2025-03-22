package org.simpleaas.contactinformation.contactinformation1_0.fax;

public enum TypeOfFaxNumber {
    Office("0173-1#07-AAS754#001"),
    Secretary("0173-1#07-AAS756#001"),
    Home("0173-1#07-AAS758#001");

    private final String type;

    private TypeOfFaxNumber(String type) {
        this.type = type;
    }

    public String getSemanticId() {
        return this.type;
    }
}
