package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit;

import java.util.Optional;

public class SafetyRelatedPropertiesForPassiveBehaviour {
    private String maxInputPower = null;
    private String maxInputVoltage = null;
    private String maxInputCurrent = null;
    private String maxInternalCapacitance = null;
    private String maxInternalInductance = null;

    public Optional<String> getMaxInternalInductance() {
        return Optional.ofNullable(this.maxInternalInductance);
    }

    public SafetyRelatedPropertiesForPassiveBehaviour setMaxInternalInductance(String maxInternalInductance) {
        this.maxInternalInductance = maxInternalInductance;
        return this;
    }

    public Optional<String> getMaxInternalCapacitance() {
        return Optional.ofNullable(this.maxInternalCapacitance);
    }

    public SafetyRelatedPropertiesForPassiveBehaviour setMaxInternalCapacitance(String maxInternalCapacitance) {
        this.maxInternalCapacitance = maxInternalCapacitance;
        return this;
    }

    public Optional<String> getMaxInputCurrent() {
        return Optional.ofNullable(this.maxInputCurrent);
    }

    public SafetyRelatedPropertiesForPassiveBehaviour setMaxInputCurrent(String maxInputCurrent) {
        this.maxInputCurrent = maxInputCurrent;
        return this;
    }

    public Optional<String> getMaxInputVoltage() {
        return Optional.ofNullable(this.maxInputVoltage);
    }

    public SafetyRelatedPropertiesForPassiveBehaviour setMaxInputVoltage(String maxInputVoltage) {
        this.maxInputVoltage = maxInputVoltage;
        return this;
    }

    public Optional<String> getMaxInputPower() {
        return Optional.ofNullable(this.maxInputPower);
    }

    public SafetyRelatedPropertiesForPassiveBehaviour setMaxInputPower(String maxInputPower) {
        this.maxInputPower = maxInputPower;
        return this;
    }
}
