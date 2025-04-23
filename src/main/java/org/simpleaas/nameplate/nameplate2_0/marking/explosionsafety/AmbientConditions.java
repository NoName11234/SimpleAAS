package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety;

import java.util.HashMap;
import java.util.Optional;

public class AmbientConditions {
    private String deviceCategory = null;
    private final HashMap<String, String> equipmentProtectionLevel = new HashMap<>();
    private String regionalSpecificMarking = null;
    private String typeOfProtection = null;
    private String explosionGroup = null;
    private String minimumAmbientTemperature = null;
    private String maxAmbientTemperature = null;
    private String maxSurfaceTemperatureForDustProof = null;
    private String temperatureClass = null;

    public Optional<String> getTemperatureClass() {
        return Optional.ofNullable(this.temperatureClass);
    }

    public AmbientConditions setTemperatureClass(String temperatureClass) {
        this.temperatureClass = temperatureClass;
        return this;
    }

    public Optional<String> getMaxSurfaceTemperatureForDustProof() {
        return Optional.ofNullable(this.maxSurfaceTemperatureForDustProof);
    }

    public AmbientConditions setMaxSurfaceTemperatureForDustProof(String maxSurfaceTemperatureForDustProof) {
        this.maxSurfaceTemperatureForDustProof = maxSurfaceTemperatureForDustProof;
        return this;
    }

    public Optional<String> getMaxAmbientTemperature() {
        return Optional.ofNullable(this.maxAmbientTemperature);
    }

    public AmbientConditions setMaxAmbientTemperature(String maxAmbientTemperature) {
        this.maxAmbientTemperature = maxAmbientTemperature;
        return this;
    }

    public Optional<String> getMinimumAmbientTemperature() {
        return Optional.ofNullable(this.minimumAmbientTemperature);
    }

    public AmbientConditions setMinimumAmbientTemperature(String minimumAmbientTemperature) {
        this.minimumAmbientTemperature = minimumAmbientTemperature;
        return this;
    }

    public Optional<String> getExplosionGroup() {
        return Optional.ofNullable(this.explosionGroup);
    }

    public AmbientConditions setExplosionGroup(String explosionGroup) {
        this.explosionGroup = explosionGroup;
        return this;
    }

    public Optional<String> getTypeOfProtection() {
        return Optional.ofNullable(this.typeOfProtection);
    }

    public AmbientConditions setTypeOfProtection(String typeOfProtection) {
        this.typeOfProtection = typeOfProtection;
        return this;
    }

    public Optional<String> getRegionalSpecificMarking() {
        return Optional.ofNullable(this.regionalSpecificMarking);
    }

    public AmbientConditions setRegionalSpecificMarking(String regionalSpecificMarking) {
        this.regionalSpecificMarking = regionalSpecificMarking;
        return this;
    }

    public HashMap<String, String> getEquipmentProtectionLevel() {
        return this.equipmentProtectionLevel;
    }

    public AmbientConditions addEquipmentProtectionLevel(String language, String equipmentProtectionLevel) {
        this.equipmentProtectionLevel.put(language, equipmentProtectionLevel);
        return this;
    }

    public boolean isEquipmentProtectionLevelPresent() {
        return !this.equipmentProtectionLevel.isEmpty();
    }

    public Optional<String> getDeviceCategory() {
        return Optional.ofNullable(this.deviceCategory);
    }

    public AmbientConditions setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
        return this;
    }
}
