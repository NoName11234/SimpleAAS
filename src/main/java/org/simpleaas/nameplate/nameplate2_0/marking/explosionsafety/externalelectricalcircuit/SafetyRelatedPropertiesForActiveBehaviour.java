package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit;

import java.util.Optional;

public class SafetyRelatedPropertiesForActiveBehaviour {
    private String maxOutputPower = null;
    private String maxOutputVoltage = null;
    private String maxOutputCurrent = null;
    private String maxExternalCapacitance = null;
    private String maxExternalInductance = null;
    private String maxExternalInductanceResistanceRatio = null;

    public Optional<String> getMaxExternalInductanceResistanceRatio() {
        return Optional.ofNullable(this.maxExternalInductanceResistanceRatio);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxExternalInductanceResistanceRatio(String maxExternalInductanceResistanceRatio) {
        this.maxExternalInductanceResistanceRatio = maxExternalInductanceResistanceRatio;
        return this;
    }

    public Optional<String> getMaxExternalInductance() {
        return Optional.ofNullable(this.maxExternalInductance);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxExternalInductance(String maxExternalInductance) {
        this.maxExternalInductance = maxExternalInductance;
        return this;
    }

    public Optional<String> getMaxExternalCapacitance() {
        return Optional.ofNullable(this.maxExternalCapacitance);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxExternalCapacitance(String maxExternalCapacitance) {
        this.maxExternalCapacitance = maxExternalCapacitance;
        return this;
    }

    public Optional<String> getMaxOutputCurrent() {
        return Optional.ofNullable(this.maxOutputCurrent);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxOutputCurrent(String maxOutputCurrent) {
        this.maxOutputCurrent = maxOutputCurrent;
        return this;
    }

    public Optional<String> getMaxOutputVoltage() {
        return Optional.ofNullable(this.maxOutputVoltage);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxOutputVoltage(String maxOutputVoltage) {
        this.maxOutputVoltage = maxOutputVoltage;
        return this;
    }

    public Optional<String> getMaxOutputPower() {
        return Optional.ofNullable(this.maxOutputPower);
    }

    public SafetyRelatedPropertiesForActiveBehaviour setMaxOutputPower(String maxOutputPower) {
        this.maxOutputPower = maxOutputPower;
        return this;
    }
}
