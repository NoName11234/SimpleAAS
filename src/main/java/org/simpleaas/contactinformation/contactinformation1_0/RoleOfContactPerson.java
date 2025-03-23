package org.simpleaas.contactinformation.contactinformation1_0;

public enum RoleOfContactPerson {
    AdministrativeContact("0173-1#07-AAS927#001"),
    CommercialContact("0173-1#07-AAS928#001"),
    OtherContact("0173-1#07-AAS929#001"),
    HazardousGoodsContact("0173-1#07-AAS930#001"),
    TechnicalContact("0173-1#07-AAS931#001");

    private final String type;

    RoleOfContactPerson(String type) {
        this.type = type;
    }

    public String getSemanticId() {
        return this.type;
    }
}
