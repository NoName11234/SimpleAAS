package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.exception.SubmodelElementNotFoundException;
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
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of manufacturer product root in the submodel.");
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
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of manufacturer product family in the submodel.");
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
            throw new SubmodelElementNotFoundException("Unable to find submodel element with semantic identifier of manufacturer product type in the submodel.");
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
