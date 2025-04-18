package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.simpleaas.contactinformation.ContactInformationConstants;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.email.TypeOfEmailAddress;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.fax.TypeOfFaxNumber;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.TypeOfCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.phone.Phone;
import org.simpleaas.contactinformation.contactinformation1_0.phone.TypeOfTelephone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ContactInformationReader1_0 {
    private final Submodel submodel;

    public ContactInformationReader1_0(Submodel submodel) {
        this.submodel = submodel;
    }

    public static ContactInformation convertSMCtoContactInformation(SubmodelElementCollection contactInformationSMC) {
        //create reader with empty submodel
        ContactInformationReader1_0 contactInformationReader = new ContactInformationReader1_0(new DefaultSubmodel.Builder().build());

        return contactInformationReader.getContactInformation(contactInformationSMC);
    }

    public List<ContactInformation> getContactInformation() {

        return this.submodel.getSubmodelElements().stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .map(this::getContactInformation)
                .toList();
    }

    private ContactInformation getContactInformation(SubmodelElementCollection contactInformationSmc) {
        ContactInformation contactInformation = new ContactInformation(contactInformationSmc.getIdShort());

        //get role of contact person
        List<SubmodelElement> roleOfContactPersonSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.roleOfContactPerson, contactInformationSmc.getValue());

        if(!roleOfContactPersonSEs.isEmpty()) {
            Property roleOfContactPersonProperty = (Property) roleOfContactPersonSEs.getFirst();
            Optional<RoleOfContactPerson> optRoleOfContactPerson = RoleOfContactPerson.createFromSemanticId(roleOfContactPersonProperty.getValue());

            if(optRoleOfContactPerson.isPresent()) {
                contactInformation.setRoleOfContactPerson(optRoleOfContactPerson.get());
            }
        }

        //get national code
        List<SubmodelElement> nationalCodeSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.nationalCode, contactInformationSmc.getValue());

        if(!nationalCodeSEs.isEmpty()) {
            MultiLanguageProperty nationalCodeMlp = (MultiLanguageProperty) nationalCodeSEs.getFirst();
            HashMap<String, String> nationalCode = convertMlpToHashmap(nationalCodeMlp.getValue());

            contactInformation.setNationalCode(nationalCode);
        }

        //get language
        List<SubmodelElement> languageSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.language, contactInformationSmc.getValue());

        for(SubmodelElement languageSE: languageSEs) {
            Property languageProperty = (Property) languageSE;
            contactInformation.addLanguage(languageProperty.getIdShort(), languageProperty.getValue());
        }

        //get time zone
        List<SubmodelElement> timeZoneSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.timeZone, contactInformationSmc.getValue());

        if(!timeZoneSEs.isEmpty()) {
            Property timeZoneProperty = (Property) timeZoneSEs.getFirst();
            contactInformation.setTimeZone(timeZoneProperty.getValue());
        }

        //get city town
        List<SubmodelElement> cityTownSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.cityTown, contactInformationSmc.getValue());

        if(!cityTownSEs.isEmpty()) {
            MultiLanguageProperty cityTownMlp = (MultiLanguageProperty) cityTownSEs.getFirst();
            contactInformation.setCityTown(convertMlpToHashmap(cityTownMlp.getValue()));
        }

        //get company
        List<SubmodelElement> companySEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.company, contactInformationSmc.getValue());

        if (!companySEs.isEmpty()) {
            MultiLanguageProperty companyMlp = (MultiLanguageProperty) companySEs.getFirst();
            contactInformation.setCompany(convertMlpToHashmap(companyMlp.getValue()));
        }

        //get department
        List<SubmodelElement> departmentSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.department, contactInformationSmc.getValue());

        if(!departmentSEs.isEmpty()) {
            MultiLanguageProperty departmentMlp = (MultiLanguageProperty) departmentSEs.getFirst();
            contactInformation.setDepartment(convertMlpToHashmap(departmentMlp.getValue()));
        }

        //get phone
        List<SubmodelElement> phoneSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.id, contactInformationSmc.getValue());

        if(!phoneSEs.isEmpty()) {
            Optional<Phone> optPhone = convertSmcToPhone((SubmodelElementCollection) phoneSEs.getFirst());

            if(optPhone.isPresent()) {
                contactInformation.setPhone(optPhone.get());
            }
        }

        //get fax
        List<SubmodelElement> faxSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.id, contactInformationSmc.getValue());

        if(!faxSEs.isEmpty()) {
            Optional<Fax> optFax = convertSmcToFax((SubmodelElementCollection) phoneSEs.getFirst());

            if(optFax.isPresent()) {
                contactInformation.setFax(optFax.get());
            }
        }

        //get email
        List<SubmodelElement> emailSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.id, contactInformationSmc.getValue());

        if(!emailSEs.isEmpty()) {
            Optional<Email> optEmail = convertSmcToEmail((SubmodelElementCollection) emailSEs.getFirst());

            if(optEmail.isPresent()) {
                contactInformation.setEmail(optEmail.get());
            }
        }

        //get ip communications
        List<SubmodelElement> ipCommunicationSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.id, contactInformationSmc.getValue());

        for(SubmodelElement ipCommunicationSE: ipCommunicationSEs) {
            Optional<IpCommunication> optIpCommunication = convertSmcToIpCommunication((SubmodelElementCollection) ipCommunicationSE);

            if(optIpCommunication.isPresent()) {
                contactInformation.addIpCommunication(optIpCommunication.get());
            }
        }

        //get street
        List<SubmodelElement> streetSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.street, contactInformationSmc.getValue());

        if(!streetSEs.isEmpty()) {
            MultiLanguageProperty streetMlp = (MultiLanguageProperty) streetSEs.getFirst();
            contactInformation.setStreet(convertMlpToHashmap(streetMlp.getValue()));
        }

        //get zipcode
        List<SubmodelElement> zipCodeSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipcode, contactInformationSmc.getValue());

        if(!streetSEs.isEmpty()) {
            MultiLanguageProperty zipCodeMlp = (MultiLanguageProperty) zipCodeSEs.getFirst();
            contactInformation.setZipCode(convertMlpToHashmap(zipCodeMlp.getValue()));
        }

        //get pobox
        List<SubmodelElement> poBoxSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.poBox, contactInformationSmc.getValue());

        if(!poBoxSEs.isEmpty()) {
            MultiLanguageProperty poBoxMlp = (MultiLanguageProperty) poBoxSEs.getFirst();
            contactInformation.setPoBox(convertMlpToHashmap(poBoxMlp.getValue()));
        }

        //get zipcode of pobox
        List<SubmodelElement> zipCodePoBoxSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipCodeOfPoBox, contactInformationSmc.getValue());

        if(!zipCodePoBoxSEs.isEmpty()) {
            MultiLanguageProperty zipCodePoBoxMlp = (MultiLanguageProperty) zipCodePoBoxSEs.getFirst();
            contactInformation.setZipCodeOfPoBox(convertMlpToHashmap(zipCodePoBoxMlp.getValue()));
        }

        //get state county
        List<SubmodelElement> stateCountySEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.stateCounty, contactInformationSmc.getValue());

        if(!stateCountySEs.isEmpty()) {
            MultiLanguageProperty stateCountyMlp = (MultiLanguageProperty) stateCountySEs.getFirst();
            contactInformation.setStateCounty(convertMlpToHashmap(stateCountyMlp.getValue()));
        }

        //get name of contact
        List<SubmodelElement> nameOfContactSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.nameOfContact, contactInformationSmc.getValue());

        if(!nameOfContactSEs.isEmpty()) {
            MultiLanguageProperty nameOfContactMlp = (MultiLanguageProperty) nameOfContactSEs.getFirst();
            contactInformation.setNameOfContact(convertMlpToHashmap(nameOfContactMlp.getValue()));
        }

        //get first name
        List<SubmodelElement> firstNameSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.firstName, contactInformationSmc.getValue());

        if(!firstNameSEs.isEmpty()) {
            MultiLanguageProperty firstNameMlp = (MultiLanguageProperty) nameOfContactSEs.getFirst();
            contactInformation.setFirstName(convertMlpToHashmap(firstNameMlp.getValue()));
        }

        //get middle names
        List<SubmodelElement> middleNameSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.middleNames, contactInformationSmc.getValue());

        if(!middleNameSEs.isEmpty()) {
            MultiLanguageProperty middleNameMlp = (MultiLanguageProperty) middleNameSEs.getFirst();
            contactInformation.setMiddleName(convertMlpToHashmap(middleNameMlp.getValue()));
        }

        //get title
        List<SubmodelElement> titleSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.title, contactInformationSmc.getValue());

        if(!titleSEs.isEmpty()) {
            MultiLanguageProperty titleMlp = (MultiLanguageProperty) titleSEs.getFirst();
            contactInformation.setTitle(convertMlpToHashmap(titleMlp.getValue()));
        }

        //get academic title
        List<SubmodelElement> academicTitleSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.academicTitle, contactInformationSmc.getValue());

        if(!academicTitleSEs.isEmpty()) {
            MultiLanguageProperty academicTitleMlp = (MultiLanguageProperty) academicTitleSEs.getFirst();
            contactInformation.setAcademicTitle(convertMlpToHashmap(academicTitleMlp.getValue()));
        }

        //get further details of contact
        List<SubmodelElement> furtherDetailsOfContactSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.furtherDetailsOfContact, contactInformationSmc.getValue());

        if(!furtherDetailsOfContactSEs.isEmpty()) {
            MultiLanguageProperty furtherDetailsOfContactMlp = (MultiLanguageProperty) furtherDetailsOfContactSEs.getFirst();
            contactInformation.setFurtherDetailsOfContact(convertMlpToHashmap(furtherDetailsOfContactMlp.getValue()));
        }

        //get address of additional link
        List<SubmodelElement> addressOfAdditionalLinkSEs = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.addressOfAdditionalLink, contactInformationSmc.getValue());

        if(!addressOfAdditionalLinkSEs.isEmpty()) {
            Property addressOfAdditionalLinkProp = (Property) addressOfAdditionalLinkSEs.getFirst();
            contactInformation.setAddressOfAdditionalLink(addressOfAdditionalLinkProp.getValue());
        }

        return contactInformation;
    }

    private Optional<Phone> convertSmcToPhone(SubmodelElementCollection smc) {
        //get telephone number mlp
        List<SubmodelElement> telephoneNumberSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.telephoneNumber, smc.getValue());

        //telephone number is not optional
        if(telephoneNumberSubmodelElements.isEmpty()){
            return Optional.empty();
        }

        MultiLanguageProperty telephoneNumberMlp = (MultiLanguageProperty) telephoneNumberSubmodelElements.getFirst();
        HashMap<String, String> telephoneNumber = convertMlpToHashmap(telephoneNumberMlp.getValue());

        //get type of telephone
        List<SubmodelElement> typeOfTelephoneSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.typeOfTelephone, smc.getValue());
        Optional<TypeOfTelephone> optTypeOfTelephone = Optional.empty();

        if(!typeOfTelephoneSubmodelElements.isEmpty()) {
            Property typeOfTelephoneProperty = (Property) typeOfTelephoneSubmodelElements.getFirst();
            optTypeOfTelephone = TypeOfTelephone.createFromSemanticId(typeOfTelephoneProperty.getValue());
        }

        //get available time
        List<SubmodelElement> availableTimeSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.availableTime, smc.getValue());
        HashMap<String, String> availableTime = new HashMap<>();

        if(!availableTimeSubmodelElements.isEmpty()) {
            MultiLanguageProperty availableTimeMlp = (MultiLanguageProperty) availableTimeSubmodelElements.getFirst();
            availableTime.putAll(convertMlpToHashmap(availableTimeMlp.getValue()));
        }

        //map collected values on phone object
        Phone phone = new Phone(telephoneNumber);

        if(optTypeOfTelephone.isPresent()) {
            phone.setTypeOfTelephone(optTypeOfTelephone.get());
        }

        if(!availableTime.isEmpty()) {
            phone.setAvailableTime(availableTime);
        }

        return Optional.of(phone);
    }

    private Optional<Fax> convertSmcToFax(SubmodelElementCollection smc) {
        //get fax number mlp
        List<SubmodelElement> faxNumberSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.faxNumber, smc.getValue());

        //fax number is not optional
        if(faxNumberSubmodelElements.isEmpty()) {
            return Optional.empty();
        }

        MultiLanguageProperty faxNumberMlp = (MultiLanguageProperty) faxNumberSubmodelElements.getFirst();
        HashMap<String, String> faxNumber = convertMlpToHashmap(faxNumberMlp.getValue());

        //get type of fax number property
        List<SubmodelElement> typeOfFaxNumberSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.typeOfFaxNumber, smc.getValue());
        Optional<TypeOfFaxNumber> optTypeOfFaxNumber = Optional.empty();

        if(!typeOfFaxNumberSubmodelElements.isEmpty()) {
            Property typeOfFaxNumberProperty = (Property) typeOfFaxNumberSubmodelElements.getFirst();
            optTypeOfFaxNumber = TypeOfFaxNumber.createFromSemanticId(typeOfFaxNumberProperty.getValue());
        }

        //map collected values on fax object
        Fax fax = new Fax(faxNumber);

        if(optTypeOfFaxNumber.isPresent()) {
            fax.setTypeOfFaxNumber(optTypeOfFaxNumber.get());
        }

        return Optional.of(fax);
    }

    private Optional<Email> convertSmcToEmail(SubmodelElementCollection smc) {
        //get email address property
        List<SubmodelElement> emailAddressSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.emailAddress, smc.getValue());

        //email address is not optional
        if(emailAddressSubmodelElements.isEmpty()) {
            return Optional.empty();
        }

        Property emailAddressProperty = (Property) emailAddressSubmodelElements.getFirst();
        String emailAddress = emailAddressProperty.getValue();

        //get public key mlp
        List<SubmodelElement> publicKeySubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.publicKey, smc.getValue());
        HashMap<String, String> publicKey = new HashMap<>();

        if(!publicKeySubmodelElements.isEmpty()) {
            MultiLanguageProperty publicKeyMlp = (MultiLanguageProperty) publicKeySubmodelElements.getFirst();
            publicKey.putAll(convertMlpToHashmap(publicKeyMlp.getValue()));
        }

        //get type of email address property
        List<SubmodelElement> typeOfEmailAddressSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.typeOfEmailAddress, smc.getValue());
        Optional<TypeOfEmailAddress> optTypeOfEmailAddress = Optional.empty();

        if(!typeOfEmailAddressSubmodelElements.isEmpty()) {
            Property typeOfEmailAddressProperty = (Property) typeOfEmailAddressSubmodelElements.getFirst();
            optTypeOfEmailAddress = TypeOfEmailAddress.createFromSemanticId(typeOfEmailAddressProperty.getValue());
        }

        //get type of public key mlp
        List<SubmodelElement> typeOfPublicKeySubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.typeOfPublicKey, smc.getValue());
        HashMap<String, String> typeOfPublicKey = new HashMap<>();

        if(!typeOfPublicKeySubmodelElements.isEmpty()) {
            MultiLanguageProperty typeOfPublicKeyMlp = (MultiLanguageProperty) typeOfPublicKeySubmodelElements.getFirst();
            typeOfPublicKey.putAll(convertMlpToHashmap(typeOfPublicKeyMlp.getValue()));
        }

        //map on email
        Email email = new Email(emailAddress);
        email.setPublicKey(publicKey)
                .setTypeOfPublicKey(typeOfPublicKey);

        if(optTypeOfEmailAddress.isPresent()) {
            email.setTypeOfEmailAddress(optTypeOfEmailAddress.get());
        }

        return Optional.of(email);
    }

    private Optional<IpCommunication> convertSmcToIpCommunication(SubmodelElementCollection smc) {
        //get address of additional link property
        List<SubmodelElement> additionalAddressSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.addressOfAdditionalLink, smc.getValue());

        //address of additional link is not optional
        if(additionalAddressSubmodelElements.isEmpty()) {
            return Optional.empty();
        }

        Property additionalAddressProperty = (Property) additionalAddressSubmodelElements.getFirst();
        String additionalAddress = additionalAddressProperty.getValue();

        //get type of communication property
        List<SubmodelElement> typeOfCommunicationSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.typeOfCommunication, smc.getValue());
        Optional<TypeOfCommunication> optTypeOfCommunication = Optional.empty();

        if(!typeOfCommunicationSubmodelElements.isEmpty()) {
            Property typeOfCommunicationProperty = (Property) typeOfCommunicationSubmodelElements.getFirst();
            optTypeOfCommunication = TypeOfCommunication.createFromValue(typeOfCommunicationProperty.getValue());
        }

        //get available time mlp
        List<SubmodelElement> availableTimeSubmodelElements = getSubmodelElements(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.availableTime, smc.getValue());
        HashMap<String, String> availableTime = new HashMap<>();

        if(!availableTimeSubmodelElements.isEmpty()) {
            MultiLanguageProperty availableTimeMlp = (MultiLanguageProperty) availableTimeSubmodelElements.getFirst();
            availableTime.putAll(convertMlpToHashmap(availableTimeMlp.getValue()));
        }

        //map on ip communication
        IpCommunication ipCommunication = new IpCommunication(smc.getIdShort(), additionalAddress);

        if(optTypeOfCommunication.isPresent()) {
            ipCommunication.setTypeOfCommunication(optTypeOfCommunication.get());
        }

        ipCommunication.setAvailableTime(availableTime);

        return Optional.of(ipCommunication);
    }

    private List<SubmodelElement> getSubmodelElements(String semanticId, List<SubmodelElement> submodelElements) {
        List<SubmodelElement> foundSubmodelElements = new ArrayList<>();

        for (SubmodelElement element: submodelElements) {
            List<Key> semanticKeys = element.getSemanticId().getKeys();

            if(!semanticKeys.isEmpty()) {
                Key key = semanticKeys.getFirst();

                if(key.getValue().equals(semanticId)) {
                    foundSubmodelElements.add(element);
                }
            }
        }

        return foundSubmodelElements;
    }

    private HashMap<String, String> convertMlpToHashmap(List<LangStringTextType> mlpValue) {
        HashMap<String, String> values = new HashMap<>();

        mlpValue.forEach(s -> values.put(s.getLanguage(), s.getText()));

        return values;
    }
}
