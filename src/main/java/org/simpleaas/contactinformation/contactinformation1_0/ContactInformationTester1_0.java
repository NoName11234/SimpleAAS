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

        //check role of contact person
        List<Property> roleOfContactPersons = new ArrayList<>();

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
