package org.simpleaas.contactinformation.contactinformation1_0.fax;

import java.util.Optional;

public enum TypeOfFaxNumber {
    Office("0173-1#07-AAS754#001"),
    Secretary("0173-1#07-AAS756#001"),
    Home("0173-1#07-AAS758#001");

    private final String type;

    TypeOfFaxNumber(String type) {
        this.type = type;
    }

    public String getSemanticId() {
        return this.type;
    }

    public static Optional<TypeOfFaxNumber> createFromSemanticId(String semanticId) {

        switch (semanticId) {
            case "0173-1#07-AAS754#001" -> {
                return Optional.of(TypeOfFaxNumber.Office);
            }
            case "0173-1#07-AAS756#001" -> {
                return Optional.of(TypeOfFaxNumber.Secretary);
            }
            case "0173-1#07-AAS758#001" -> {
                return Optional.of(TypeOfFaxNumber.Home);
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
