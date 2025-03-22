package org.simpleaas.contactinformation.contactinformation1_0.fax;

import java.util.HashMap;
import java.util.Optional;

public class Fax {
    private HashMap<String, String> faxNumber = new HashMap<>();
    private TypeOfFaxNumber typeOfFaxNumber = null;

    public Fax(String language, String faxNumber) {
        this.faxNumber.put(language, faxNumber);
    }

    public Fax(HashMap<String, String> faxNumber) {
        this.faxNumber.putAll(faxNumber);
    }

    public Fax addFaxNumber(String language, String faxNumber) {
        this.faxNumber.put(language, faxNumber);
        return this;
    }

    public HashMap<String, String> getFaxNumber() {
        return this.faxNumber;
    }

    public Fax setTypeOfFaxNumber(TypeOfFaxNumber typeOfFaxNumber) {
        this.typeOfFaxNumber = typeOfFaxNumber;
        return this;
    }

    public Optional<TypeOfFaxNumber> getTypeOfFaxNumber() {
        return Optional.ofNullable(this.typeOfFaxNumber);
    }
}
