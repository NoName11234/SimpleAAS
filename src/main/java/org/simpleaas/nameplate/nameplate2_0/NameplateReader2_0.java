package org.simpleaas.nameplate.nameplate2_0;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.simpleaas.exception.SubmodelElementNotFoundException;
import org.simpleaas.helper.FileModel;
import org.simpleaas.nameplate.NameplateConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class NameplateReader2_0 {
    private final Submodel nameplateSubmodel;

    public NameplateReader2_0(Submodel submodel) {
        this.nameplateSubmodel = submodel;
    }

}
