package org.simpleaas.contactinformation.contactinformation1_0.phone;

import java.util.HashMap;
import java.util.Optional;

public class Phone {
    private final HashMap<String, String> telephoneNumber = new HashMap<>();
    private TypeOfTelephone typeOfTelephone = null;
    private HashMap<String, String> availableTime = new HashMap<>();

    public Phone(String language, String telephoneNumber) {
        this.telephoneNumber.put(language, telephoneNumber);
    }

    public Phone(HashMap<String, String> telephoneNumber) {
        this.telephoneNumber.putAll(telephoneNumber);
    }

    public Phone addTelephoneNumber(String language, String telephoneNumber) {
        this.telephoneNumber.put(language, telephoneNumber);
        return this;
    }

    public HashMap<String, String> getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public Optional<TypeOfTelephone> getTypeOfTelephone() {
        return Optional.ofNullable(this.typeOfTelephone);
    }

    public Phone setTypeOfTelephone(TypeOfTelephone typeOfTelephone) {
        this.typeOfTelephone = typeOfTelephone;
        return this;
    }

    public HashMap<String, String> getAvailableTime() {
        return availableTime;
    }

    public Phone addAvailableTime(String language, String availableTime) {
        this.availableTime.put(language, availableTime);
        return this;
    }

    public Phone setAvailableTime(HashMap<String, String> availableTime) {
        this.availableTime = availableTime;
        return this;
    }
}
