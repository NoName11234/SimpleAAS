package org.simpleaas.nameplate.nameplate3_0;

import org.eclipse.digitaltwin.aas4j.v3.model.ModellingKind;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElementCollection;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.helper.FileModel;
import org.simpleaas.helper.copying.SubmodelCopier;
import org.simpleaas.nameplate.nameplate3_0.assetspecificproperty.AssetSpecificProperty;
import org.simpleaas.nameplate.nameplate3_0.marking.Marking;

import java.util.HashMap;

public class NameplateBuilder3_0 {
    private Submodel template;

    //template elements
    public SubmodelElementCollection templateMarking;

    public NameplateBuilder3_0(Submodel template) {
        SubmodelCopier copier = new SubmodelCopier(template);
        this.template = copier.createCopy();

        this.template.setKind(ModellingKind.INSTANCE);

        initializeTemplateElements();
    }

    public Submodel getSubmodel() {

    }

    private void initializeTemplateElements() {

    }

    private void removeTemplateElements(Submodel submodel) {

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
