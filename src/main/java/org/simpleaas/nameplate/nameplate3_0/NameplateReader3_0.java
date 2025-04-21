package org.simpleaas.nameplate.nameplate3_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.contactinformation.contactinformation1_0.ContactInformation;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.nameplate3_0.assetspecificproperty.AssetSpecificProperty;
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

    }

    public HashMap<String, String> getManufacturerName() {

    }

    public HashMap<String, String> getManufacturerProductDesignation() {

    }

    public ContactInformation getAddressInformation() {

    }

    public HashMap<String, String> getManufacturerProductRoot() {

    }

    public HashMap<String, String> getManufacturerProductFamily() {

    }

    public Optional<String> getManufacturerProductType() {

    }

    public String getOrderCodeOfManufacturer() {

    }

    public Optional<String> getProductArticleNumberOfManufacturer() {

    }

    public Optional<String> getSerialNumber() {

    }

    public Optional<String> getYearOfConstruction() {

    }

    public Optional<String> getDateOfManufacture() {

    }

    public Optional<String> getHardwareVersion() {

    }

    public Optional<String> getFirmwareVersion() {

    }

    public Optional<String> getSoftwareVersion() {

    }

    public Optional<String> getCountryOfOrigin() {

    }

    public Optional<String> getUniqueFacilityIdentifier() {

    }

    public Optional<FileModel> getCompanyLogo() {

    }

    public HashMap<String, Marking> getMarkings() {

    }

    public HashMap<String, AssetSpecificProperty> getAssetSpecificProperties() {

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
