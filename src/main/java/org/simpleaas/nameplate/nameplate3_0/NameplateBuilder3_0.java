package org.simpleaas.nameplate.nameplate3_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformationBuilder1_0;
import org.simpleaas.helper.ElementUtils;
import org.simpleaas.helper.FileModel;
import org.simpleaas.helper.copying.SubmodelCopier;
import org.simpleaas.helper.copying.SubmodelElementCopier;
import org.simpleaas.nameplate.NameplateConstants;
import org.simpleaas.nameplate.nameplate3_0.marking.Marking;

import java.util.HashMap;

public class NameplateBuilder3_0 {
    private Submodel template;
    private Submodel contactInformationTemplateSubmodel;

    //flags
    private boolean isProductRootUsed = false;
    private boolean isProductFamilyUsed = false;
    private boolean isProductTypeUsed = false;
    private boolean isProductArticleNumberUsed = false;
    private boolean isSerialNumberUsed = false;
    private boolean isYearOfConstructionUsed = false;
    private boolean isDateOfManufacturerUsed = false;
    private boolean isHardwareVersionUsed = false;
    private boolean isFirmwareVersionUsed = false;
    private boolean isSoftwareVersionUsed = false;
    private boolean isCountryOfOrigin = false;
    private boolean isUniqueFacilityIdentifierUsed = false;
    private boolean isCompanyLogoUsed = false;
    private boolean areMarkingsSet = false;

    //template elements
    public SubmodelElementCollection templateMarking;

    public NameplateBuilder3_0(Submodel template, Submodel contactInformationTemplateSubmodel) {
        //prepare template submodel
        SubmodelCopier copier = new SubmodelCopier(template);
        this.template = copier.createCopy();

        this.template.setKind(ModellingKind.INSTANCE);

        initializeTemplateElements();

        //prepare contact information template submodel
        copier = new SubmodelCopier(contactInformationTemplateSubmodel);
        this.contactInformationTemplateSubmodel = copier.createCopy();
    }

    public Submodel getSubmodel() {
        SubmodelCopier copier = new SubmodelCopier(this.template);
        Submodel submodel = copier.createCopy();

        removeTemplateElements(submodel);

        return submodel;
    }

    private void initializeTemplateElements() {
        SubmodelElementList markingsSml = ElementUtils.getSml(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.Markings.id).get();
        this.templateMarking = (SubmodelElementCollection) markingsSml.getValue().get(0);
        this.templateMarking.setIdShort("template-to-be-removed");
    }

    private void removeTemplateElements(Submodel submodel) {
        SubmodelElementList markingsSml = ElementUtils.getSml(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.Markings.id).get();

        //if there are no markings remove markings list, else remove template marking
        if(areMarkingsSet) {
            for(SubmodelElement submodelElement: markingsSml.getValue()) {
                if(submodelElement.getIdShort().equals("template-to-be-removed")) {
                    markingsSml.getValue().remove(submodelElement);
                }
            }
        } else {
            this.template.getSubmodelElements().remove(markingsSml);
        }

    }

    public NameplateBuilder3_0 setUriOfTheProduct(String uriOfTheProduct) {
        Property uriOfTheProductProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.uriOfTheProduct).get();
         uriOfTheProductProp.setValue(uriOfTheProduct);
         return this;
    }

    public NameplateBuilder3_0 setManufacturerName(HashMap<String, String> manufacturerName) {
        MultiLanguageProperty manufacturerNameMlp = ElementUtils.getMlp(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerName).get();
        manufacturerNameMlp.setValue(ElementUtils.convertHashMap(manufacturerName));
        return this;
    }

    public NameplateBuilder3_0 setManufacturerProductDesignation(HashMap<String, String> manufacturerProductDesignation) {
        MultiLanguageProperty productDesignationMlp = ElementUtils.getMlp(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductDesignation).get();
        productDesignationMlp.setValue(ElementUtils.convertHashMap(manufacturerProductDesignation));
        return this;
    }

    public NameplateBuilder3_0 setAddressInformation(ContactInformation contactInformation) {
        ContactInformationBuilder1_0 builder = new ContactInformationBuilder1_0(this.contactInformationTemplateSubmodel);
        SubmodelElementCollection addressInformationSmc = builder.createContactInformationSmc(contactInformation);

        SubmodelElementCollection templateAddressInformationSmc = ElementUtils.getSmc(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.addressInformation).get();
        templateAddressInformationSmc.setValue(addressInformationSmc.getValue());
        return this;
    }

    public NameplateBuilder3_0 setManufacturerProductRoot(HashMap<String, String> manufacturerProductRoot) {
        isProductRootUsed = true;
        MultiLanguageProperty manufacturerProductRootMlp = ElementUtils.getMlp(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductRoot).get();
        manufacturerProductRootMlp.setValue(ElementUtils.convertHashMap(manufacturerProductRoot));
        return this;
    }

    public NameplateBuilder3_0 setManufacturerProductFamily(HashMap<String, String> manufacturerProductFamily) {
        isProductFamilyUsed = true;
        MultiLanguageProperty manufacturerProductFamilyMlp = ElementUtils.getMlp(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductFamily).get();
        manufacturerProductFamilyMlp.setValue(ElementUtils.convertHashMap(manufacturerProductFamily));
        return this;
    }

    public NameplateBuilder3_0 setManufacturerProductType(HashMap<String, String> manufacturerProductType) {
        isProductTypeUsed = true;
        MultiLanguageProperty manufacturerProductTypeMlp = ElementUtils.getMlp(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.manufacturerProductType).get();
        manufacturerProductTypeMlp.setValue(ElementUtils.convertHashMap(manufacturerProductType));
        return this;
    }

    public NameplateBuilder3_0 setOrderCodeOfManufacturer(String orderCodeOfManufacturer) {
        Property orderCodeOfManufacturerProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.orderCodeOfManufacturer).get();
        orderCodeOfManufacturerProp.setValue(orderCodeOfManufacturer);
        return this;
    }

    public NameplateBuilder3_0 setProductArticleNumberOfManufacturer(String productArticleNumberOfManufacturer) {
        isProductArticleNumberUsed = true;
        Property productArticleNumberOfManufacturerProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.productArticleNumberOfManufacturer).get();
        productArticleNumberOfManufacturerProp.setValue(productArticleNumberOfManufacturer);
        return this;
    }

    public NameplateBuilder3_0 setSerialNumber(String serialNumber) {
        isSerialNumberUsed = true;
        Property serialNumberProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.serialNumber).get();
        serialNumberProp.setValue(serialNumber);
        return this;
    }

    public NameplateBuilder3_0 setYearOfConstruction(String yearOfConstruction) {
        isYearOfConstructionUsed = true;
        Property yearOfConstructionProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.yearOfConstruction).get();
        yearOfConstructionProp.setValue(yearOfConstruction);
        return this;
    }

    public NameplateBuilder3_0 setDateOfManufacture(String dateOfManufacture) {
        isDateOfManufacturerUsed = true;
        Property dateOfManufactureProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.dateOfManufacture).get();
        dateOfManufactureProp.setValue(dateOfManufacture);
        return this;
    }

    public NameplateBuilder3_0 setHardwareVersion(String hardwareVersion) {
        isHardwareVersionUsed = true;
        Property hardwareVersionProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.hardwareVersion).get();
        hardwareVersionProp.setValue(hardwareVersion);
        return this;
    }

    public NameplateBuilder3_0 setFirmwareVersion(String firmwareVersion) {
        isFirmwareVersionUsed = true;
        Property firmwareVersionProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.firmwareVersion).get();
        firmwareVersionProp.setValue(firmwareVersion);
        return this;
    }

    public NameplateBuilder3_0 setSoftwareVersion(String softwareVersion) {
        isSoftwareVersionUsed = true;
        Property softwareVersionProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.softwareVersion).get();
        softwareVersionProp.setValue(softwareVersion);
        return this;
    }

    public NameplateBuilder3_0 setCountryOfOrigin(String countryOfOrigin) {
        isCountryOfOrigin = true;
        Property countryOfOriginProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.countryOfOrigin).get();
        countryOfOriginProp.setValue(countryOfOrigin);
        return this;
    }

    public NameplateBuilder3_0 setUniqueFacilityIdentifier(String facilityIdentifier) {
        isUniqueFacilityIdentifierUsed = true;
        Property uniqueFacilityIdentifierProp = ElementUtils.getProperty(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.uniqueFacilityIdentifier).get();
        uniqueFacilityIdentifierProp.setValue(facilityIdentifier);
        return this;
    }

    public NameplateBuilder3_0 setCompanyLogo(FileModel companyLogo) {
        isCompanyLogoUsed = true;
        File companyLogoFile = ElementUtils.getFile(this.template.getSubmodelElements(), NameplateConstants.Nameplate3_0.companyLogo).get();
        companyLogoFile.setValue(companyLogo.getValue());
        companyLogoFile.setContentType(companyLogo.getContentType());
        return this;
    }

    public NameplateBuilder3_0 addMarking(Marking marking) {
        areMarkingsSet = true;

        //copy marking template
        SubmodelElementCopier markingCopier = new SubmodelElementCopier(this.templateMarking);
        SubmodelElementCollection markingSmc = (SubmodelElementCollection) markingCopier.createCopy();

        //map marking
        mapMarkingOnSmc(marking, markingSmc);
    }

    public NameplateBuilder3_0 addAssetSpecificProperty(AssetSpecificProperty assetSpecificProperty) {

    }

    private void mapMarkingOnSmc(Marking marking, SubmodelElementCollection markingSmc) {

    }
}
