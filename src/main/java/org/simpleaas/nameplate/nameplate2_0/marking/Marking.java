package org.simpleaas.nameplate.nameplate2_0.marking;

import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.ExplosionSafety;

import java.util.HashMap;
import java.util.Optional;

public class Marking {
    private final String markingName;
    private String designationOfCertificateOrApproval = null;
    private String issueDate = null;
    private String expiryDate = null;
    private final FileModel markingFile;
    private final HashMap<String, String> additionalTexts = new HashMap<>();
    private ExplosionSafety explosionSafety = null;

    public Marking(String markingName, FileModel markingFile) {
        this.markingName = markingName;
        this.markingFile = markingFile;
    }

    public String getMarkingName() {
        return this.markingName;
    }

    public Marking setDesignationOfCertificateOrApproval(String designationOfCertificateOrApproval) {
        this.designationOfCertificateOrApproval = designationOfCertificateOrApproval;
        return this;
    }

    public Optional<String> getDesignationOfCertificateOrApproval() {
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

    public Marking addAdditionalText(String shortId, String additionalText) {
        this.additionalTexts.put(shortId, additionalText);
        return this;
    }

    public HashMap<String, String> getAdditionalTexts() {
        return this.additionalTexts;
    }

    public boolean areAdditionalTextsPresent() {
        return !this.additionalTexts.isEmpty();
    }

    public Marking setExplosionSafety(ExplosionSafety explosionSafety) {
        this.explosionSafety = explosionSafety;
        return this;
    }

    public Optional<ExplosionSafety> getExplosionSafety() {
        return Optional.ofNullable(this.explosionSafety);
    }
}
