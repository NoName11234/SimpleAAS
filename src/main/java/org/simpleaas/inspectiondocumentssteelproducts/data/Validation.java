package org.simpleaas.inspectiondocumentssteelproducts.data;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private final String statementOfCompliance;
    private final String dateOfIssue;
    private final String originatorOfStatement;
    private final List<CeMarking> ceMarkings = new ArrayList<>();

    public Validation(String statementOfCompliance, String dateOfIssue, String originatorOfStatement) {
        this.statementOfCompliance = statementOfCompliance;
        this.dateOfIssue = dateOfIssue;
        this.originatorOfStatement = originatorOfStatement;
    }

    public String getStatementOfCompliance() {
        return this.statementOfCompliance;
    }

    public String getDateOfIssue() {
        return this.dateOfIssue;
    }

    public String getOriginatorOfStatement() {
        return this.originatorOfStatement;
    }

    public Validation addCeMarking(CeMarking ceMarking) {
        this.ceMarkings.add(ceMarking);
        return this;
    }

    public List<CeMarking> getCeMarkings() {
        return this.ceMarkings;
    }

    public boolean areCeMarkingsPresent() {
        return !this.ceMarkings.isEmpty();
    }
}
