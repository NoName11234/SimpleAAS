package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.ContactInformationConstants;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
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
            optTypeOfTelephone = Optional.of(TypeOf)
        }

        //get available time

    }

    private Fax convertSmcToFax(SubmodelElementCollection smc) {

    }

    private Email convertSmcToEmail(SubmodelElementCollection smc) {

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
