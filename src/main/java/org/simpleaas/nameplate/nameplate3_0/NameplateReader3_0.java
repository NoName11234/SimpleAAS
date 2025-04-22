package org.simpleaas.nameplate.nameplate3_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformationReader1_0;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.NameplateConstants;
import org.simpleaas.nameplate.nameplate3_0.assetspecificproperty.AssetSpecificProperty;
import org.simpleaas.nameplate.nameplate3_0.assetspecificproperty.GuidelineSpecificProperty;
import org.simpleaas.nameplate.nameplate3_0.marking.Marking;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NameplateReader3_0 {
    private final Submodel submodel;

    public NameplateReader3_0(Submodel submodel) {
        this.submodel = submodel;
    }

    public String getUriOfTheProduct() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.uriOfTheProduct).get();
    }

    public HashMap<String, String> getManufacturerName() {
        return getMlpValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerName);
    }

    public HashMap<String, String> getManufacturerProductDesignation() {
        return getMlpValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductDesignation);
    }

    public ContactInformation getAddressInformation() {
        return ContactInformationReader1_0.convertSMCtoContactInformation(getSmc(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.addressInformation).get());
    }

    public HashMap<String, String> getManufacturerProductRoot() {
        return getMlpValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductRoot);
    }

    public HashMap<String, String> getManufacturerProductFamily() {
        return getMlpValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductFamily);
    }

    public Optional<String> getManufacturerProductType() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductType);
    }

    public String getOrderCodeOfManufacturer() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.orderCodeOfManufacturer).get();
    }

    public Optional<String> getProductArticleNumberOfManufacturer() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.productArticleNumberOfManufacturer);
    }

    public Optional<String> getSerialNumber() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.serialNumber);
    }

    public Optional<String> getYearOfConstruction() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.yearOfConstruction);
    }

    public Optional<String> getDateOfManufacture() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.dateOfManufacture);
    }

    public Optional<String> getHardwareVersion() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.hardwareVersion);
    }

    public Optional<String> getFirmwareVersion() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.firmwareVersion);
    }

    public Optional<String> getSoftwareVersion() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.softwareVersion);
    }

    public Optional<String> getCountryOfOrigin() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.countryOfOrigin);
    }

    public Optional<String> getUniqueFacilityIdentifier() {
        return getPropertyValue(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.uniqueFacilityIdentifier);
    }

    public Optional<FileModel> getCompanyLogo() {
        return getFileModel(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.companyLogo);
    }

    public HashMap<String, Marking> getMarkings() {
        Optional<SubmodelElementCollection> optMarkings = getSmc(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.Markings.id);

        if(optMarkings.isEmpty()) {
            return new HashMap<>();
        }

        List<SubmodelElementCollection> markingSmcs = optMarkings.get().getValue().stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .filter(smc -> compareSemanticId(smc.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.id))
                .toList();

        HashMap<String, Marking> markings = new HashMap<>();

        for(SubmodelElementCollection markingSmc: markingSmcs) {
            markings.put(markingSmc.getIdShort(), mapMarking(markingSmc));
        }

        return markings;
    }

    public AssetSpecificProperty getAssetSpecificProperties() {
        Optional<SubmodelElementCollection> optAssetSpecificPropSmc = getSmc(this.submodel.getSubmodelElements(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.id);
        AssetSpecificProperty assetSpecificProperty = new AssetSpecificProperty();

        if(optAssetSpecificPropSmc.isEmpty()) {
            return assetSpecificProperty;
        }

        for(SubmodelElement submodelElement: optAssetSpecificPropSmc.get().getValue()) {
            if(submodelElement instanceof Property property) {
                if(compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.arbitraryProperty)) {
                    assetSpecificProperty.addArbitraryProperty(property.getIdShort(), property.getValue());
                }
            } else if (submodelElement instanceof MultiLanguageProperty mlp) {
                if(compareSemanticId(mlp.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.arbitraryMlp)) {
                    assetSpecificProperty.addArbitraryMlp(mlp.getIdShort(), convertMlp(mlp));
                }
            } else if (submodelElement instanceof File file) {
                if(compareSemanticId(file.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.arbitraryFile)) {
                    assetSpecificProperty.addArbitraryFile(file.getIdShort(), new FileModel(file.getValue(), file.getContentType()));
                }
            } else if (submodelElement instanceof SubmodelElementList sml) {
                if(compareSemanticId(sml.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.id)) {
                    for(SubmodelElement guidelineSpecificElem: sml.getValue()) {
                        if(guidelineSpecificElem instanceof SubmodelElementCollection smc) {
                            if(compareSemanticId(smc.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.GuidelineSpecificProperty.id)) {
                                assetSpecificProperty.addGuidelineSpecificProperty(smc.getIdShort(), mapGuidelineSpecificProperty(smc));
                            }
                        }
                    }
                }
            }
        }

        return assetSpecificProperty;
    }

    private GuidelineSpecificProperty mapGuidelineSpecificProperty(SubmodelElementCollection guidelineSpecificPropertySmc) {
        Property guidelineForConformityDeclaration = guidelineSpecificPropertySmc.getValue().stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.GuidelineSpecificProperty.guidelineForConformityDeclaration))
                .findAny().get();

        GuidelineSpecificProperty guidelineSpecificProperty = new GuidelineSpecificProperty(guidelineForConformityDeclaration.getValue());

        for (SubmodelElement submodelElement: guidelineSpecificPropertySmc.getValue()) {
            if(submodelElement instanceof Property property) {
                if(compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.GuidelineSpecificProperty.arbitraryProperty)) {
                    guidelineSpecificProperty.addArbitraryProperty(property.getIdShort(), property.getValue());
                }
            } else if(submodelElement instanceof MultiLanguageProperty mlp) {
                if(compareSemanticId(mlp.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.GuidelineSpecificProperty.arbitraryMlp)) {
                    guidelineSpecificProperty.addArbitraryMlp(mlp.getIdShort(), convertMlp(mlp));
                }
            } else if(submodelElement instanceof File file) {
                if(compareSemanticId(file.getSemanticId(), NameplateConstants.Nameplate3_0.AssetSpecificProperties.GuidelineSpecificProperties.GuidelineSpecificProperty.arbitraryFile)) {
                    guidelineSpecificProperty.addArbitraryFile(file.getIdShort(), new FileModel(file.getValue(), file.getContentType()));
                }
            }
        }

        return guidelineSpecificProperty;
    }

    private Marking mapMarking(SubmodelElementCollection markingSmc) {
        Property markingName = markingSmc.getValue().stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.markingName))
                .findAny().get();

        File markingFile = markingSmc.getValue().stream()
                .filter(se -> se instanceof File)
                .map(se -> ((File)se))
                .filter(f -> compareSemanticId(f.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.markingFile))
                .findAny().get();


        Marking marking = new Marking(markingName.getValue(), new FileModel(markingFile.getValue(), markingFile.getContentType()));

        for(SubmodelElement markingElement: markingSmc.getValue()) {
            if(markingElement instanceof Property property) {
                if(compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.designationOfCertificateOrApproval)) {
                    marking.setDesignation(property.getValue());
                } else if (compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.issueDate)) {
                    marking.setIssueDate(property.getValue());
                } else if (compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.expiryDate)) {
                    marking.setExpiryDate(property.getValue());
                } else if (compareSemanticId(property.getSemanticId(), NameplateConstants.Nameplate3_0.Markings.Marking.markingAdditionalText)) {
                    marking.addMarkingAdditionalText(property.getIdShort(), property.getValue());
                }
            }
        }

        return marking;
    }

    private boolean compareSemanticId(Reference reference, String semanticId) {
        for(Key key: reference.getKeys()) {
            if(key.getValue().equals(semanticId)) {
                return true;
            }
        }

        return false;
    }

    private Optional<String> getPropertyValue(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof Property)
                .map(se -> ((Property)se))
                .filter(p -> compareSemanticId(p.getSemanticId(), semanticId))
                .map(Property::getValue)
                .findAny();
    }

    private HashMap<String, String> getMlpValue(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof MultiLanguageProperty)
                .map(se -> ((MultiLanguageProperty)se))
                .filter(mlp -> compareSemanticId(mlp.getSemanticId(), semanticId))
                .map(this::convertMlp)
                .findAny().orElse(new HashMap<>());
    }

    private Optional<SubmodelElementCollection> getSmc(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof SubmodelElementCollection)
                .map(se -> ((SubmodelElementCollection)se))
                .filter(smc -> compareSemanticId(smc.getSemanticId(), semanticId))
                .findAny();
    }

    private Optional<FileModel> getFileModel(List<SubmodelElement> elements, String semanticId) {
        return elements.stream()
                .filter(se -> se instanceof File)
                .map(se -> ((File)se))
                .filter(f -> compareSemanticId(f.getSemanticId(), semanticId))
                .map(f -> new FileModel(f.getValue(), f.getContentType()))
                .findAny();
    }

    private HashMap<String, String> convertMlp(MultiLanguageProperty mlp) {
        HashMap<String, String> values = new HashMap<>();

        for(LangStringTextType value: mlp.getValue()) {
            values.put(value.getLanguage(), value.getText());
        }

        return values;
    }
}
