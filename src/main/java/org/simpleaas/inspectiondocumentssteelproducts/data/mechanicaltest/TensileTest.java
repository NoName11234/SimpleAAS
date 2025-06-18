package org.simpleaas.inspectiondocumentssteelproducts.data.mechanicaltest;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TensileTest {
    private final String shortId;
    private String yieldOrProofStrengthMean = null;
    private String tensileStrengthMean = null;
    private String elongationAfterFractureMean = null;
    private final HashMap<String, String> yieldOrProofStrengthIndividualValues = new HashMap<>();
    private final HashMap<String, String> tensileStrengthIndividualValues = new HashMap<>();
    private final HashMap<String, String> elongationAfterFractureIndividualValues = new HashMap<>();
    private String testTemperature = null;
    private final HashMap<String, String> sampleShape = new HashMap<>();
    private final List<LocationOfSample> locationOfSamples = new java.util.ArrayList<>();
    private final List<DirectionOfSample> directionOfSamples = new java.util.ArrayList<>();

    public TensileTest(String shortId) {
        this.shortId = shortId;
    }

    public String getShortId() {
        return this.shortId;
    }

    public TensileTest setYieldOrProofStrengthMean(String yieldOrProofStrengthMean) {
        this.yieldOrProofStrengthMean = yieldOrProofStrengthMean;
        return this;
    }

    public Optional<String> getYieldOrProofStrengthMean() {
        return Optional.ofNullable(this.yieldOrProofStrengthMean);
    }

    public TensileTest setTensileStrengthMean(String tensileStrengthMean) {
        this.tensileStrengthMean = tensileStrengthMean;
        return this;
    }

    public Optional<String> getTensileStrengthMean() {
        return Optional.ofNullable(this.tensileStrengthMean);
    }

    public TensileTest setElongationAfterFractureMean(String elongationAfterFractureMean) {
        this.elongationAfterFractureMean = elongationAfterFractureMean;
        return this;
    }

    public Optional<String> getElongationAfterFractureMean() {
        return Optional.ofNullable(this.elongationAfterFractureMean);
    }

    public TensileTest addYieldOrProofStrengthIndividualValue(String shortId, String yieldOrProofStrengthIndividualValue) {
        this.yieldOrProofStrengthIndividualValues.put(shortId, yieldOrProofStrengthIndividualValue);
        return this;
    }

    public HashMap<String, String> getYieldOrProofStrengthIndividualValues() {
        return this.yieldOrProofStrengthIndividualValues;
    }

    public boolean areYieldOrProofStrengthIndividualValuesPresent() {
        return !this.yieldOrProofStrengthIndividualValues.isEmpty();
    }

    public TensileTest addTensileStrengthIndividualValue(String shortId, String tensileStrengthIndividualValue) {
        this.tensileStrengthIndividualValues.put(shortId, tensileStrengthIndividualValue);
        return this;
    }

    public HashMap<String, String> getTensileStrengthIndividualValues() {
        return this.tensileStrengthIndividualValues;
    }

    public boolean areTensileStrengthIndividualValuesPresent() {
        return !this.tensileStrengthIndividualValues.isEmpty();
    }

    public TensileTest addElongationAfterFractureIndividualValue(String shortId, String elongationAfterFractureIndividualValue) {
        this.elongationAfterFractureIndividualValues.put(shortId, elongationAfterFractureIndividualValue);
        return this;
    }

    public HashMap<String, String> getElongationAfterFractureIndividualValues() {
        return this.elongationAfterFractureIndividualValues;
    }

    public boolean areElongationAfterFractureIndividualValuesPresent() {
        return !this.elongationAfterFractureIndividualValues.isEmpty();
    }

    public TensileTest setTestTemperature(String testTemperature) {
        this.testTemperature = testTemperature;
        return this;
    }

    public Optional<String> getTestTemperature() {
        return Optional.ofNullable(this.testTemperature);
    }

    public TensileTest addSampleShape(String language, String sampleShape) {
        this.sampleShape.put(language, sampleShape);
        return this;
    }

    public HashMap<String, String> getSampleShape() {
        return this.sampleShape;
    }

    public TensileTest addLocationOfSample(LocationOfSample locationOfSample) {
        this.locationOfSamples.add(locationOfSample);
        return this;
    }

    public List<LocationOfSample> getLocationOfSamples() {
        return this.locationOfSamples;
    }

    public boolean areLocationOfSamplesPresent() {
        return !this.locationOfSamples.isEmpty();
    }
    public TensileTest addDirectionOfSample(DirectionOfSample directionOfSample) {
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
