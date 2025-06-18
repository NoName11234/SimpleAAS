package org.simpleaas.inspectiondocumentssteelproducts.data.mechanicaltest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotchImpactTest {
    private final String shortId;
    private String notchImpactStrengthMean = null;
    private final List<NotchImpactStrengthIndividualValue> notchImpactStrengthIndividualValues = new ArrayList<>();
    private String notchImpactWorkMean = null;
    private final List<NotchImpactWorkIndividualValue> notchImpactWorkIndividualValues = new ArrayList<>();
    private String sampleType = null;
    private String sampleWidth = null;
    private String testTemperature = null;
    private final List<LocationOfSample> locationOfSamples = new ArrayList<>();
    private final List<DirectionOfSample> directionOfSamples = new ArrayList<>();

    public NotchImpactTest(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return this.shortId;
    }

    public NotchImpactTest setNotchImpactStrengthMean(String notchImpactStrengthMean) {
        this.notchImpactStrengthMean = notchImpactStrengthMean;
        return this;
    }

    public Optional<String> getNotchImpactStrengthMean() {
        return Optional.ofNullable(this.notchImpactStrengthMean);
    }

    public NotchImpactTest addNotchImpactStrengthIndividualValue(NotchImpactStrengthIndividualValue notchImpactStrengthIndividualValue) {
        this.notchImpactStrengthIndividualValues.add(notchImpactStrengthIndividualValue);
        return this;
    }

    public List<NotchImpactStrengthIndividualValue> getNotchImpactStrengthIndividualValues() {
        return this.notchImpactStrengthIndividualValues;
    }

    public boolean areNotchImpactStrengthIndividualValuesPresent() {
        return !this.notchImpactStrengthIndividualValues.isEmpty();
    }

    public NotchImpactTest setNotchImpactWorkMean(String notchImpactWorkMean) {
        this.notchImpactWorkMean = notchImpactWorkMean;
        return this;
    }

    public Optional<String> getNotchImpactWorkMean() {
        return Optional.ofNullable(this.notchImpactWorkMean);
    }

    public NotchImpactTest addNotchImpactWorkIndividualValue(NotchImpactWorkIndividualValue notchImpactWorkIndividualValue) {
        this.notchImpactWorkIndividualValues.add(notchImpactWorkIndividualValue);
        return this;
    }

    public List<NotchImpactWorkIndividualValue> getNotchImpactWorkIndividualValues() {
        return this.notchImpactWorkIndividualValues;
    }

    public boolean areNotchImpactWorkIndividualValuesPresent() {
        return !this.notchImpactWorkIndividualValues.isEmpty();
    }

    public NotchImpactTest setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    public Optional<String> getSampleType() {
        return Optional.ofNullable(this.sampleType);
    }

    public NotchImpactTest setSampleWidth(String sampleWidth) {
        this.sampleWidth = sampleWidth;
        return this;
    }

    public Optional<String> getSampleWidth() {
        return Optional.ofNullable(this.sampleWidth);
    }

    public NotchImpactTest setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
        return this;
    }

    public Optional<String> getTestTemperature() {
        return Optional.ofNullable(this.testTemperature);
    }

    public NotchImpactTest addLocationOfSample(LocationOfSample locationOfSample) {
        this.locationOfSamples.add(locationOfSample);
        return this;
    }

    public List<LocationOfSample> getLocationOfSamples() {
        return this.locationOfSamples;
    }

    public boolean areLocationOfSamplesPresent() {
        return !this.locationOfSamples.isEmpty();
    }

    public NotchImpactTest addDirectionOfSample(DirectionOfSample directionOfSample) {
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
