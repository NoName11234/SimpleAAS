package org.simpleaas.inspectiondocumentssteelproducts.data;

import java.util.HashMap;

public class Manufacturer {
    private final String companyName;
    private final String street;
    private final String zipCode;
    private final String city;
    private final String nationalCode;
    private final HashMap<String, String> mailAddresses = new HashMap<>();

    public Manufacturer(String companyName, String street, String zipCode, String city, String nationalCode) {
        this.companyName = companyName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.nationalCode = nationalCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public HashMap<String, String> getMailAddresses() {
        return mailAddresses;
    }

    public Manufacturer addMailAddress(String shortId, String mailAddress) {
        this.mailAddresses.put(shortId, mailAddress);
        return this;
    }

    public boolean areMailAddressesPresent() {
        return !this.mailAddresses.isEmpty();
    }
}
