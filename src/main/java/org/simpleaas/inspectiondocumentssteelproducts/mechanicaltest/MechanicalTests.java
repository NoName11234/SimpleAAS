package org.simpleaas.inspectiondocumentssteelproducts.mechanicaltest;

import java.util.ArrayList;
import java.util.List;

public class MechanicalTests {
    private final List<TensileTest> tensileTests = new ArrayList<>();
    private final List<HardnessTest> hardnessTests = new ArrayList<>();
    private final List<NotchImpactTest> notchImpactTests = new ArrayList<>();

    public MechanicalTests addTensileTest(TensileTest tensileTest) {
        this.tensileTests.add(tensileTest);
        return this;
    }

    public List<TensileTest> getTensileTests() {
        return this.tensileTests;
    }

    public boolean areTensileTestsPresent() {
        return !this.tensileTests.isEmpty();
    }

    public MechanicalTests addHardnessTest(HardnessTest hardnessTest) {
        this.hardnessTests.add(hardnessTest);
        return this;
    }

    public List<HardnessTest> getHardnessTests() {
        return this.hardnessTests;
    }

    public boolean areHardnessTestsPresent() {
        return !this.hardnessTests.isEmpty();
    }

    public MechanicalTests addNotchImpactTest(NotchImpactTest notchImpactTest) {
        this.notchImpactTests.add(notchImpactTest);
        return this;
    }

    public List<NotchImpactTest> getNotchImpactTests() {
        return this.notchImpactTests;
    }

    public boolean areNotchImpactTestsPresent() {
        return !this.notchImpactTests.isEmpty();
    }
}
