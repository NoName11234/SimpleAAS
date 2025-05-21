package org.simpleaas.inspectiondocumentssteelproducts;

import java.util.HashMap;

public class Customer {
    private final String shortId;
    private final String companyName;
    private final HashMap<String, String> customerRoles = new HashMap<>();
    private final String street;
    private final String zipCode;
    private final String city;
    private final String nationalCode;
    private final HashMap<String, String> mailAddresses = new HashMap<>();

    public Customer(String shortId, String companyName, String street, String zipCode, String city, String nationalCode) {
        this.shortId = shortId;
        this.companyName = companyName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.nationalCode = nationalCode;
    }

    public String getShortId() {
        return shortId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Customer addCustomerRole(String shortId, String customerRole) {
        this.customerRoles.put(shortId, customerRole);
        return this;
    }

    public HashMap<String, String> getCustomerRoles() {
        return customerRoles;
    }

    public boolean areCustomerRolesPresent() {
        return !this.customerRoles.isEmpty();
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

    public Customer addMailAddress(String shortId, String mailAddress) {
        this.mailAddresses.put(shortId, mailAddress);
        return this;
    }

    public HashMap<String, String> getMailAddresses() {
        return mailAddresses;
    }

    public boolean areMailAddressesPresent() {
        return !this.mailAddresses.isEmpty();
    }
}
