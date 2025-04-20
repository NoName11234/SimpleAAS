package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.ContactInformationConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class for testing the conformity of a submodel with the submodel standard Contact Information 1.0.
 */
public class ContactInformationTester1_0 {
    /**
     * The submodel to be checked.
     */
    private Submodel submodel;

    /**
     * @param submodel the submodel to be tested for Contact Information conformity
     */
    public ContactInformationTester1_0(Submodel submodel) {
        this.submodel = submodel;
    }

    /**
     * Checks the set submodel for conformity with the submodel standard Contact Information 1.0.
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    public List<String> checkStandardConformity() {
        List<String> errors = new ArrayList<>();

        //check whether there is one or multiple submodel element collections of type contact information
        List<SubmodelElementCollection> contactInformationElements = submodel.getSubmodelElements().stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .filter(se -> compareSemanticId(se.getSemanticId(), ContactInformationConstants.ContactInformations1_0.id))
                .map(se -> (SubmodelElementCollection)se)
                .toList();

        if(contactInformationElements.isEmpty()) {
            errors.add("No submodel element collections of type contact information found. The submodel should contain at least one.");
        }

        //check whether there are any other submodel elements
        List<SubmodelElement> otherElements = submodel.getSubmodelElements().stream()
                .filter(se -> !(se instanceof SubmodelElementCollection) || !(compareSemanticId(se.getSemanticId(), ContactInformationConstants.ContactInformations1_0.id)))
                .toList();

        if(!otherElements.isEmpty()) {
            for(SubmodelElement se: otherElements) {
                errors.add("Submodel element of type " + se.getClass().getName() + " and short ID " + se.getIdShort() + " found which should not be part of the submodel.");
            }

            return errors;
        }

        for(SubmodelElementCollection contactInformation: contactInformationElements) {
            List<String> contactInformationErrors = checkContactInformationCollection(contactInformation);

            for(String contactInformationError: contactInformationErrors) {
                errors.add("In submodel element " + contactInformation.getIdShort() + ": " + contactInformationError);
            }
        }

        return errors;
    }

    /**
     * Checks the given submodel element collection for conformity with the contact information submodel element collection.
     * @param contactInformation the submodel element collection to be tested for conformity
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    private List<String> checkContactInformationCollection(SubmodelElementCollection contactInformation) {
        List<String> errors = new ArrayList<>();

        //collect submodel elements by their type and semantic ID
        List<Property> roleOfContactPersons = new ArrayList<>();
        List<MultiLanguageProperty> nationalCodes = new ArrayList<>();
        List<Property> languages = new ArrayList<>();
        List<Property> timeZones = new ArrayList<>();
        List<MultiLanguageProperty> cityTowns = new ArrayList<>();
        List<MultiLanguageProperty> companies = new ArrayList<>();
        List<MultiLanguageProperty> departments = new ArrayList<>();
        List<SubmodelElementCollection> phones = new ArrayList<>();
        List<SubmodelElementCollection> faxes = new ArrayList<>();
        List<SubmodelElementCollection> emails = new ArrayList<>();
        List<SubmodelElementCollection> ipCommunications = new ArrayList<>();
        List<MultiLanguageProperty> streets = new ArrayList<>();
        List<MultiLanguageProperty> zipCodes = new ArrayList<>();
        List<MultiLanguageProperty> poBoxes = new ArrayList<>();
        List<MultiLanguageProperty> zipCodeOfPoBoxes = new ArrayList<>();
        List<MultiLanguageProperty> stateCounty = new ArrayList<>();
        List<MultiLanguageProperty> nameOfContacts = new ArrayList<>();
        List<MultiLanguageProperty> firstNames = new ArrayList<>();
        List<MultiLanguageProperty> middleNames = new ArrayList<>();
        List<MultiLanguageProperty> titles = new ArrayList<>();
        List<MultiLanguageProperty> academicTitles = new ArrayList<>();
        List<MultiLanguageProperty> furtherDetailsOfContacts = new ArrayList<>();
        List<Property> addressOfAdditionalLinks = new ArrayList<>();

        for(SubmodelElement submodelElement: contactInformation.getValue()) {
            if(submodelElement instanceof Property property) {
                for(Key key: property.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.roleOfContactPerson)) {
                        roleOfContactPersons.add(property);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.language)) {
                        languages.add(property);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.timeZone)) {
                        timeZones.add(property);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.addressOfAdditionalLink)) {
                        addressOfAdditionalLinks.add(property);
                    } else {
                        //add error because semantic ID could not be identified
                        errors.add("Property with unknown semantic ID found: " + key.getValue());
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.nationalCode)) {
                        nationalCodes.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.cityTown)) {
                        cityTowns.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.company)) {
                        companies.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.department)) {
                        departments.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.street)) {
                        streets.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipcode)) {
                        zipCodes.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.poBox)) {
                        poBoxes.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.zipCodeOfPoBox)) {
                        zipCodeOfPoBoxes.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.stateCounty)) {
                        stateCounty.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.nameOfContact)) {
                        nameOfContacts.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.firstName)) {
                        firstNames.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.middleNames)) {
                        middleNames.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.title)) {
                        titles.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.academicTitle)) {
                        academicTitles.add(mlp);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.furtherDetailsOfContact)) {
                        furtherDetailsOfContacts.add(mlp);
                    } else {
                        //add error because semantic ID could not be identified
                        errors.add("Multilanguage property with unknown semantic ID found: " + key.getValue());
                    }
                }
            } else if(submodelElement instanceof SubmodelElementCollection smc) {
                for(Key key: smc.getSemanticId().getKeys()) {
                    if(key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Phone.id)) {
                        phones.add(smc);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Fax.id)) {
                        faxes.add(smc);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.Email.id)) {
                        emails.add(smc);
                    } else if (key.getValue().equals(ContactInformationConstants.ContactInformations1_0.ContactInformation.IpCommunication.id)) {
                        ipCommunications.add(smc);
                    } else {
                        //add error beacuse semantic ID could not be identified
                        errors.add("Submodel element collection with unknown semantic ID found: " + key.getValue());
                    }
                }
            } else {
                //add error because this submodel element collection should not contain this submodel element type
                errors.add("Submodel element found, which type is not part of the submodel standard: " + submodelElement.getClass().getName());
            }
        }

        

        return errors;
    }

    /**
     * Checks the given submodel element collection for conformity with the phone submodel element collection.
     * @param phone the submodel element collection to be tested for conformity
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    private List<String> checkPhoneCollection(SubmodelElementCollection phone) {
        List<String> errors = new ArrayList<>();

        return errors;
    }

    /**
     * Checks the given submodel element collection for conformity with the fax submodel element collection.
     * @param fax the submodel element collection to be tested for conformity
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    private List<String> checkFaxCollection(SubmodelElementCollection fax) {
        List<String> errors = new ArrayList<>();

        return errors;
    }

    /**
     * Checks the given submodel element collection for conformity with the email submodel element collection.
     * @param email the submodel element collection to be tested for conformity
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    private List<String> checkEmailCollection(SubmodelElementCollection email) {
        List<String> errors = new ArrayList<>();

        return errors;
    }

    /**
     * Checks the given submodel element collection for conformity with the ip communication submodel element collection.
     * @param ipCommunication the submodel element collection to be tested for conformity
     * @return list of found standard violations of the submodel, empty if no problems were found
     */
    private List<String> checkIpCommunicationCollection(SubmodelElementCollection ipCommunication) {
        List<String> errors = new ArrayList<>();

        return errors;
    }

    /**
     * Compares a reference to a given semantic ID.
     * @param reference the reference to compare to the defined semantic ID
     * @param semanticId the semantic ID to compare to the given reference
     * @return true if the given semantic ID is part of the given reference
     */
    private boolean compareSemanticId(Reference reference, String semanticId) {
        List<Key> keys = reference.getKeys();

        if(keys.isEmpty()) {
            return false;
        }

        for(Key key: keys) {
            if(key.getValue().equals(semanticId)) {
                return true;
            }
        }

        return false;
    }
}
