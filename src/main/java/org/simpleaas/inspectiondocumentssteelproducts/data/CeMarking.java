package org.simpleaas.inspectiondocumentssteelproducts.data;

import org.simpleaas.helper.FileModel;

import java.util.HashMap;
import java.util.Optional;

public class CeMarking {
    private final String shortId;
    private final String markingName;
    private String designationOfCertificateOrApproval = null;
    private String issueDate = null;
    private final FileModel markingFile;
    private final HashMap<String, String> markingAdditionalTexts = new HashMap<>();

    public CeMarking(String shortId, String markingName, FileModel markingFile) {
        this.shortId = shortId;
        this.markingName = markingName;
        this.markingFile = markingFile;
    }

    public String getShortId() {
        return this.shortId;
    }

    public String getMarkingName() {
        return this.markingName;
    }

    public CeMarking setDesignationOfCertificateOrApproval(String designationOfCertificateOrApproval) {
        this.designationOfCertificateOrApproval = designationOfCertificateOrApproval;
        return this;
    }

    public Optional<String> getDesignationOfCertificateOrApproval() {
        return Optional.ofNullable(this.designationOfCertificateOrApproval);
    }

    public CeMarking setIssueDate(String issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public Optional<String> getIssueDate() {
        return Optional.ofNullable(this.issueDate);
    }

    public FileModel getMarkingFile() {
        return this.markingFile;
    }

    public CeMarking addMarkingAdditionalText(String shortId, String markingAdditionalText) {
        this.markingAdditionalTexts.put(shortId, markingAdditionalText);
        return this;
    }

    public HashMap<String, String> getMarkingAdditionalTexts() {
        return this.markingAdditionalTexts;
    }

    public boolean areMarkingAdditionalTextsPresent() {
        return !this.markingAdditionalTexts.isEmpty();
    }
}
