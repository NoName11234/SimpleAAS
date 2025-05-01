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
    private final Submodel template;

    private SubmodelElementCollection templateContactInformation;
    private SubmodelElementCollection templateIpCommunication;

    /**
     * @param submodel the template submodel which shall be used by the builder class
     */
    public ContactInformationBuilder1_0(Submodel submodel) {
        SubmodelCopier copier = new SubmodelCopier(submodel);
        this.template = copier.createCopy();

        findTemplateElements();
    }

    /**
     * Creates a submodel element collection with data of the contact information data class.
     * Used for contact information drop-ins used by other submodel standards.
     * @param contactInformation data class with contact information data
     * @return submodel element collection with the contact information data
     */
    public SubmodelElementCollection createContactInformationSmc(ContactInformation contactInformation) {
        SubmodelElementCopier copier = new SubmodelElementCopier(this.templateContactInformation);
        SubmodelElementCollection contactInformationSmc = (SubmodelElementCollection) copier.createCopy();
        contactInformationSmc.setIdShort(contactInformation.getShortId());

        mapContactInformationOnSmc(contactInformation, contactInformationSmc);

        return contactInformationSmc;
    }

    /**
     * Returns a submodel of type contact information with the set values.
     * @return submodel of type contact information
     */
    public Submodel createSubmodel() {
        SubmodelCopier copier = new SubmodelCopier(this.template);

        Submodel submodel = copier.createCopy();

        removeTemplateElements(submodel);

        return submodel;
    }

    /**
     * Adds a contact information submodel element collection with the specified values to the submodel.
     * @param contactInformation the values for the submodel element collection
     */
    public void addContactInformation(ContactInformation contactInformation) {
        //create new submodel element collection by using the template elements
        SubmodelElementCopier copier = new SubmodelElementCopier(this.templateContactInformation);
        SubmodelElementCollection contactInformationSmc = (SubmodelElementCollection) copier.createCopy();
        contactInformationSmc.setIdShort(contactInformation.getShortId());

        //map values from contact information data object on created submodel element collection
        mapContactInformationOnSmc(contactInformation, contactInformationSmc);

        this.template.getSubmodelElements().add(contactInformationSmc);
    }

    /**
     * Maps the content of the email data object on the submodel element collection.
     * @param emailSmc submodel element collection for email data
     * @param email email data object
     */
    private void addEmail(SubmodelElementCollection emailSmc, Email email) {
        for(SubmodelElement submodelElement: emailSmc.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()){
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.emailAddress)) {
                        property.setValue(email.getEmailAddress());
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.typeOfEmailAddress)) {
                        if(email.getTypeOfEmailAddress().isPresent()) {
                            property.setValue(email.getTypeOfEmailAddress().get().getSemanticId());
                        } else {
                            emailSmc.getValue().remove(property);
                        }
                    }
                }
            } else if (submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()){
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.publicKey)) {
                        if(!email.getPublicKey().isEmpty()) {
                            addValuesToMlp(mlp, email.getPublicKey());
                        } else {
                            emailSmc.getValue().remove(mlp);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.typeOfPublicKey)) {
                        if(!email.getTypeOfPublicKey().isEmpty()) {
                            addValuesToMlp(mlp, email.getTypeOfPublicKey());
                        } else {
                            emailSmc.getValue().remove(mlp);
                        }
                    }
                }
            }
        }
    }

    /**
     * Maps the content of the fax data object on the submodel element collection.
     * @param faxSmc submodel element collection for fax data
     * @param fax fax data object
     */
    private void addFax(SubmodelElementCollection faxSmc, Fax fax) {
        for(SubmodelElement submodelElement: faxSmc.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()) {
                    if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.typeOfFaxNumber)) {
                        if(fax.getTypeOfFaxNumber().isPresent()) {
                            property.setValue(fax.getTypeOfFaxNumber().get().getSemanticId());
                        } else {
                            faxSmc.getValue().remove(property);
                        }
                    }
                }
            } else if (submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()) {
                    if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.faxNumber)) {
                        addValuesToMlp(mlp, fax.getFaxNumber());
                    }
                }
            }
        }
    }

    /**
     * Maps the content of the IP communication data object on the submodel element collection.
     * @param ipCommunicationSmc submodel element collection for IP communication data
     * @param ipCommunication IP communication data object
     */
    private void addIpCommunication(SubmodelElementCollection ipCommunicationSmc, IpCommunication ipCommunication) {
        for(SubmodelElement submodelElement: ipCommunicationSmc.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.addressOfAdditionalLink)) {
                        property.setValue(ipCommunication.getAddressOfAdditionalLink());
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.typeOfCommunication)) {
                        if(ipCommunication.getTypeOfCommunication().isPresent()) {
                            property.setValue(ipCommunication.getTypeOfCommunication().get().getSemanticId());
                        } else {
                            ipCommunicationSmc.getValue().remove(property);
                        }
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.availableTime)) {
                        if(!ipCommunication.getAvailableTime().isEmpty()) {
                            addValuesToMlp(mlp, ipCommunication.getAvailableTime());
                        } else {
                            ipCommunicationSmc.getValue().remove(mlp);
                        }
                    }
                }
            }
        }
    }

    /**
     * Maps the content of the phone data object on the submodel element collection.
     * @param phoneSmc submodel element collection for phone data
     * @param phone phone data object
     */
    private void addPhone(SubmodelElementCollection phoneSmc, Phone phone) {
        for(SubmodelElement submodelElement: phoneSmc.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.typeOfTelephone)) {
                        if(phone.getTypeOfTelephone().isPresent()) {
                            property.setValue(phone.getTypeOfTelephone().get().getSemanticId());
                        } else {
                            phoneSmc.getValue().remove(property);
                        }
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.telephoneNumber)) {
                        addValuesToMlp(mlp, phone.getTelephoneNumber());
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.availableTime)) {
                        if(!phone.getAvailableTime().isEmpty()) {
                            addValuesToMlp(mlp, phone.getAvailableTime());
                        } else {
                            phoneSmc.getValue().remove(mlp);
                        }
                    }
                }
            }
        }
    }

    private void mapContactInformationOnSmc(ContactInformation contactInformation, SubmodelElementCollection contactInformationSmc) {
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
                            for(String shortId: contactInformation.getLanguage().keySet()) {
                                Property languageProp = (Property) languageCopier.createCopy();
                                languageProp.setIdShort(shortId);
                                languageProp.setValue(contactInformation.getLanguage().get(shortId));
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
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.id)) {
                        if(contactInformation.getEmail().isPresent()) {
                            addEmail(smc, contactInformation.getEmail().get());
                        } else {
                            contactInformationSmc.getValue().remove(smc);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.id)) {
                        if(contactInformation.getFax().isPresent()) {
                            addFax(smc, contactInformation.getFax().get());
                        } else {
                            contactInformationSmc.getValue().remove(smc);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.id)) {
                        //remove the submodel element collection for ip communication, the template element will be used
                        contactInformationSmc.getValue().remove(smc);
                        SubmodelElementCopier ipCommunicationCopier = new SubmodelElementCopier(this.templateIpCommunication);

                        for(IpCommunication ipCommunication: contactInformation.getIpCommunications()) {
                            SubmodelElementCollection ipCommunicationSmc = (SubmodelElementCollection) ipCommunicationCopier.createCopy();
                            contactInformationSmc.getValue().add(ipCommunicationSmc);
                            addIpCommunication(ipCommunicationSmc, ipCommunication);
                        }
                    } else if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.id)) {
                        if(contactInformation.getPhone().isPresent()) {
                            addPhone(smc, contactInformation.getPhone().get());
                        } else {
                            contactInformationSmc.getValue().remove(smc);
                        }
                    }
                }
            }
        }
    }

    /**
     * Checks the template submodel for template elements and saves the references in the builder attributes.
     * Where necessary the template elements get marked by using their short ID, so they can be removed later.
     */
    private void findTemplateElements() {
        for(SubmodelElement submodelElement: this.template.getSubmodelElements()) {
            for(Key key: submodelElement.getSemanticId().getKeys()) {
                if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.id)) {
                    this.templateContactInformation = (SubmodelElementCollection) submodelElement;
                } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.id)) {
                    this.templateIpCommunication = (SubmodelElementCollection) submodelElement;
                }
            }
        }

        //mark submodel element collections as template in short ID so they can be identified and removed later
        this.templateContactInformation.setIdShort("Template-ToBeRemoved");
    }

    /**
     * Removes template elements from the given submodel by checking the short IDs of the elements.
     * @param submodel the submodel to remove the template elements from
     */
    private void removeTemplateElements(Submodel submodel) {
        for(SubmodelElement submodelElement: submodel.getSubmodelElements()) {
            if(submodelElement.getIdShort().equals("Template-ToBeRemoved")){
                submodel.getSubmodelElements().remove(submodelElement);
            }
        }
    }

    /**
     * Adds the values of the given HashMap to the specified MultiLanguageProperty.
     * @param mlp the MultiLanguageProperty
     * @param values the values to add
     */
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
