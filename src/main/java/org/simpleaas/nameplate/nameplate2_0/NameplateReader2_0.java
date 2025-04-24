package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformationReader1_0;
import org.simpleaas.exception.SubmodelElementNotFoundException;
import org.simpleaas.helper.ElementUtils;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.NameplateConstants;
import org.simpleaas.nameplate.nameplate2_0.assetspecificproperty.AssetSpecificPropertyCollection;
import org.simpleaas.nameplate.nameplate2_0.marking.Marking;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
        
    }

    public HashMap<String, AssetSpecificPropertyCollection> getAssetSpecificProperties() {
        
    }
}
