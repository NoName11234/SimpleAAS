package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.exception.SubmodelElementNotFoundException;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.NameplateConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NameplateReader2_0 {
    private Submodel nameplateSubmodel;

    public NameplateReader2_0(Submodel submodel) {
        this.nameplateSubmodel = submodel;
    }

    public String getUriOfTheProduct() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optUri = getSubmodelElement(NameplateConstants.Nameplate2_0.uriOfTheProduct, this.nameplateSubmodel.getSubmodelElements());

        if(optUri.isPresent()) {
            SubmodelElement element = optUri.get();

            if(element instanceof Property p) {
                return p.getValue();
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of URI of the product is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of URI of the product in the submodel.");
        }
    }

    public HashMap<String, String> getManufacturerName() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optManuName = getSubmodelElement(NameplateConstants.Nameplate2_0.manufacturerName, this.nameplateSubmodel.getSubmodelElements());

        if(optManuName.isPresent()) {
            SubmodelElement element = optManuName.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of manufacturer name is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of manufacturer name in the submodel.");
        }
    }

    public HashMap<String, String> getManufacturerProductDesignation() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optProductDes = getSubmodelElement(NameplateConstants.Nameplate2_0.manufacturerProductDesignation, this.nameplateSubmodel.getSubmodelElements());

        if(optProductDes.isPresent()) {
            SubmodelElement element = optProductDes.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of manufacturer product designation is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of manufacturer product designation in the submodel.");
        }
    }

    public HashMap<String, String> getManufacturerProductRoot() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optProductRoot = getSubmodelElement(NameplateConstants.Nameplate2_0.manufacturerProductRoot, this.nameplateSubmodel.getSubmodelElements());

        if(optProductRoot.isPresent()) {
            SubmodelElement element = optProductRoot.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of manufacturer product root is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getManufacturerProductFamily() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optProductFamily = getSubmodelElement(NameplateConstants.Nameplate2_0.manufacturerProductFamily, this.nameplateSubmodel.getSubmodelElements());

        if(optProductFamily.isPresent()) {
            SubmodelElement element = optProductFamily.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of manufacturer product family is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getManufacturerProductType() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optProductType = getSubmodelElement(NameplateConstants.Nameplate2_0.manufacturerProductType, this.nameplateSubmodel.getSubmodelElements());

        if(optProductType.isPresent()) {
            SubmodelElement element = optProductType.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of manufacturer product type is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getOrderCodeOfManufacturer() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optOrderCode = getSubmodelElement(NameplateConstants.Nameplate2_0.orderCodeOfManufacturer, this.nameplateSubmodel.getSubmodelElements());

        if(optOrderCode.isPresent()) {
            SubmodelElement element = optOrderCode.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of order code of manufacturer is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getProductArticleNumberOfManufacturer() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optArticleNumber = getSubmodelElement(NameplateConstants.Nameplate2_0.productArticleNumber, this.nameplateSubmodel.getSubmodelElements());

        if(optArticleNumber.isPresent()) {
            SubmodelElement element = optArticleNumber.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of product article number of manufacturer is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public Optional<String> getSerialNumber() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optSerialNumber = getSubmodelElement(NameplateConstants.Nameplate2_0.serialNumber, this.nameplateSubmodel.getSubmodelElements());

        if(optSerialNumber.isPresent()) {
            SubmodelElement element = optSerialNumber.get();

            if(element instanceof Property p) {
                return Optional.of(p.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of serial number is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return Optional.empty();
        }
    }

    public String getYearOfConstruction() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optConstructionYear = getSubmodelElement(NameplateConstants.Nameplate2_0.yearOfConstruction, this.nameplateSubmodel.getSubmodelElements());

        if(optConstructionYear.isPresent()) {
            SubmodelElement element = optConstructionYear.get();

            if(element instanceof Property p) {
                return p.getValue();
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of year of construction is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of year of construction in the submodel.");
        }
    }

    public Optional<String> getDateOfManufacture() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optManuDate = getSubmodelElement(NameplateConstants.Nameplate2_0.dateOfManufacture, this.nameplateSubmodel.getSubmodelElements());

        if(optManuDate.isPresent()) {
            SubmodelElement element = optManuDate.get();

            if(element instanceof Property p) {
                return Optional.of(p.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of date of manufacture is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return Optional.empty();
        }
    }

    public HashMap<String, String> getHardwareVersion() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optHardwareVersion = getSubmodelElement(NameplateConstants.Nameplate2_0.hardwareVersion, this.nameplateSubmodel.getSubmodelElements());

        if(optHardwareVersion.isPresent()) {
            SubmodelElement element = optHardwareVersion.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of hardware version is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getFirmwareVersion() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optFirmwareVersion = getSubmodelElement(NameplateConstants.Nameplate2_0.firmwareVersion, this.nameplateSubmodel.getSubmodelElements());

        if(optFirmwareVersion.isPresent()) {
            SubmodelElement element = optFirmwareVersion.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of firmware version is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public HashMap<String, String> getSoftwareVersion() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optSoftwareVersion = getSubmodelElement(NameplateConstants.Nameplate2_0.softwareVersion, this.nameplateSubmodel.getSubmodelElements());

        if(optSoftwareVersion.isPresent()) {
            SubmodelElement element = optSoftwareVersion.get();

            if(element instanceof MultiLanguageProperty mlp) {
                return convertMlpToHashmap(mlp.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of firmware version is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return new HashMap<>();
        }
    }

    public Optional<String> getCountryOfOrigin() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optOriginCountry = getSubmodelElement(NameplateConstants.Nameplate2_0.countryOfOrigin, this.nameplateSubmodel.getSubmodelElements());

        if(optOriginCountry.isPresent()) {
            SubmodelElement element = optOriginCountry.get();

            if(element instanceof Property p) {
                return Optional.of(p.getValue());
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of country of origin is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return Optional.empty();
        }
    }

    public Optional<FileModel> getCompanyLogo() throws SubmodelElementNotFoundException {
        Optional<SubmodelElement> optCompanyLogo = getSubmodelElement(NameplateConstants.Nameplate2_0.companyLogo, this.nameplateSubmodel.getSubmodelElements());

        if(optCompanyLogo.isPresent()) {
            SubmodelElement element = optCompanyLogo.get();

            if(element instanceof File f) {
                return Optional.of(FileModel.fromFileElement(f));
            } else {
                throw new SubmodelElementNotFoundException("Submodel element with semantic identifier of company logo is from unexpected type " + element.getClass().getName() + ".");
            }
        } else {
            return Optional.empty();
        }
    }

    private Optional<SubmodelElement> getSubmodelElement(String semanticId, List<SubmodelElement> submodelElements) {
        for (SubmodelElement element: submodelElements) {
            List<Key> semanticKeys = element.getSemanticId().getKeys();

            if(!semanticKeys.isEmpty()) {
                Key key = semanticKeys.getFirst();

                if(key.getValue().equals(semanticId)) {
                    return Optional.of(element);
                }
            }
        }

        return Optional.empty();
    }

    private HashMap<String, String> convertMlpToHashmap(List<LangStringTextType> mlpValue) {
        HashMap<String, String> values = new HashMap<>();

        mlpValue.forEach(s -> values.put(s.getLanguage(), s.getText()));

        return values;
    }
}
