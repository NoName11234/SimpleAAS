package org.simpleaas.contactinformation.contactinformation1_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.ContactInformationConstants;

import java.util.ArrayList;
import java.util.List;

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

        return new ArrayList<>();
    }

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
