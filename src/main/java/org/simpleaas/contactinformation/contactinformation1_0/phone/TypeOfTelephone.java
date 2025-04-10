package org.simpleaas.contactinformation.contactinformation1_0.phone;

import java.util.Optional;

public enum TypeOfTelephone {
    Office("0173-1#07-AAS754#001"),
    OfficeMobile("0173-1#07-AAS755#001"),
    Secretary("0173-1#07-AAS756#001"),
    Substitute("0173-1#07-AAS757#001"),
    Home("0173-1#07-AAS758#001"),
    PrivateMobile("0173-1#07-AAS759#001");

    private final String type;

    TypeOfTelephone(String type) {
        this.type = type;
    }

    public String getSemanticId() {
        return this.type;
    }

    public static Optional<TypeOfTelephone> createFromSemanticId(String semanticId) {

        switch (semanticId) {
            case "0173-1#07-AAS754#001" -> {
                return Optional.of(TypeOfTelephone.Office);
            }
            case "0173-1#07-AAS755#001" -> {
                return Optional.of(TypeOfTelephone.OfficeMobile);
            }
            case "0173-1#07-AAS756#001" -> {
                return Optional.of(TypeOfTelephone.Secretary);
            }
            case "0173-1#07-AAS757#001" -> {
                return Optional.of(TypeOfTelephone.Substitute);
            }
            case "0173-1#07-AAS758#001" -> {
                return Optional.of(TypeOfTelephone.Home);
            }
            case "0173-1#07-AAS759#001" -> {
                return Optional.of(TypeOfTelephone.PrivateMobile);
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
