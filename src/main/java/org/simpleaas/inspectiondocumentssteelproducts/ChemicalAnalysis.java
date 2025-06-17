package org.simpleaas.inspectiondocumentssteelproducts;

import java.util.HashMap;
import java.util.Optional;

public class ChemicalAnalysis {
    private final HashMap<String, String> steelProductionProcess = new HashMap<>();
    private String massFractionAl = null;
    private String massFractionBe = null;
    private String massFractionC = null;
    private String massFractionCr = null;
    private String massFractionCu = null;
    private String massFractionMn = null;
    private String massFractionMo = null;
    private String massFractionN = null;
    private String massFractionNb = null;
    private String massFractionNi = null;
    private String massFractionP = null;
    private String massFractionPb = null;
    private String massFractionS = null;
    private String massFractionSi = null;
    private String massFractionTa = null;
    private String massFractionTi = null;
    private String massFractionV = null;
    private String massFractionW = null;

    public ChemicalAnalysis addSteelProductionProcess(String shortId, String steelProductionProcess) {
        this.steelProductionProcess.put(shortId, steelProductionProcess);
        return this;
    }

    public HashMap<String, String> getSteelProductionProcess() {
        return this.steelProductionProcess;
    }

    public boolean isSteelProductionProcessPresent() {
        return !this.steelProductionProcess.isEmpty();
    }

    public ChemicalAnalysis setMassFractionAl(String massFractionAl) {
        this.massFractionAl = massFractionAl;
        return this;
    }

    public Optional<String> getMassFractionAl() {
        return Optional.ofNullable(this.massFractionAl);
    }

    public ChemicalAnalysis setMassFractionBe(String massFractionBe) {
        this.massFractionBe = massFractionBe;
        return this;
    }

    public Optional<String> getMassFractionBe() {
        return Optional.ofNullable(this.massFractionBe);
    }

    public ChemicalAnalysis setMassFractionC(String massFractionC) {
        this.massFractionC = massFractionC;
        return this;
    }

    public Optional<String> getMassFractionC() {
        return Optional.ofNullable(this.massFractionC);
    }

    public ChemicalAnalysis setMassFractionCr(String massFractionCr) {
        this.massFractionCr = massFractionCr;
        return this;
    }
    public Optional<String> getMassFractionCr() {
        return Optional.ofNullable(this.massFractionCr);
    }

    public ChemicalAnalysis setMassFractionCu(String massFractionCu) {
        this.massFractionCu = massFractionCu;
        return this;
    }

    public Optional<String> getMassFractionCu() {
        return Optional.ofNullable(this.massFractionCu);
    }

    public ChemicalAnalysis setMassFractionMn(String massFractionMn) {
        this.massFractionMn = massFractionMn;
        return this;
    }

    public Optional<String> getMassFractionMn() {
        return Optional.ofNullable(this.massFractionMn);
    }

    public ChemicalAnalysis setMassFractionMo(String massFractionMo) {
        this.massFractionMo = massFractionMo;
        return this;
    }

    public Optional<String> getMassFractionMo() {
        return Optional.ofNullable(this.massFractionMo);
    }

    public ChemicalAnalysis setMassFractionN(String massFractionN) {
        this.massFractionN = massFractionN;
        return this;
    }

    public Optional<String> getMassFractionN() {
        return Optional.ofNullable(this.massFractionN);
    }

    public ChemicalAnalysis setMassFractionNb(String massFractionNb) {
        this.massFractionNb = massFractionNb;
        return this;
    }

    public Optional<String> getMassFractionNb() {
        return Optional.ofNullable(this.massFractionNb);
    }

    public ChemicalAnalysis setMassFractionNi(String massFractionNi) {
        this.massFractionNi = massFractionNi;
        return this;
    }

    public Optional<String> getMassFractionNi() {
        return Optional.ofNullable(this.massFractionNi);
    }

    public ChemicalAnalysis setMassFractionP(String massFractionP) {
        this.massFractionP = massFractionP;
        return this;
    }

    public Optional<String> getMassFractionP() {
        return Optional.ofNullable(this.massFractionP);
    }

    public ChemicalAnalysis setMassFractionPb(String massFractionPb) {
        this.massFractionPb = massFractionPb;
        return this;
    }

    public Optional<String> getMassFractionPb() {
        return Optional.ofNullable(this.massFractionPb);
    }

    public ChemicalAnalysis setMassFractionS(String massFractionS) {
        this.massFractionS = massFractionS;
        return this;
    }

    public Optional<String> getMassFractionS() {
        return Optional.ofNullable(this.massFractionS);
    }

    public ChemicalAnalysis setMassFractionSi(String massFractionSi) {
        this.massFractionSi = massFractionSi;
        return this;
    }

    public Optional<String> getMassFractionSi() {
        return Optional.ofNullable(this.massFractionSi);
    }

    public ChemicalAnalysis setMassFractionTa(String massFractionTa) {
        this.massFractionTa = massFractionTa;
        return this;
    }

    public Optional<String> getMassFractionTa() {
        return Optional.ofNullable(this.massFractionTa);
    }

    public ChemicalAnalysis setMassFractionTi(String massFractionTi) {
        this.massFractionTi = massFractionTi;
        return this;
    }

    public Optional<String> getMassFractionTi() {
        return Optional.ofNullable(this.massFractionTi);
    }

    public ChemicalAnalysis setMassFractionV(String massFractionV) {
        this.massFractionV = massFractionV;
        return this;
    }

    public Optional<String> getMassFractionV() {
        return Optional.ofNullable(this.massFractionV);
    }

    public ChemicalAnalysis setMassFractionW(String massFractionW) {
        this.massFractionW = massFractionW;
        return this;
    }

    public Optional<String> getMassFractionW() {
        return Optional.ofNullable(this.massFractionW);
    }
}
