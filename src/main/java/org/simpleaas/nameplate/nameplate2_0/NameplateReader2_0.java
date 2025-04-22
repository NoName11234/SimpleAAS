package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.exception.SubmodelElementNotFoundException;
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

    }

    public HashMap<String, String> getManufacturerName() {

    }

    public HashMap<String, String> getManufacturerProductDesignation() {

    }

    public ContactInformation getContactInformation() {

    }

    public HashMap<String, String> getManufacturerProductRoot() {

    }

    public HashMap<String, String> getManufacturerProductFamily() {

    }

    public HashMap<String, String> getManufacturerProductType() {

    }

    public HashMap<String, String> getOrderCodeOfManufacturer() {

    }

    public HashMap<String, String> getProductArticleNumberOfManufacturer() {

    }

    public Optional<String> getSerialNumber() {

    }

    public String getYearOfConstruction() {

    }

    public Optional<String> getDateOfManufacture() {

    }

    public HashMap<String, String> getHardwareVersion() {

    }

    public HashMap<String, String> getFirmwareVersion() {

    }

    public HashMap<String, String> getSoftwareVersion() {

    }

    public Optional<String> getCountryOfOrigin() {

    }

    public Optional<FileModel> getCompanyLogo() {

    }

    public HashMap<String, Marking> getMarkings() {

    }

    public HashMap<String, AssetSpecificPropertyCollection> getAssetSpecificProperties() {
        
    }
}
