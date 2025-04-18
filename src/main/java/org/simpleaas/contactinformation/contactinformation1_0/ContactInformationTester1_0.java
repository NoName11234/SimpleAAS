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

                    } else {
                        //add error because semantic ID could not be identified
                    }
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                for(Key key: mlp.getSemanticId().getKeys()) {

                }
            } else if(submodelElement instanceof SubmodelElementCollection smc) {
                for(Key key: smc.getSemanticId().getKeys()) {

                }
            } else {
                //add error because this submodel element collection should not contain this submodel element type
            }
        }

        //check role of contact person
        /*List<Property> roleOfContactPersons = new ArrayList<>();

        List<SubmodelElement> roleOfContactPersonSEs = contactInformation.getValue().stream()
                .filter(se -> compareSemanticId(se.getSemanticId(), ContactInformationConstants.ContactInformations1_0.ContactInformation.roleOfContactPerson))
                .toList();

        //check whether submodel elements are from type property
        for(SubmodelElement roleOfContactPersonSE: roleOfContactPersonSEs) {
            if(roleOfContactPersonSE instanceof Property p) {
                roleOfContactPersons.add(p);
            } else {
                errors.add("Submodel element " + roleOfContactPersonSE.getIdShort() + " with role of contact person data is from type " + roleOfContactPersonSE.getClass().getName() + " instead of type Property.");
            }
        }

        //check the cardinality of role of contact person
        if(roleOfContactPersons.size() > 1) {
            errors.add("There are " + roleOfContactPersons.size() + " instances of submodel element role of contact person instead of 0-1.");
        }

        //check national code
        List<MultiLanguageProperty> nationalCodes = new ArrayList<>();

        List<SubmodelElement> nationalCodeSEs = contactInformation.getValue().stream()
                .filter(se -> compareSemanticId(se.getSemanticId(), ContactInformationConstants.ContactInformations1_0.ContactInformation.nationalCode))
                .toList();

        //check whether submodel elements are from type multilanguage property
        for(SubmodelElement nationalCodeSE: nationalCodeSEs) {
            if(nationalCodeSE instanceof MultiLanguageProperty mlp) {
                nationalCodes.add(mlp);
            } else {
                errors.add("Submodel element " + nationalCodeSE.getIdShort() + " with national code data is from type " + nationalCodeSE.getClass().getName() + " instead of type MultiLanguageProperty");
            }
        }

        //check the cardinality of national code
        if(nationalCodes.size() > 1) {
            errors.add("There are " + nationalCodes.size() + " instances of submodel element national code instead of 0-1.");
        }*/


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
