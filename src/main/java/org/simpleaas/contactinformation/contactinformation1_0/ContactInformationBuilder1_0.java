package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultLangStringTextType;
import org.simpleaas.contactinformation.ContactInformationConstants;
import org.simpleaas.contactinformation.contactinformation1_0.email.Email;
import org.simpleaas.contactinformation.contactinformation1_0.fax.Fax;
import org.simpleaas.contactinformation.contactinformation1_0.ipcommunication.IpCommunication;
import org.simpleaas.contactinformation.contactinformation1_0.phone.Phone;
import org.simpleaas.helper.copying.SubmodelCopier;
import org.simpleaas.helper.copying.SubmodelElementCopier;

import java.util.HashMap;

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
                        if(contactInformation.getRoleOfContactPerson().isPresent()){
                            property.setValue(contactInformation.getRoleOfContactPerson().get().getSemanticId());
                        } else {
                            contactInformationSmc.getValue().remove(property);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.language)){
                        if(!contactInformation.getLanguage().isEmpty()) {
                            SubmodelElementCopier languageCopier = new SubmodelElementCopier(property);

                            //create a property for each language string
                            for(String language: contactInformation.getLanguage()) {
                                Property languageProp = (Property) languageCopier.createCopy();
                                languageProp.setValue(language);
                                contactInformationSmc.getValue().add(languageProp);
                            }

                            //remove the template property from the collection
                            contactInformationSmc.getValue().remove(property);
                        } else {
                            contactInformationSmc.getValue().remove(property);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.timeZone)){
                        if(contactInformation.getTimeZone().isPresent()) {
                            property.setValue(contactInformation.getTimeZone().get());
                        } else {
                            contactInformationSmc.getValue().remove(property);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.addressOfAdditionalLink)){
                        if(contactInformation.getAddressOfAdditionalLink().isPresent()) {
                            property.setValue(contactInformation.getAddressOfAdditionalLink().get());
                        } else {
                            contactInformationSmc.getValue().remove(property);
                        }
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()){
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.nationalCode)) {
                        if(!contactInformation.getNationalCode().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getNationalCode());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.cityTown)) {
                        if(!contactInformation.getCityTown().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getCityTown());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.company)) {
                        if(!contactInformation.getCompany().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getCompany());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.department)) {
                        if(!contactInformation.getDepartment().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getDepartment());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.street)) {
                        if(!contactInformation.getStreet().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getStreet());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipcode)) {
                        if(!contactInformation.getZipCode().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getZipCode());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.poBox)) {
                        if(!contactInformation.getPoBox().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getPoBox());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipCodeOfPoBox)) {
                        if(!contactInformation.getZipCodeOfPoBox().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getZipCodeOfPoBox());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.stateCounty)) {
                        if(!contactInformation.getStateCounty().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getStateCounty());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.nameOfContact)) {
                        if(!contactInformation.getNameOfContact().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getNameOfContact());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.firstName)) {
                        if(!contactInformation.getFirstName().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getFirstName());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.middleNames)) {
                        if(!contactInformation.getMiddleName().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getMiddleName());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.title)) {
                        if(!contactInformation.getTitle().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getTitle());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.academicTitle)) {
                        if(!contactInformation.getAcademicTitle().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getAcademicTitle());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.furtherDetailsOfContact)) {
                        if(!contactInformation.getFurtherDetailsOfContact().isEmpty()) {
                            addValuesToMlp(mlp, contactInformation.getFurtherDetailsOfContact());
                        } else {
                            contactInformationSmc.getValue().remove(mlp);
                        }
                    }
                }
            } else if(submodelElement instanceof SubmodelElementCollection smc) {
                for(Key key: smc.getSemanticId().getKeys()){

                }
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
        for(SubmodelElement submodelElement: this.template.getSubmodelElements()) {
            for(Key key: submodelElement.getSemanticId().getKeys()) {
                if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.id)) {
                    this.templateContactInformation = (SubmodelElementCollection) submodelElement;
                }
            }
        }

        //mark submodel element collections as template in short ID so they can be identified and removed later
        this.templateContactInformation.setIdShort("Template-ToBeRemoved");
    }

    private void removeTemplateElements(Submodel submodel) {
        for(SubmodelElement submodelElement: submodel.getSubmodelElements()) {
            if(submodelElement.getIdShort().equals("Template-ToBeRemoved")){
                submodel.getSubmodelElements().remove(submodelElement);
            }
        }
    }

    private void addValuesToMlp(MultiLanguageProperty mlp, HashMap<String, String> values) {
        for(String language: values.keySet()) {
            mlp.getValue().add(
              new DefaultLangStringTextType.Builder()
                      .language(language)
                      .text(values.get(language))
                      .build()
            );
        }
    }
}
