package org.simpleaas.nameplate.nameplate3_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.helper.ElementUtils;
import org.simpleaas.helper.FileModel;
import org.simpleaas.helper.copying.SubmodelCopier;
import org.simpleaas.nameplate.NameplateConstants;
import org.simpleaas.nameplate.nameplate3_0.assetspecificproperty.AssetSpecificProperty;
import org.simpleaas.nameplate.nameplate3_0.marking.Marking;

import java.util.HashMap;
import java.util.Optional;

public class NameplateBuilder3_0 {
    private Submodel template;

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

    public NameplateBuilder3_0(Submodel template) {
        SubmodelCopier copier = new SubmodelCopier(template);
        this.template = copier.createCopy();

        this.template.setKind(ModellingKind.INSTANCE);

        initializeTemplateElements();
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

    public NameplateBuilder3_0 getUriOfTheProduct(String uriOfTheProduct) {

    }

    public NameplateBuilder3_0 setManufacturerName(HashMap<String, String> manufacturerName) {

    }

    public NameplateBuilder3_0 setManufacturerName(HashMap<String, String> manufacturerName) {

    }

    public NameplateBuilder3_0 setManufacturerProductDesignation(HashMap<String, String> manufacturerProductDesignation) {

    }

    public NameplateBuilder3_0 setAddressInformation(ContactInformation contactInformation) {

    }

    public NameplateBuilder3_0 setManufacturerProductRoot(HashMap<String, String> manufacturerProductRoot) {

    }

    public NameplateBuilder3_0 setManufacturerProductFamily(HashMap<String, String> manufacturerProductFamily) {

    }

    public NameplateBuilder3_0 setManufacturerProductType(HashMap<String, String> manufacturerProductType) {

    }

    public NameplateBuilder3_0 setOrderCodeOfManufacturer(String orderCodeOfManufacturer) {

    }

    public NameplateBuilder3_0 setProductArticleNumberOfManufacturer(String productArticleNumberOfManufacturer) {

    }

    public NameplateBuilder3_0 setSerialNumber(String serialNumber) {

    }

    public NameplateBuilder3_0 setYearOfConstruction(String yearOfConstruction) {

    }

    public NameplateBuilder3_0 setDateOfManufacture(String dateOfManufacture) {

    }

    public NameplateBuilder3_0 setHardwareVersion(String hardwareVersion) {

    }

    public NameplateBuilder3_0 setFirmwareVersion(String firmwareVersion) {

    }

    public NameplateBuilder3_0 setSoftwareVersion(String softwareVersion) {

    }

    public NameplateBuilder3_0 setCountryOfOrigin(String countryOfOrigin) {

    }

    public NameplateBuilder3_0 setUniqueFacilityIdentifier(String facilityIdentifier) {

    }

    public NameplateBuilder3_0 setCompanyLogo(FileModel companyLogo) {

    }

    public NameplateBuilder3_0 addMarking(Marking marking) {

    }

    public NameplateBuilder3_0 addAssetSpecificProperty(AssetSpecificProperty assetSpecificProperty) {

    }
}
