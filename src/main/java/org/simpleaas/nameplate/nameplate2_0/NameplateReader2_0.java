package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.Key;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

import java.util.List;
import java.util.Optional;

public class NameplateReader2_0 {
    private Submodel nameplateSubmodel;

    public NameplateReader2_0(Submodel submodel) {
        this.nameplateSubmodel = submodel;
    }

    public String getUriOfTheProduct() {

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
}
