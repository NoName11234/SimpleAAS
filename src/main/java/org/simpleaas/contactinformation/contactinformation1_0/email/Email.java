package org.simpleaas.contactinformation.contactinformation1_0.email;

import java.util.HashMap;
import java.util.Optional;

public class Email {
    private final String emailAddress;
    private HashMap<String, String> publicKey = new HashMap<>();
    private TypeOfEmailAddress typeOfEmailAddress = null;
    private HashMap<String, String> typeOfPublicKey = new HashMap<>();

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public Email setPublicKey(HashMap<String, String> publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public Email addPublicKey(String language, String publicKey) {
        this.publicKey.put(language, publicKey);
        return this;
    }

    public HashMap<String, String> getPublicKey() {
        return this.publicKey;
    }

    public Email setTypeOfEmailAddress(TypeOfEmailAddress typeOfEmailAddress) {
        this.typeOfEmailAddress = typeOfEmailAddress;
        return this;
    }

    public Optional<TypeOfEmailAddress> getTypeOfEmailAddress() {
        return Optional.ofNullable(this.typeOfEmailAddress);
    }

    public Email setTypeOfPublicKey(HashMap<String, String> typeOfPublicKey) {
        this.typeOfPublicKey = typeOfPublicKey;
        return this;
    }

    public Email addTypeOfPublicKey(String language, String typeOfPublicKey) {
        this.typeOfPublicKey.put(language, typeOfPublicKey);
        return this;
    }

    public HashMap<String, String> getTypeOfPublicKey() {
        return typeOfPublicKey;
    }
}
