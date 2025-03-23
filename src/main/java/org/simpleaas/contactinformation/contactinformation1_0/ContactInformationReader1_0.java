package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.phone.Phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactInformationReader1_0 {
    private final Submodel submodel;

    public ContactInformationReader1_0(Submodel submodel) {
        this.submodel = submodel;
    }

    public static ContactInformation getContactInformation(SubmodelElementCollection contactInformation) {
        return new ContactInformation();
    }

    public List<ContactInformation> getContactInformation() {

    }

    private Phone convertSmcToPhone(SubmodelElementCollection smc) {

    }

    private Fax convertSmcToFax(SubmodelElementCollection smc) {

    }

    private Email convertSmcToEmail(SubmodelElementCollection smc) {

    }

    private IpCommunication convertSmcToIpCommunication(SubmodelElementCollection smc) {
        
    }

    private List<SubmodelElement> getSubmodelElement(String semanticId, List<SubmodelElement> submodelElements) {
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
