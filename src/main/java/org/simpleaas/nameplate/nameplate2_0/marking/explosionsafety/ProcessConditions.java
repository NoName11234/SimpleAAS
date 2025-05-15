package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety;

import java.util.HashMap;
import java.util.Optional;

public class ProcessConditions {
    private String deviceCategory = null;
    private final HashMap<String, String> equipmentProtectionLevel = new HashMap<>();
    private String regionalSpecificMarking = null;
    private String typeOfProtection = null;
    private String explosionGroup = null;
    private String lowerLimitingValueOfProcessTemperature = null;
    private String upperLimitingValueOfProcessTemperature = null;
    private String maxSurfaceTemperatureForDustProof = null;
    private String temperatureClass = null;

    public ProcessConditions setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
        return this;
    }

    public Optional<String> getDeviceCategory() {
        return Optional.ofNullable(this.deviceCategory);
    }

    public ProcessConditions addEquipmentProtectionLevel(String language, String equipmentProtectionLevel) {
        this.equipmentProtectionLevel.put(language, equipmentProtectionLevel);
        return this;
    }

    public HashMap<String, String> getEquipmentProtectionLevel() {
        return this.equipmentProtectionLevel;
    }

    public boolean isEquipmentProtectionLevelPresent() {
        return !this.equipmentProtectionLevel.isEmpty();
    }

    public ProcessConditions setRegionalSpecificMarking(String regionalSpecificMarking) {
        this.regionalSpecificMarking = regionalSpecificMarking;
        return this;
    }

    public Optional<String> getRegionalSpecificMarking() {
        return Optional.ofNullable(this.regionalSpecificMarking);
    }

    public ProcessConditions setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
        return this;
    }

    public Optional<String> getTypeOfProtection() {
        return Optional.ofNullable(this.typeOfProtection);
    }

    public ProcessConditions setExplosionGroup(String explosionGroup) {
        this.explosionGroup = explosionGroup;
        return this;
    }

    public Optional<String> getExplosionGroup() {
        return Optional.ofNullable(this.explosionGroup);
    }

    public ProcessConditions setLowerLimitingValueOfProcessTemperature(String lowerLimitingValueOfProcessTemperature) {
        this.lowerLimitingValueOfProcessTemperature = lowerLimitingValueOfProcessTemperature;
        return this;
    }

    public Optional<String> getLowerLimitingValueOfProcessTemperature() {
        return Optional.ofNullable(this.lowerLimitingValueOfProcessTemperature);
    }

    public ProcessConditions setUpperLimitingValueOfProcessTemperature(String upperLimitingValueOfProcessTemperature) {
        this.upperLimitingValueOfProcessTemperature = upperLimitingValueOfProcessTemperature;
        return this;
    }

    public Optional<String> getUpperLimitingValueOfProcessTemperature() {
        return Optional.ofNullable(this.upperLimitingValueOfProcessTemperature);
    }

    public ProcessConditions setMaxSurfaceTemperatureForDustProof(String maxSurfaceTemperatureForDustProof) {
        this.maxSurfaceTemperatureForDustProof = maxSurfaceTemperatureForDustProof;
        return this;
    }

    public Optional<String> getMaxSurfaceTemperatureForDustProof() {
        return Optional.ofNullable(this.maxSurfaceTemperatureForDustProof);
    }

    public ProcessConditions setTemperatureClass(String temperatureClass) {
        this.temperatureClass = temperatureClass;
        return this;
    }

    public Optional<String> getTemperatureClass() {
        return Optional.ofNullable(this.temperatureClass);
    }
}
