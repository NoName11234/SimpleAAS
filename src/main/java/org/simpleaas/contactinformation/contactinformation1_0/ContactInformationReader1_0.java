package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.ContactInformationConstants;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.email.TypeOfEmailAddress;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.fax.TypeOfFaxNumber;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
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

    public static ContactInformation getContactInformation(SubmodelElementCollection contactInformation) {
        return new ContactInformation();
    }

    public List<ContactInformation> getContactInformation() {

        return this.submodel.getSubmodelElements().stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .map(ContactInformationReader1_0::getContactInformation)
                .toList();
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
            availableTime = convertMlpToHashmap(availableTimeMlp.getValue());
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
            publicKey = convertMlpToHashmap(publicKeyMlp.getValue());
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
            typeOfPublicKey = convertMlpToHashmap(typeOfPublicKeyMlp.getValue());
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

    private IpCommunication convertSmcToIpCommunication(SubmodelElementCollection smc) {
        
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
