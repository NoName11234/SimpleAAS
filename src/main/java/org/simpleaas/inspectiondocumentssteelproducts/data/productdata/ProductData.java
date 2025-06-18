package org.simpleaas.inspectiondocumentssteelproducts.data.productdata;

import org.simpleaas.helper.BlobModel;

import java.util.HashMap;
import java.util.Optional;

public class ProductData {
    private String manufacturerProductNumber = null;
    private String customerProductNumber = null;
    private final HashMap<String, String> productDescriptions = new HashMap<>();
    private final HashMap<String, String> additionalProductRequirements = new HashMap<>();
    private String batchNumber = null;
    private String materialNumber = null;
    private String materialShortName = null;
    private final HashMap<String, String> materialAdditionalInformation = new HashMap<>();
    private String numberOfPieces = null;
    private String theoreticalMass = null;
    private String actualMass = null;
    private SemiFinishedProductSpecification semiFinishedProductSpecification = null;
    private final HashMap<String, BlobModel> drawings = new HashMap<>();

    public ProductData setManufacturerProductNumber(String manufacturerProductNumber) {
        this.manufacturerProductNumber = manufacturerProductNumber;
        return this;
    }

    public Optional<String> getManufacturerProductNumber() {
        return Optional.ofNullable(this.manufacturerProductNumber);
    }

    public ProductData setCustomerProductNumber(String customerProductNumber) {
        this.customerProductNumber = customerProductNumber;
        return this;
    }

    public Optional<String> getCustomerProductNumber() {
        return Optional.ofNullable(this.customerProductNumber);
    }

    public ProductData addProductDescription(String language, String description) {
        this.productDescriptions.put(language, description);
        return this;
    }

    public HashMap<String, String> getProductDescriptions() {
        return this.productDescriptions;
    }

    public boolean isProductDescriptionPresent() {
        return !this.productDescriptions.isEmpty();
    }

    public ProductData addAdditionalProductRequirement(String language, String requirement) {
        this.additionalProductRequirements.put(language, requirement);
        return this;
    }

    public HashMap<String, String> getAdditionalProductRequirements() {
        return this.additionalProductRequirements;
    }

    public boolean isAdditionalProductRequirementPresent() {
        return !this.additionalProductRequirements.isEmpty();
    }

    public ProductData setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
        return this;
    }

    public Optional<String> getBatchNumber() {
        return Optional.ofNullable(this.batchNumber);
    }

    public ProductData setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
        return this;
    }

    public Optional<String> getMaterialNumber() {
        return Optional.ofNullable(this.materialNumber);
    }

    public ProductData setMaterialShortName(String materialShortName) {
        this.materialShortName = materialShortName;
        return this;
    }

    public Optional<String> getMaterialShortName() {
        return Optional.ofNullable(this.materialShortName);
    }

    public ProductData addMaterialAdditionalInformation(String language, String additionalInformation) {
        this.materialAdditionalInformation.put(language, additionalInformation);
        return this;
    }

    public HashMap<String, String> getMaterialAdditionalInformation() {
        return this.materialAdditionalInformation;
    }

    public boolean isMaterialAdditionalInformationPresent() {
        return !this.materialAdditionalInformation.isEmpty();
    }

    public ProductData setNumberOfPieces(String numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
        return this;
    }

    public Optional<String> getNumberOfPieces() {
        return Optional.ofNullable(this.numberOfPieces);
    }

    public ProductData setTheoreticalMass(String theoreticalMass) {
        this.theoreticalMass = theoreticalMass;
        return this;
    }

    public Optional<String> getTheoreticalMass() {
        return Optional.ofNullable(this.theoreticalMass);
    }

    public ProductData setActualMass(String actualMass) {
        this.actualMass = actualMass;
        return this;
    }

    public Optional<String> getActualMass() {
        return Optional.ofNullable(this.actualMass);
    }

    public ProductData setSemiFinishedProductSpecification(SemiFinishedProductSpecification semiFinishedProductSpecification) {
        this.semiFinishedProductSpecification = semiFinishedProductSpecification;
        return this;
    }

    public Optional<SemiFinishedProductSpecification> getSemiFinishedProductSpecification() {
        return Optional.ofNullable(this.semiFinishedProductSpecification);
    }

    public ProductData addDrawing(String shortId, BlobModel blobModel) {
        this.drawings.put(shortId, blobModel);
        return this;
    }

    public HashMap<String, BlobModel> getDrawings() {
        return this.drawings;
    }

    public boolean areDrawingsPresent() {
        return !this.drawings.isEmpty();
    }
}
