package org.simpleaas.helper.copying;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAdministrativeInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;

/**
 * Class for copying submodels.
 */
public class SubmodelCopier {
    /**
     * The original submodel to be copied.
     */
    private Submodel original;

    /**
     * @param original the original submodel to be copied
     */
    public SubmodelCopier(Submodel original) {
        this.original = original;
    }

    /**
     * Creates a copy of the original submodel.
     * @return copied submodel
     */
    public Submodel createCopy() {
        var submodelBuilder = new DefaultSubmodel.Builder();

        submodelBuilder.idShort(original.getIdShort());

        for(LangStringNameType displayName: original.getDisplayName()) {
            submodelBuilder.displayName(SubmodelElementCopier.copyLangStringNameType(displayName));
        }

        submodelBuilder.category(original.getCategory());

        for(LangStringTextType desc: original.getDescription()) {
            submodelBuilder.description(SubmodelElementCopier.copyLangStringTextType(desc));
        }

        submodelBuilder.id(original.getId());

        if(original.getAdministration() != null) {
            submodelBuilder.administration(copyAdministration(original.getAdministration()));
        }

        submodelBuilder.kind(original.getKind());

        if(original.getSemanticId() != null) {
            submodelBuilder.semanticId(SubmodelElementCopier.copyReference(original.getSemanticId()));
        }

        for(Reference supSemanticId: original.getSupplementalSemanticIds()) {
            submodelBuilder.supplementalSemanticIds(SubmodelElementCopier.copyReference(supSemanticId));
        }

        for(Qualifier qualifier: original.getQualifiers()) {
            submodelBuilder.qualifiers(SubmodelElementCopier.copyQualifier(qualifier));
        }

        for(EmbeddedDataSpecification specification: original.getEmbeddedDataSpecifications()) {
            submodelBuilder.embeddedDataSpecifications(SubmodelElementCopier.copyEmbeddedDataSpecification(specification));
        }

        for(Extension extension: original.getExtensions()) {
            submodelBuilder.extensions(SubmodelElementCopier.copyExtension(extension));
        }

        for(SubmodelElement submodelElement: original.getSubmodelElements()) {
            SubmodelElementCopier copier = new SubmodelElementCopier(submodelElement);
            submodelBuilder.submodelElements(copier.createCopy());
        }

        return submodelBuilder.build();
    }

    /**
     * Creates a copy of an AdministrativeInformation.
     * @param original the original AdministrativeInformation to be copied
     * @return copied AdministrativeInformation
     */
    private AdministrativeInformation copyAdministration(AdministrativeInformation original) {
        var adInfBuilder = new DefaultAdministrativeInformation.Builder();

        adInfBuilder.version(original.getVersion());
        adInfBuilder.revision(original.getRevision());
        adInfBuilder.templateId(original.getTemplateId());

        if(original.getCreator() != null) {
            adInfBuilder.creator(SubmodelElementCopier.copyReference(original.getCreator()));
        }

        for(EmbeddedDataSpecification specification: original.getEmbeddedDataSpecifications()) {
            adInfBuilder.embeddedDataSpecifications(SubmodelElementCopier.copyEmbeddedDataSpecification(specification));
        }

        return adInfBuilder.build();
    }
}
