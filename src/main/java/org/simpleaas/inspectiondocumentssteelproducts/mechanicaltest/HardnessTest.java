package org.simpleaas.inspectiondocumentssteelproducts.mechanicaltest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HardnessTest {
    private final String shortId;
    private String hardnessTestingMethod = null;
    private String hardnessMean = null;
    private final HashMap<String, String> hardnessIndividualValues = new HashMap<>();
    private String testTemperature = null;
    private final List<LocationOfSample> locationOfSamples = new ArrayList<>();
    private final List<DirectionOfSample> directionOfSamples = new ArrayList<>();

    public HardnessTest(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return this.shortId;
    }

    public HardnessTest setHardnessTestingMethod(String hardnessTestingMethod) {
        this.hardnessTestingMethod = hardnessTestingMethod;
        return this;
    }

    public Optional<String> getHardnessTestingMethod() {
        return Optional.ofNullable(this.hardnessTestingMethod);
    }

    public HardnessTest setHardnessMean(String hardnessMean) {
        this.hardnessMean = hardnessMean;
        return this;
    }

    public Optional<String> getHardnessMean() {
        return Optional.ofNullable(this.hardnessMean);
    }

    public HardnessTest addHardnessIndividualValue(String shortId, String hardnessIndividualValue) {
        this.hardnessIndividualValues.put(shortId, hardnessIndividualValue);
        return this;
    }

    public HashMap<String, String> getHardnessIndividualValues() {
        return this.hardnessIndividualValues;
    }

    public boolean areHardnessIndividualValuesPresent() {
        return !this.hardnessIndividualValues.isEmpty();
    }

    public HardnessTest setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
        return this;
    }

    public Optional<String> getTestTemperature() {
        return Optional.ofNullable(this.testTemperature);
    }

    public HardnessTest addLocationOfSample(LocationOfSample locationOfSample) {
        this.locationOfSamples.add(locationOfSample);
        return this;
    }

    public List<LocationOfSample> getLocationOfSamples() {
        return this.locationOfSamples;
    }

    public boolean areLocationOfSamplesPresent() {
        return !this.locationOfSamples.isEmpty();
    }

    public HardnessTest addDirectionOfSample(DirectionOfSample directionOfSample) {
        this.directionOfSamples.add(directionOfSample);
        return this;
    }

    public List<DirectionOfSample> getDirectionOfSamples() {
        return this.directionOfSamples;
    }

    public boolean areDirectionOfSamplesPresent() {
        return !this.directionOfSamples.isEmpty();
    }
}
