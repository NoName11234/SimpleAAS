package org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety;

import java.util.HashMap;
import java.util.Optional;

/**
 * Data class for properties which are related to the ambient conditions of the device.
 */
public class AmbientConditions {
    /**
     * Category of the device in accordance with directive 94/9/EC.
     */
    private String deviceCategory = null;
    /**
     * Equipment protection level according to the IEC standards in multiple languages.
     * Language is used as key.
     */
    private final HashMap<String, String> equipmentProtectionLevel = new HashMap<>();
    /**
     * Marking used only in specific regions.
     */
    private String regionalSpecificMarking = null;
    /**
     * Classification of an explosion protection according to the specific measures applied to avoid ignition of a
     * surrounding explosive atmosphere.
     */
    private String typeOfProtection = null;
    /**
     * Classification of dangerous gaseous substances based on their ability to cause an explosion.
     */
    private String explosionGroup = null;
    /**
     * Lower limit of the temperature range of the surrounding space in which the component, the pipework or the system
     * can be operated.
     */
    private String minimumAmbientTemperature = null;
    /**
     * Upper limit of the temperature range of the surrounding space in which the component, the pipework or the system
     * can be operated.
     */
    private String maxAmbientTemperature = null;
    /**
     * Maximum permissible surface temperature of a device used in an explosion hazardous area with combustible dust.
     */
    private String maxSurfaceTemperatureForDustProof = null;
    /**
     *
     */
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
