package org.simpleaas.contactinformation.contactinformation1_0;

import java.util.Optional;

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

    public static Optional<RoleOfContactPerson> createFromSemanticId(String semanticId) {
        switch (semanticId) {
            case "0173-1#07-AAS927#001" -> {
                return Optional.of(RoleOfContactPerson.AdministrativeContact);
            }
            case "0173-1#07-AAS928#001" -> {
                return Optional.of(RoleOfContactPerson.CommercialContact);
            }
            case "0173-1#07-AAS929#001" -> {
                return Optional.of(RoleOfContactPerson.OtherContact);
            }
            case "0173-1#07-AAS930#001" -> {
                return Optional.of(RoleOfContactPerson.HazardousGoodsContact);
            }
            case "0173-1#07-AAS931#001" -> {
                return Optional.of(RoleOfContactPerson.TechnicalContact);
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
