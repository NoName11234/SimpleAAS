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

    /**
     * Sets the type of protection as listed in the certificate.
     * @param typeOfProtection type of protection
     */
    public ExplosionSafety setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
        return this;
    }

    /**
     * Returns the optional type of protection.
     * @return type of protection
     */
    public Optional<String> getTypeOfProtection() {
        return Optional.ofNullable(this.typeOfProtection);
    }

    /**
     * Sets the rated insulation voltage.
     * @param ratedInsulationVoltage rated insulation voltage
     */
    public ExplosionSafety setRatedInsulationVoltage(String ratedInsulationVoltage) {
        this.ratedInsulationVoltage = ratedInsulationVoltage;
        return this;
    }

    /**
     * Returns the optional rated insulation voltage.
     * @return optional insulation voltage
     */
    public Optional<String> getRatedInsulationVoltage() {
        return Optional.ofNullable(this.ratedInsulationVoltage);
    }

    /**
     * Sets the reference to a file of control/reference drawings.
     * @param instructionsControlDrawing reference to file
     */
    public ExplosionSafety setInstructionsControlDrawing(Reference instructionsControlDrawing) {
        this.instructionsControlDrawing = instructionsControlDrawing;
        return this;
    }

    /**
     * Returns the reference to a file of control/reference drawings.
     * @return reference to file
     */
    public Optional<Reference> getInstructionsControlDrawing() {
        return Optional.ofNullable(this.instructionsControlDrawing);
    }

    /**
     * If there are specific conditions for use set to "X".
     * Else leave set to null.
     * @param specificConditionsForUse "X" if there are specific condictions for use
     */
    public ExplosionSafety setSpecificConditionsForUse(String specificConditionsForUse) {
        this.specificConditionsForUse = specificConditionsForUse;
        return this;
    }

    /**
     * Returns the optional specific conditions for use.
     * If present, the value must be "X".
     * @return "X" if present
     */
    public Optional<String> getSpecificConditionsForUse() {
        return Optional.ofNullable(this.specificConditionsForUse);
    }

    /**
     * If this device is incomplete the value needs to be set to "U".
     * Else leave set to null.
     * @param incompleteDevice "U" if device is incomplete
     */
    public ExplosionSafety setIncompleteDevice(String incompleteDevice) {
        this.incompleteDevice = incompleteDevice;
        return this;
    }

    /**
     * Returns whether the device is incomplete.
     * If incomplete the value must be "U".
     * @return "U" if present
     */
    public Optional<String> getIncompleteDevice() {
        return Optional.ofNullable(this.incompleteDevice);
    }

    /**
     * Sets the ambient conditions of the device.
     * @param ambientConditions ambient conditions of device
     */
    public ExplosionSafety setAmbientConditions(AmbientConditions ambientConditions) {
        this.ambientConditions = ambientConditions;
        return this;
    }

    /**
     * Returns the optional ambient conditions of the device.
     * @return optional ambient conditions
     */
    public Optional<AmbientConditions> getAmbientConditions() {
        return Optional.ofNullable(this.ambientConditions);
    }

    /**
     * Sets the process conditions of the device.
     * @param processConditions process conditions
     */
    public ExplosionSafety setProcessConditions(ProcessConditions processConditions) {
        this.processConditions = processConditions;
        return this;
    }

    /**
     * Returns the optional process conditions of the device.
     * @return optional process conditions
     */
    public Optional<ProcessConditions> getProcessConditions() {
        return Optional.ofNullable(this.processConditions);
    }

    /**
     * Adds the parameters of an external electrical circuit.
     * @param externalElectricalCircuit parameters of circuit
     */
    public ExplosionSafety addExternalElectricCircuit(ExternalElectricalCircuit externalElectricalCircuit) {
        this.externalElectricalCircuits.add(externalElectricalCircuit);
        return this;
    }

    /**
     * Returns the optional parameters of external electrical circuits.
     * @return parameters of circuits
     */
    public List<ExternalElectricalCircuit> getExternalElectricalCircuits() {
        return this.externalElectricalCircuits;
    }

    /**
     * Checks whether there are parameters of external circuits.
     * @return true if there are parameters, else false
     */
    public boolean areExternalElectricalCircuitsPresent() {
        return !this.externalElectricalCircuits.isEmpty();
    }
}
