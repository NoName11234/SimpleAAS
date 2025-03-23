package org.simpleaas.contactinformation.contactinformation1_0.email;

public enum TypeOfEmailAddress {
    Office("0173-1#07-AAS754#001"),
    Secretary("0173-1#07-AAS756#001"),
    Substitute("0173-1#07-AAS757#001"),
    Home("0173-1#07-AAS758#001");

    private final String type;

    TypeOfEmailAddress(String type) {
        this.type = type;
    }

    public String getSemanticId() {
        return this.type;
    }
}
