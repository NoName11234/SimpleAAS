package org.simpleaas.contactinformation.contactinformation1_0.ipcommunication;

import java.util.HashMap;
import java.util.Optional;

public class IpCommunication {
    private final String addressOfAdditionalLink;
    private TypeOfCommunication typeOfCommunication = null;
    private HashMap<String, String> availableTime = new HashMap<>();

    public IpCommunication(String addressOfAdditionalLink) {
        this.addressOfAdditionalLink = addressOfAdditionalLink;
    }

    public String getAddressOfAdditionalLink() {
        return addressOfAdditionalLink;
    }

    public IpCommunication setTypeOfCommunication(TypeOfCommunication typeOfCommunication) {
        this.typeOfCommunication = typeOfCommunication;
        return this;
    }

    public Optional<TypeOfCommunication> getTypeOfCommunication() {
        return Optional.ofNullable(this.typeOfCommunication);
    }

    public IpCommunication setAvailableTime(HashMap<String, String> availableTime) {
        this.availableTime = availableTime;
        return this;
    }

    public IpCommunication addAvailableTime(String language, String availableTime) {
        this.availableTime.put(language, availableTime);
        return this;
    }

    public HashMap<String, String> getAvailableTime() {
        return availableTime;
    }
}
