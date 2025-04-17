package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.ContactInformationConstants;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.phone.Phone;
import org.simpleaas.helper.copying.SubmodelCopier;
import org.simpleaas.helper.copying.SubmodelElementCopier;

/**
 * Class for creating submodels of type Contact Information 1.0.
 */
public class ContactInformationBuilder1_0 {
    /**
     * Template submodel of type Contact Information.
     */
    private Submodel template;

    private SubmodelElementCollection templateContactInformation;

    /**
     * @param submodel the template submodel which shall be used by the builder class
     */
    public ContactInformationBuilder1_0(Submodel submodel) {
        SubmodelCopier copier = new SubmodelCopier(submodel);
        this.template = copier.createCopy();

        findTemplateElements();
    }

    public Submodel createSubmodel() {
        SubmodelCopier copier = new SubmodelCopier(this.template);

        Submodel submodel = copier.createCopy();

        removeTemplateElements(submodel);

        return submodel;
    }

    public void addContactInformation(ContactInformation contactInformation) {
        //create new submodel element collection by using the template elements
        SubmodelElementCopier copier = new SubmodelElementCopier(this.templateContactInformation);
        SubmodelElementCollection contactInformationSmc = (SubmodelElementCollection) copier.createCopy();

        //map values from contact information data object on created submodel element collection
        for(SubmodelElement submodelElement: contactInformationSmc.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()){
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.roleOfContactPerson)){
                        if()
                        property.setValue();
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {

            } else if(submodelElement instanceof SubmodelElementCollection smc) {

            }
        }
    }

    private void addEmail(Email email) {

    }

    private void addFax(Fax fax) {

    }

    private void addIpCommunication(IpCommunication ipCommunication) {

    }

    private void addPhone(Phone phone) {

    }

    private void findTemplateElements() {
        //mark submodel element collections as template in short ID so they can be identified and removed later
    }

    private void removeTemplateElements(Submodel submodel) {

    }
}
