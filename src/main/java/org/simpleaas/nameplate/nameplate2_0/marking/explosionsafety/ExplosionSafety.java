package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety;

import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit.ExternalElectricalCircuit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Data class for information related to explosion safety.
 */
public class ExplosionSafety {
    /**
     * Short ID of the explosion safety SMC.
     */
    private final String shortId;
    /**
     * Identifier of a certificate or approval.
     */
    private String designationOfCertificateOrApproval = null;
    /**
     * Name of the approval system in multiple languages.
     * Language is used as key.
     */
    private final HashMap<String, String> typeOfApproval = new HashMap<>();
    /**
     * Name of the agency which has issued the certificate in multiple languages.
     * Language is used as key.
     */
    private final HashMap<String, String> approvalAgencyTestingAgency = new HashMap<>();
    /**
     * Optional classification of an explosion protection.
     */
    private String typeOfProtection = null;
    /**
     * Optional insulation voltage.
     */
    private String ratedInsulationVoltage = null;
    /**
     * Optional reference to the instruction manual or control drawing.
     */
    private Reference instructionsControlDrawing = null;
    /**
     * Optional notice whether there are specific conditions for usage.
     * X if there are any.
     */
    private String specificConditionsForUse = null;
    /**
     * Optional notice whether the device is incomplete.
     * U if incomplete.
     */
    private String incompleteDevice = null;
    /**
     * Collection of optional ambient conditions of the device.
     */
    private AmbientConditions ambientConditions = null;
    /**
     * Collection of optional process conditions of the device.
     */
    private ProcessConditions processConditions = null;
    /**
     * List of optional parameters of external circuits.
     */
    private final List<ExternalElectricalCircuit> externalElectricalCircuits = new ArrayList<>();

    /**
     * @param shortId short ID of the collection
     */
    public ExplosionSafety(String shortId) {
        this.shortId = shortId;
    }

    /**
     * Returns the short ID of the collection.
     * @return short ID
     */
    public String getShortId() {
        return this.shortId;
    }

    /**
     * Returns the optional identifier of a certificate or approval.
     * @return optional identifier of certificate or approval
     */
    public Optional<String> getDesignationOfCertificateOrApproval() {
        return Optional.ofNullable(this.designationOfCertificateOrApproval);
    }

    /**
     * Sets the identifier of a certificate or approval.
     * @param designationOfCertificateOrApproval identifier of a certificate or approval
     */
    public ExplosionSafety setDesignationOfCertificateOrApproval(String designationOfCertificateOrApproval) {
        this.designationOfCertificateOrApproval = designationOfCertificateOrApproval;
        return this;
    }

    /**
     * Adds a name of the approval system in a specified language.
     * @param language language
     * @param value name of the approval system
     */
    public ExplosionSafety addTypeOfApproval(String language, String value) {
        this.typeOfApproval.put(language, value);
        return this;
    }

    /**
     * Returns the optional name of the approval system in multiple languages.
     * @return optional name of the approval system
     */
    public HashMap<String, String> getTypeOfApproval() {
        return this.typeOfApproval;
    }

    /**
     * Checks whether type of approval is set.
     * @return true if set, else false
     */
    public boolean isTypeOfApprovalSet() {
        return !this.typeOfApproval.isEmpty();
    }

    /**
     * Adds the name of the agency which has issued the certificate in a specified language.
     * @param language language
     * @param value name of the agency
     */
    public ExplosionSafety addApprovalAgencyTestingAgency(String language, String value) {
        this.approvalAgencyTestingAgency.put(language, value);
        return this;
    }

    /**
     * Returns the optional name of the agency which has issued the certificate in multiple languages.
     * Language is used as key.
     * @return map of optional name of the agency
     */
    public HashMap<String, String> getApprovalAgencyTestingAgency() {
        return this.approvalAgencyTestingAgency;
    }

    /**
     * Checks whether the optional name of the agency which has issued the certificate is set.
     * @return true if set, else false
     */
    public boolean isApprovalAgencyTestingAgencySet() {
        return !this.approvalAgencyTestingAgency.isEmpty();
    }

    public ExplosionSafety setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
        return this;
    }

    public Optional<String> getTypeOfProtection() {
        return Optional.ofNullable(this.typeOfProtection);
    }

    public ExplosionSafety setRatedInsulationVoltage(String ratedInsulationVoltage) {
        this.ratedInsulationVoltage = ratedInsulationVoltage;
        return this;
    }

    public Optional<String> getRatedInsulationVoltage() {
        return Optional.ofNullable(this.ratedInsulationVoltage);
    }

    public ExplosionSafety setInstructionsControlDrawing(Reference instructionsControlDrawing) {
        this.instructionsControlDrawing = instructionsControlDrawing;
        return this;
    }

    public Optional<Reference> getInstructionsControlDrawing() {
        return Optional.ofNullable(this.instructionsControlDrawing);
    }

    public ExplosionSafety setSpecificConditionsForUse(String specificConditionsForUse) {
        this.specificConditionsForUse = specificConditionsForUse;
        return this;
    }

    public Optional<String> getSpecificConditionsForUse() {
        return Optional.ofNullable(this.specificConditionsForUse);
    }

    public ExplosionSafety setIncompleteDevice(String incompleteDevice) {
        this.incompleteDevice = incompleteDevice;
        return this;
    }

    public Optional<String> getIncompleteDevice() {
        return Optional.ofNullable(this.incompleteDevice);
    }

    public ExplosionSafety setAmbientConditions(AmbientConditions ambientConditions) {
        this.ambientConditions = ambientConditions;
        return this;
    }

    public Optional<AmbientConditions> getAmbientConditions() {
        return Optional.ofNullable(this.ambientConditions);
    }

    public ExplosionSafety setProcessConditions(ProcessConditions processConditions) {
        this.processConditions = processConditions;
        return this;
    }

    public Optional<ProcessConditions> getProcessConditions() {
        return Optional.ofNullable(this.processConditions);
    }

    public ExplosionSafety addExternalElectricCircuit(String shortId, ExternalElectricalCircuit externalElectricalCircuit) {
        this.externalElectricalCircuits.put(shortId, externalElectricalCircuit);
        return this;
    }

    public HashMap<String, ExternalElectricalCircuit> getExternalElectricalCircuits() {
        return this.externalElectricalCircuits;
    }

    public boolean areExternalElectricalCircuitsPresent() {
        return !this.externalElectricalCircuits.isEmpty();
    }
}
