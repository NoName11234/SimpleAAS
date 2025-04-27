package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformationReader1_0;
import org.simpleaas.helper.ElementUtils;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.NameplateConstants;
import org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.AssetSpecificPropertyCollection;
import org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.guidelinespecificproperty.GuidelineSpecificPropertyCollection;
import org.simpleaas.nameplate.nameplate2_0.marking.Marking;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.ExplosionSafety;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit.ExternalElectricalCircuit;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit.SafetyRelatedPropertiesForActiveBehaviour;
import org.simpleaas.nameplate.nameplate2_0.marking.explosionsafety.externalelectricalcircuit.SafetyRelatedPropertiesForPassiveBehaviour;

import java.util.*;

public class NameplateReader2_0 {
    private final Submodel nameplateSubmodel;

    public NameplateReader2_0(Submodel submodel) {
        this.nameplateSubmodel = submodel;
    }

    public String getUriOfTheProduct() {
        return ElementUtils.getPropertyValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.uriOfTheProduct).get();
    }

    public HashMap<String, String> getManufacturerName() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.manufacturerName);
    }

    public HashMap<String, String> getManufacturerProductDesignation() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.manufacturerProductDesignation);
    }

    public ContactInformation getContactInformation() {
        return ContactInformationReader1_0.convertSMCtoContactInformation(ElementUtils.getSmc(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.contactInformation).get());
    }

    public HashMap<String, String> getManufacturerProductRoot() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.manufacturerProductRoot);
    }

    public HashMap<String, String> getManufacturerProductFamily() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.manufacturerProductFamily);
    }

    public HashMap<String, String> getManufacturerProductType() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.manufacturerProductType);
    }

    public HashMap<String, String> getOrderCodeOfManufacturer() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.orderCodeOfManufacturer);
    }

    public HashMap<String, String> getProductArticleNumberOfManufacturer() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.productArticleNumber);
    }

    public Optional<String> getSerialNumber() {
        return ElementUtils.getPropertyValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.serialNumber);
    }

    public String getYearOfConstruction() {
        return ElementUtils.getPropertyValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.yearOfConstruction).get();
    }

    public Optional<String> getDateOfManufacture() {
        return ElementUtils.getPropertyValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.dateOfManufacture);
    }

    public HashMap<String, String> getHardwareVersion() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.hardwareVersion);
    }

    public HashMap<String, String> getFirmwareVersion() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.firmwareVersion);
    }

    public HashMap<String, String> getSoftwareVersion() {
        return ElementUtils.getMlpValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.softwareVersion);
    }

    public Optional<String> getCountryOfOrigin() {
        return ElementUtils.getPropertyValue(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.countryOfOrigin);
    }

    public Optional<FileModel> getCompanyLogo() {
        return ElementUtils.getFileModel(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.companyLogo);
    }

    public HashMap<String, Marking> getMarkings() {
        Optional<SubmodelElementCollection> optMarkingsSmc = ElementUtils.getSmc(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.Markings.id);
        HashMap<String, Marking> markings = new HashMap<>();

        if(optMarkingsSmc.isEmpty()) {
            return markings;
        }

        for(SubmodelElement submodelElement: optMarkingsSmc.get().getValue()) {
            if(ElementUtils.compareSemanticId(submodelElement.getSemanticId(), NameplateConstants.Nameplate2_0.Markings.Marking.id)
            && submodelElement instanceof SubmodelElementCollection smc) {
                markings.put(smc.getIdShort(), mapMarking(smc));
            }
        }

        return markings;
    }

    public Optional<AssetSpecificPropertyCollection> getAssetSpecificProperties() {
        Optional<SubmodelElementCollection> optAssetSpecificPropSmc = ElementUtils.getSmc(this.nameplateSubmodel.getSubmodelElements(), NameplateConstants.Nameplate2_0.AssetSpecificProperties.id);

        if(optAssetSpecificPropSmc.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(mapAssetSpecificPropertyCollection(optAssetSpecificPropSmc.get()));
        }
    }

    private Marking mapMarking(SubmodelElementCollection markingSmc) {
        String markingName = ElementUtils.getPropertyValue(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.markingName).get();

        FileModel markingFile = ElementUtils.getFileModel(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.markingFile).get();

        Marking marking = new Marking(markingName, markingFile);

        Optional<String> optDesignation = ElementUtils.getPropertyValue(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.designationOfCertificate);
        Optional<String> optIssueDate = ElementUtils.getPropertyValue(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.issueDate);
        Optional<String> optExpiryDate = ElementUtils.getPropertyValue(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.expiryDate);
        List<Property> additionalTexts = ElementUtils.getPropertyValues(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.markingAdditionalText);

        if(optDesignation.isPresent()) {
            marking.setDesignationOfCertificateOrApproval(optDesignation.get());
        }

        if(optIssueDate.isPresent()) {
            marking.setIssueDate(optIssueDate.get());
        }

        if(optExpiryDate.isPresent()) {
            marking.setExpiryDate(optExpiryDate.get());
        }

        for(Property additionalTextProp: additionalTexts) {
            marking.addAdditionalText(additionalTextProp.getIdShort(), additionalTextProp.getValue());
        }

        Optional<SubmodelElementCollection> optExplosionSafeties = ElementUtils.getSmc(markingSmc.getValue(), NameplateConstants.Nameplate2_0.Markings.Marking.ExplosionSafeties.id);

        if(optExplosionSafeties.isPresent()) {
            marking.setExplosionSafety(mapExplosionSafety(optExplosionSafeties.get()));
        }

        return marking;
    }

    private AssetSpecificPropertyCollection mapAssetSpecificPropertyCollection(SubmodelElementCollection assetPropertySmc) {
        AssetSpecificPropertyCollection assetPropertyCollection = new AssetSpecificPropertyCollection();

        List<SubmodelElementCollection> guidelinePropertyCollectionSmcs = ElementUtils.getSmcs(assetPropertySmc.getValue(), NameplateConstants.Nameplate2_0.AssetSpecificProperties.GuidelineSpecificProperties.id);

        for(SubmodelElementCollection guidelinePropertyCollectionSmc: guidelinePropertyCollectionSmcs) {
            assetPropertyCollection.addGuidelineSpecificPropertyCollection(guidelinePropertyCollectionSmc.getIdShort(), mapGuidelineSpecificPropertyCollection(guidelinePropertyCollectionSmc));
        }

        assetPropertySmc.getValue().stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .forEach(assetPropertyCollection::addArbitraryProperty);

        return assetPropertyCollection;
    }

    private GuidelineSpecificPropertyCollection mapGuidelineSpecificPropertyCollection(SubmodelElementCollection guidelinePropertySmc) {
        Property guidelineForConformityDeclarationProperty = guidelinePropertySmc.getValue().stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> ElementUtils.compareSemanticId(p.getSemanticId(), NameplateConstants.Nameplate2_0.AssetSpecificProperties.GuidelineSpecificProperties.guidelineForConformityDeclaration))
                .findAny().get();

        List<SubmodelElement> elements = new ArrayList<>(guidelinePropertySmc.getValue());

        elements.remove(guidelineForConformityDeclarationProperty);

        List<Property> arbitraryProps = elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .toList();

        GuidelineSpecificPropertyCollection guidelinePropertyCollection = new GuidelineSpecificPropertyCollection(guidelineForConformityDeclarationProperty.getValue());

        for(Property property: arbitraryProps) {
            guidelinePropertyCollection.addArbitraryProperty(property.getIdShort(), property.getValue());
        }

        return guidelinePropertyCollection;
    }

    private ExplosionSafety mapExplosionSafety(SubmodelElementCollection explosionSafetySmc) {

    }

    private ExternalElectricalCircuit mapExternalElectricalCircuit(SubmodelElementCollection externalElectricalCircuitSmc) {

    }

    private SafetyRelatedPropertiesForActiveBehaviour mapSafetyRelatedPropertiesForActiveBehaviour(SubmodelElementCollection propertiesActiveBehaviourSmc) {

    }

    private SafetyRelatedPropertiesForPassiveBehaviour mapSafetyRelatedPropertiesForPassiveBehaviour(SubmodelElementCollection propertiesPassiveBehaviourSmc) {

    }
}
