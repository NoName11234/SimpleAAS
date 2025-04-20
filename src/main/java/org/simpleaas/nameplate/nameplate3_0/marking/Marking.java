package org.simpleaas.nameplate.nameplate3_0.marking;

import org.simpleaas.helper.FileModel;

import java.util.HashMap;
import java.util.Optional;

/**
 * Represents a marking of a submodel of type digital nameplate 3.0.
 */
public class Marking {
    /**
     * The name of the marking.
     */
    private final String markingName;
    /**
     * Identifier of the certificate.
     */
    private String designationOfCertificateOrApproval = null;
    /**
     * Date at which the certificate is issued.
     */
    private String issueDate = null;
    /**
     * Date at which the certificate expires.
     */
    private String expiryDate = null;
    /**
     * Conformity symbol of the marking as image.
     */
    private final FileModel markingFile;
    /**
     * Additional information for the marking in plain text.
     * The key is the short ID used for the property.
     */
    private final HashMap<String, String> markingAdditionalTexts = new HashMap<>();

    /**
     * @param markingName the name of the marking
     * @param markingFile conformity symbol of the marking
     */
    public Marking(String markingName, FileModel markingFile) {
        this.markingName = markingName;
        this.markingFile = markingFile;
    }

    public String getMarkingName() {
        return markingName;
    }

    public Marking setDesignation(String designation) {
        this.designationOfCertificateOrApproval = designation;
        return this;
    }

    public Optional<String> getDesignation() {
        return Optional.ofNullable(this.designationOfCertificateOrApproval);
    }

    public Marking setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public Optional<String> getIssueDate() {
        return Optional.ofNullable(this.issueDate);
    }

    public Marking setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public Optional<String> getExpiryDate() {
        return Optional.ofNullable(this.expiryDate);
    }

    public FileModel getMarkingFile() {
        return this.markingFile;
    }

    public Marking addMarkingAdditionalText(String shortId, String additionalText) {
        this.markingAdditionalTexts.put(shortId, additionalText);
        return this;
    }

    public HashMap<String, String> getMarkingAdditionalTexts() {
        return this.markingAdditionalTexts;
    }

    public boolean areMarkingAdditionalTextsPresent() {
        return !this.markingAdditionalTexts.isEmpty();
    }
}
