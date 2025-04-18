package org.simpleaas.contactinformation.contactinformation1_0;

import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.phone.Phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ContactInformation {
    private String shortId;
    private RoleOfContactPerson roleOfContactPerson = null;
    private HashMap<String, String> nationalCode = new HashMap<>();
    private HashMap<String, String> language = new HashMap<>();
    private String timeZone = null;
    private HashMap<String, String> cityTown = new HashMap<>();
    private HashMap<String, String> company = new HashMap<>();
    private HashMap<String, String> department = new HashMap<>();
    private Phone phone = null;
    private Fax fax = null;
    private Email email = null;
    private List<IpCommunication> ipCommunications = new ArrayList<>();
    private HashMap<String, String> street = new HashMap<>();
    private HashMap<String, String> zipCode = new HashMap<>();
    private HashMap<String, String> poBox = new HashMap<>();
    private HashMap<String, String> zipCodeOfPoBox = new HashMap<>();
    private HashMap<String, String> stateCounty = new HashMap<>();
    private HashMap<String, String> nameOfContact = new HashMap<>();
    private HashMap<String, String> firstName = new HashMap<>();
    private HashMap<String, String> middleName = new HashMap<>();
    private HashMap<String, String> title = new HashMap<>();
    private HashMap<String, String> academicTitle = new HashMap<>();
    private HashMap<String, String> furtherDetailsOfContact = new HashMap<>();
    private String addressOfAdditionalLink = null;

    public ContactInformation(String shortId) {
        this.shortId = shortId;
    }

    public ContactInformation setRoleOfContactPerson(RoleOfContactPerson roleOfContactPerson) {
        this.roleOfContactPerson = roleOfContactPerson;
        return this;
    }

    public Optional<RoleOfContactPerson> getRoleOfContactPerson() {
        return Optional.ofNullable(this.roleOfContactPerson);
    }

    public ContactInformation setNationalCode(HashMap<String, String> nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public ContactInformation addNationalCode(String language, String nationalCode) {
        this.nationalCode.put(language, nationalCode);
        return this;
    }

    public HashMap<String, String> getNationalCode() {
        return this.nationalCode;
    }

    public ContactInformation setLanguage(HashMap<String, String> language) {
        this.language = language;
        return this;
    }

    public ContactInformation addLanguage(String shortId, String language) {
        this.language.put(shortId, language);
        return this;
    }

    public HashMap<String, String> getLanguage() {
        return this.language;
    }

    public ContactInformation setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public Optional<String> getTimeZone() {
        return Optional.ofNullable(this.timeZone);
    }

    public ContactInformation setCityTown(HashMap<String, String> cityTown) {
        this.cityTown = cityTown;
        return this;
    }

    public ContactInformation addCityTown(String language, String cityTown) {
        this.cityTown.put(language,cityTown);
        return this;
    }

    public HashMap<String, String> getCityTown() {
        return this.cityTown;
    }

    public ContactInformation setCompany(HashMap<String, String> company) {
        this.company = company;
        return this;
    }

    public ContactInformation addCompany(String language, String company) {
        this.company.put(language, company);
        return this;
    }

    public HashMap<String, String> getCompany() {
        return this.company;
    }

    public ContactInformation setDepartment(HashMap<String, String> department) {
        this.department = department;
        return this;
    }

    public ContactInformation addDepartment(String language, String department) {
        this.department.put(language, department);
        return this;
    }

    public HashMap<String, String> getDepartment() {
        return this.department;
    }

    public ContactInformation setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public Optional<Phone> getPhone() {
        return Optional.ofNullable(this.phone);
    }

    public ContactInformation setFax(Fax fax) {
        this.fax = fax;
        return this;
    }

    public Optional<Fax> getFax() {
        return Optional.ofNullable(this.fax);
    }

    public ContactInformation setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Optional<Email> getEmail() {
        return Optional.ofNullable(this.email);
    }

    public ContactInformation setIpCommunication(List<IpCommunication> ipCommunications) {
        this.ipCommunications = ipCommunications;
        return this;
    }

    public ContactInformation addIpCommunication(IpCommunication ipCommunication) {
        this.ipCommunications.add(ipCommunication);
        return this;
    }

    public List<IpCommunication> getIpCommunications() {
        return this.ipCommunications;
    }

    public ContactInformation setStreet(HashMap<String, String> street) {
        this.street = street;
        return this;
    }

    public ContactInformation addStreet(String language, String street) {
        this.street.put(language, street);
        return this;
    }

    public HashMap<String, String> getStreet() {
        return this.street;
    }

    public ContactInformation setZipCode(HashMap<String, String> zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public ContactInformation addZipCode(String language, String zipCode) {
        this.street.put(language, zipCode);
        return this;
    }

    public HashMap<String, String> getZipCode() {
        return this.zipCode;
    }

    public ContactInformation setPoBox(HashMap<String, String> poBox) {
        this.poBox = poBox;
        return this;
    }

    public ContactInformation addPoBox(String language, String poBox) {
        this.poBox.put(language, poBox);
        return this;
    }

    public HashMap<String, String> getPoBox() {
        return this.poBox;
    }

    public ContactInformation setZipCodeOfPoBox(HashMap<String, String> zipCodeOfPoBox) {
        this.zipCodeOfPoBox = zipCodeOfPoBox;
        return this;
    }

    public ContactInformation addZipCodeOfPoBox(String language, String zipCodeOfPoBox) {
        this.zipCodeOfPoBox.put(language, zipCodeOfPoBox);
        return this;
    }

    public HashMap<String, String> getZipCodeOfPoBox() {
        return this.zipCodeOfPoBox;
    }

    public ContactInformation setStateCounty(HashMap<String, String> stateCounty) {
        this.stateCounty = stateCounty;
        return this;
    }

    public ContactInformation addStateCounty(String language, String stateCounty) {
        this.stateCounty.put(language, stateCounty);
        return this;
    }

    public HashMap<String, String> getStateCounty() {
        return this.stateCounty;
    }

    public ContactInformation setNameOfContact(HashMap<String, String> nameOfContact) {
        this.nameOfContact = nameOfContact;
        return this;
    }

    public ContactInformation addNameOfContact(String language, String nameOfContact) {
        this.nameOfContact.put(language, nameOfContact);
        return this;
    }

    public HashMap<String, String> getNameOfContact() {
        return this.nameOfContact;
    }

    public ContactInformation setFirstName(HashMap<String, String> firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactInformation addFirstName(String language, String firstName) {
        this.firstName.put(language, firstName);
        return this;
    }

    public HashMap<String, String> getFirstName() {
        return this.firstName;
    }

    public ContactInformation setMiddleName(HashMap<String, String> middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactInformation addMiddleName(String language, String middleName) {
        this.middleName.put(language, middleName);
        return this;
    }

    public HashMap<String, String> getMiddleName() {
        return this.middleName;
    }

    public ContactInformation setTitle(HashMap<String, String> title) {
        this.title = title;
        return this;
    }

    public ContactInformation addTitle(String language, String title) {
        this.title.put(language, title);
        return this;
    }

    public HashMap<String, String> getTitle() {
        return this.title;
    }

    public ContactInformation setAcademicTitle(HashMap<String, String> academicTitle) {
        this.academicTitle = academicTitle;
        return this;
    }

    public ContactInformation addAcademicTitle(String language, String academicTitle) {
        this.academicTitle.put(language, academicTitle);
        return this;
    }

    public HashMap<String, String> getAcademicTitle() {
        return this.academicTitle;
    }

    public ContactInformation setFurtherDetailsOfContact(HashMap<String, String> furtherDetailsOfContact) {
        this.furtherDetailsOfContact = furtherDetailsOfContact;
        return this;
    }

    public ContactInformation addFurtherDetailsOfContact(String language, String furtherDetailsOfContact) {
        this.furtherDetailsOfContact.put(language, furtherDetailsOfContact);
        return this;
    }

    public HashMap<String, String> getFurtherDetailsOfContact() {
        return this.furtherDetailsOfContact;
    }

    public ContactInformation setAddressOfAdditionalLink(String addressOfAdditionalLink) {
        this.addressOfAdditionalLink = addressOfAdditionalLink;
        return this;
    }

    public Optional<String> getAddressOfAdditionalLink() {
        return Optional.ofNullable(this.addressOfAdditionalLink);
    }

    public String getShortId() {
        return shortId;
    }

    public ContactInformation setShortId(String shortId) {
        this.shortId = shortId;
        return this;
    }
}
