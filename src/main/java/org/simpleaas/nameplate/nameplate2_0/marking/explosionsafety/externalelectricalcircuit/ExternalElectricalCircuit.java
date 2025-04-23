package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit;

import java.util.HashMap;
import java.util.Optional;

public class ExternalElectricalCircuit {
    private String designationOfElectricalTerminal = null;
    private String typeOfProtection = null;
    private final HashMap<String, String> equipmentProtectionLevel = new HashMap<>();
    private String explosionGroup = null;
    private String characteristics = null;
    private String fisco = null;
    private String twoWise = null;
    private SafetyRelatedPropertiesForPassiveBehaviour passiveSafetyRelatedProperties = null;
    private SafetyRelatedPropertiesForActiveBehaviour activeSafetyRelatedProperties = null;

    private ExternalElectricalCircuit setDesignationOfElectricalTerminal(String designationOfElectricalTerminal) {
        this.designationOfElectricalTerminal = designationOfElectricalTerminal;
        return this;
    }

    private Optional<String> getDesignationOfElectricalTerminal() {
        return Optional.ofNullable(this.designationOfElectricalTerminal);
    }

    public ExternalElectricalCircuit setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
        return this;
    }

    public Optional<String> getTypeOfProtection() {
        return Optional.ofNullable(this.typeOfProtection);
    }

    public ExternalElectricalCircuit addEquipmentProtectionLevel(String language, String equipmentProtectionLevel) {
        this.equipmentProtectionLevel.put(language, equipmentProtectionLevel);
        return this;
    }

    public HashMap<String, String> getEquipmentProtectionLevel() {
        return this.equipmentProtectionLevel;
    }

    public boolean isEquipmentProtectionLevelPresent() {
        return !this.equipmentProtectionLevel.isEmpty();
    }

    public ExternalElectricalCircuit setExplosionGroup(String explosionGroup) {
        this.explosionGroup = explosionGroup;
        return this;
    }

    public Optional<String> getExplosionGroup() {
        return Optional.ofNullable(this.explosionGroup);
    }

    public ExternalElectricalCircuit setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    public Optional<String> getCharacteristics() {
        return Optional.ofNullable(this.characteristics);
    }

    public ExternalElectricalCircuit setFisco(String fisco) {
        this.fisco = fisco;
        return this;
    }

    public Optional<String> getFisco() {
        return Optional.ofNullable(this.fisco);
    }

    public ExternalElectricalCircuit setTwoWise(String twoWise) {
        this.twoWise = twoWise;
        return this;
    }

    public Optional<String> getTwoWise() {
        return Optional.ofNullable(this.twoWise);
    }

    public ExternalElectricalCircuit setPassiveSafetyRelatedProperties(SafetyRelatedPropertiesForPassiveBehaviour passiveSafetyRelatedProperties) {
        this.passiveSafetyRelatedProperties = passiveSafetyRelatedProperties;
        return this;
    }

    public Optional<SafetyRelatedPropertiesForPassiveBehaviour> getPassiveSafetyRelatedProperties() {
        return Optional.ofNullable(this.passiveSafetyRelatedProperties);
    }

    public ExternalElectricalCircuit setActiveSafetyRelatedProperties(SafetyRelatedPropertiesForActiveBehaviour activeSafetyRelatedProperties) {
        this.activeSafetyRelatedProperties = activeSafetyRelatedProperties;
        return this;
    }

    public Optional<SafetyRelatedPropertiesForActiveBehaviour> getActiveSafetyRelatedProperties() {
        return Optional.ofNullable(this.activeSafetyRelatedProperties);
    }
}
