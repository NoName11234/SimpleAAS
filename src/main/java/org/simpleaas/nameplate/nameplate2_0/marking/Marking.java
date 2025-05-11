package org.simpleaas.nameplate.nameplate2_0.marking;

import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.ExplosionSafety;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Data class for markings in submodel digital nameplate 2.0
 */
public class Marking {
    /**
     * Short ID of the marking.
     */
    private final String shortId;
    /**
     * Common name of the marking.
     */
    private final String markingName;
    /**
     * Optional identifier or reference identifying a certificate or approval.
     */
    private String designationOfCertificateOrApproval = null;
    /**
     * Optional date at which the specified certificate is issued.
     * Format: CCYY-MM-DD
     */
    private String issueDate = null;
    /**
     * Optional date at which the specified certificate expires.
     * Format: CCYY-MM-DD
     */
    private String expiryDate = null;
    /**
     * Conformity symbol of the marking.
     */
    private final FileModel markingFile;
    /**
     * Optional map with additional texts.
     * Where applicable, additional information on the marking in plain text, e.g. the ID-number of the notified body
     * involved in the conformity process.
     * Short ID is used as key.
     */
    private final HashMap<String, String> additionalTexts = new HashMap<>();
    /**
     * List of explosion safety specifications.
     */
    private List<ExplosionSafety> explosionSafeties = new ArrayList<>();

    /**
     * @param shortId short ID of the marking
     * @param markingName common name of the marking
     * @param markingFile conformity symbol of the marking
     */
    public Marking(String shortId, String markingName, FileModel markingFile) {
        this.shortId = shortId;
        this.markingName = markingName;
        this.markingFile = markingFile;
    }

    /**
     * Returns the short ID of the marking.
     * @return short ID
     */
    public String getShortId() {
        return shortId;
    }

    /**
     * Returns the common name of the marking.
     * @return common name of marking
     */
    public String getMarkingName() {
        return this.markingName;
    }

    /**
     * Sets the identifier or reference identifying a certificate or approval.
     * @param designationOfCertificateOrApproval identifier or reference
     */
    public Marking setDesignationOfCertificateOrApproval(String designationOfCertificateOrApproval) {
        this.designationOfCertificateOrApproval = designationOfCertificateOrApproval;
        return this;
    }

    /**
     * Returns the optional identifier or reference identifying a certificate or approval.
     * @return optional identifier or reference
     */
    public Optional<String> getDesignationOfCertificateOrApproval() {
        return Optional.ofNullable(this.designationOfCertificateOrApproval);
    }

    /**
     * Sets the date at which the specified certificate is issued.
     * Format: CCYY-MM-DD
     * @param issueDate issue date of the certificate
     */
    public Marking setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    /**
     * Returns the optional date at which the specified certificate is issued.
     * Format: CCYY-MM-DD
     * @return optional issue date of the certificate
     */
    public Optional<String> getIssueDate() {
        return Optional.ofNullable(this.issueDate);
    }

    /**
     * Sets the date at which the specified certificate expires.
     * Format: CCYY-MM-DD
     * @param expiryDate expiry date of the certificate
     */
    public Marking setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    /**
     * Returns the optional date at which the specified certificate expires.
     * Format: CCYY-MM-DD
     * @return optional expiry date of the certificate
     */
    public Optional<String> getExpiryDate() {
        return Optional.ofNullable(this.expiryDate);
    }

    /**
     * Returns the conformity symbol of the marking.
     * @return conformity symbol of the marking
     */
    public FileModel getMarkingFile() {
        return this.markingFile;
    }

    /**
     * Adds an additional plain text for the marking.
     * @param shortId short ID of the additional text
     * @param additionalText additional plain text for the marking
     */
    public Marking addAdditionalText(String shortId, String additionalText) {
        this.additionalTexts.put(shortId, additionalText);
        return this;
    }

    /**
     * Returns the optional additional plain texts for the marking as map.
     * Short ID is used as key.
     * @return map of additional plain text statements.
     */
    public HashMap<String, String> getAdditionalTexts() {
        return this.additionalTexts;
    }

    /**
     * Checks whether optional additional plain texts are present.
     * @return true if texts are present, else false
     */
    public boolean areAdditionalTextsPresent() {
        return !this.additionalTexts.isEmpty();
    }

    /**
     * Adds explosion safety information to the marking.
     * @param explosionSafety explosion safety information
     */
    public Marking addExplosionSafety(ExplosionSafety explosionSafety) {
        this.explosionSafeties.add(explosionSafety);
        return this;
    }

    /**
     * Returns optional explosion safety information of the marking.
     * @return list of explosion safety information
     */
    public List<ExplosionSafety> getExplosionSafeties() {
        return this.explosionSafeties;
    }

    /**
     * Checks whether optional explosion safety information is present.
     * @return true if explosion safety information is present, else false
     */
    public boolean areExplosionSafetiesPresent() {
        return !this.explosionSafeties.isEmpty();
    }
}
