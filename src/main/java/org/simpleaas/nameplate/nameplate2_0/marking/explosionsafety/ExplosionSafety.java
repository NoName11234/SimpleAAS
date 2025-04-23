package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety;

import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit.ExternalElectricalCircuit;

import java.util.HashMap;
import java.util.Optional;

public class ExplosionSafety {
    private String designationOfCertificateOrApproval = null;
    private final HashMap<String, String> typeOfApproval = new HashMap<>();
    private final HashMap<String, String> approvalAgencyTestingAgency = new HashMap<>();
    private String typeOfProtection = null;
    private String ratedInsulationVoltage = null;
    private Reference instructionsControlDrawing = null;
    private String specificConditionsForUse = null;
    private String incompleteDevice = null;
    private AmbientConditions ambientConditions = null;
    private ProcessConditions processConditions = null;
    private HashMap<String, ExternalElectricalCircuit> externalElectricalCircuits = new HashMap<>();


    public Optional<String> getDesignationOfCertificateOrApproval() {
        return Optional.ofNullable(this.designationOfCertificateOrApproval);
    }

    public ExplosionSafety setDesignationOfCertificateOrApproval(String designationOfCertificateOrApproval) {
        this.designationOfCertificateOrApproval = designationOfCertificateOrApproval;
        return this;
    }

    public ExplosionSafety addTypeOfApproval(String language, String value) {
        this.typeOfApproval.put(language, value);
        return this;
    }

    public HashMap<String, String> getTypeOfApproval() {
        return this.typeOfApproval;
    }

    public boolean isTypeOfApprovalSet() {
        return !this.typeOfApproval.isEmpty();
    }

    public ExplosionSafety addApprovalAgencyTestingAgency(String language, String value) {
        this.approvalAgencyTestingAgency.put(language, value);
        return this;
    }

    public HashMap<String, String> getApprovalAgencyTestingAgency() {
        return this.approvalAgencyTestingAgency;
    }

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
