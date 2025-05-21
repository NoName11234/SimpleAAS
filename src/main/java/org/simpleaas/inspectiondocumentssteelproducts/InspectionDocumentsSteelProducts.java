package org.simpleaas.inspectiondocumentssteelproducts;

public class InspectionDocumentsSteelProducts {
    public static String id = "https://admin-shell.io/idta/SubmodelTemplate/InspectionDocumentsOfSteelProducts/1/0";

    public static class Manufacturer {
        public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/Manufacturer/1/0";
        public static String companyName = "0173-1#02-AAO677#003";
        public static String street = "0173-1#07-ABL858#002";
        public static String zipCode = "0173-1#07-ABL861#002";
        public static String city = "0173-1#07-ABL860#002";
        public static String nationalCode = "0173-1#07-ABL863#002";
        public static String mailAddress = "0173-1#07-ABA042#003";
    }

    public static class Customer {
        public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/Customer/1/0";
        public static String companyName = "0173-1#02-AAO677#003";
        public static String customerRole = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/CustomerRole/1/0";
        public static String street = "0173-1#07-ABL858#002";
        public static String zipCode = "0173-1#07-ABL861#002";
        public static String city = "0173-1#07-ABL860#002";
        public static String nationalCode = "0173-1#07-ABL863#002";
        public static String mailAddress = "0173-1#07-ABA042#003";
    }

    public static class OrderData {
        public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/OrderData/1/0";
        public static String typeOfInspectionDocument = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/KindOfInspectionDocument/1/0";
        public static String orderDate = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/OrderDate/1/0";
        public static String manufacturerOrderNumber = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/ManufacturerOrderNumber/1/0";
        public static String purchaserOrderNumber = "0173-1#02-ABF517#002";
        public static String deliveryNoteNumber = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/DeliveryNoteNumber/1/0";
    }

    public static class ProductData {
        public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/ProductData/1/0";
        public static String manufacturerProductNumber = "0173-1#02-AAO689#002";
        public static String customerProductNumber = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/CustomerProductNumber/1/0";
        public static String productDescription = "0173-1#02-AAU734#002";
        public static String additionalProductRequirements = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/AdditionalProductRequirements/1/0";
        public static String batchNumber = "0173-1#02-AAQ196#002";
        public static String materialNumber = "0173-1#02-AAZ538#003";
        public static String materialShortName = "0173-1#02-AAZ536#003";
        public static String materialAdditionalInformation = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/MaterialAdditionalInformation/1/0";
        public static String numberOfPieces = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NumberOfPieces/1/0";
        public static String theoreticalMass = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TheoreticalMass/1/0";
        public static String actualMass = "0173-1#02-AAZ533#002";
        public static String drawing = "0173-1#02-AAQ318#002";

        public static class SemiFinishedProductSpecification {
            public static String id = "0173-1#01-AGO030#002";

            public static class Tube {
                public static String id = "0173-1#01-AGU746#002";
                public static String wallThickness = "0173-1#02-BAG269#006";
                public static String outerDiameter = "0173-1#02-ABG720#002";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class RectangularTube {
                public static String id = "0173-1#01-AGV504#005";
                public static String wallThickness = "0173-1#02-BAG269#006";
                public static String height = "0173-1#02-BAA020#011";
                public static String width = "0173-1#02-BAF016#007";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class RoundBar {
                public static String id = "0173-1#01-AGV490#005";
                public static String outerDiameter = "0173-1#02-ABG720#002";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class HexagonalBar {
                public static String id = "0173-1#01-AGV493#005";
                public static String widthAcrossFlats = "0173-1#02-AAA103#008";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class RectangularBar {
                public static String id = "0173-1#01-AGV492#005";
                public static String height = "0173-1#02-BAA020#011";
                public static String width = "0173-1#02-BAF016#007";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class SheetMetal {
                public static String id = "0173-1#01-AGU743#002";
                public static String thickness = "0173-1#02-AAV127#003";
                public static String width = "0173-1#02-BAF016#007";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }

            public static class Profile {
                public static String id = "0173-1#01-AGU744#002";
                public static String profileSpecification = "0173-1#02-AAZ528#005";
                public static String height = "0173-1#02-BAA020#011";
                public static String width = "0173-1#02-BAF016#007";
                public static String length = "0173-1#02-BAA018#008";
                public static String standardReference = "0173-1#02-AAZ523#004";
            }
        }
    }

    public static class MechanicalTests {
        public static String id = "0173-1#01-AKG420#020";

        public static class TensileTest {
            public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TensileTest/1/0";
            public static String yieldOrProofStrengthMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/YieldOrProofStrengthMean/1/0";
            public static String tensileStrengthMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TensileStrengthMean/1/0";
            public static String elongationAfterFractureMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/ElongationAfterFractureMean/1/0";
            public static String yieldOrProofStrengthIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/YieldOrProofStrengthInidivualValues/1/0";
            public static String tensileStrengthIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TensileStrengthIndividualValues/1/0";
            public static String elongationAfterFractureIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/ElongationAfterFractureIndividualValues/1/0";
            public static String testTemperature = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TestTemperature/1/0";
            public static String sampleShape = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/SampleShape/1/0";
            public static String locationOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/LocationOfSample/1/0";
            public static String directionOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/DirectionOfSample/1/0";
        }

        public static class HardnessTest {
            public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/HardnessTest/1/0";
            public static String hardnessTestingMethod = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/HardnessTestingMethod/1/0";
            public static String hardnessMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/HardnessMean/1/0";
            public static String hardnessIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/HardnessIndividualValues/1/0";
            public static String testTemperature = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TestTemperature/1/0";
            public static String locationOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/LocationOfSample/1/0";
            public static String directionOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/DirectionOfSample/1/0";
        }

        public static class NotchImpactTest {
            public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NotchImpactTest/1/0";
            public static String notchImpactStrengthMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NotchImpactStrengthMean/1/0";
            public static String notchImpactStrengthIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NotchImpactStrengthIndividualValues/1/0";
            public static String notchImpactWorkMean = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NotchImpactWorkMean/1/0";
            public static String notchImpactWorkIndividualValues = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/NotchImpactWorkIndividualValues/1/0";
            public static String sampleType = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/SampleType/1/0";
            public static String sampleWidth = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/SampleWidth/1/0";
            public static String testTemperature = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/TestTemperature/1/0";
            public static String locationOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/LocationOfSample/1/0";
            public static String directionOfSample = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/DirectionOfSample/1/0";
        }
    }

    public static class ChemicalAnalysis {
        public static String id = "0173-1#01-AKG373#020";
        public static String steelProductionProcess = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/SteelProductionProcess/1/0";
        public static String massFractionXY = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/MassFraction_XY/1/0";
    }

    public static class Validation {
        public static String id = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/Validation/1/0";
        public static String statementOfCompliance = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/StatementOfCompliance/1/0";
        public static String dateOfIssue = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/DateOfIssue/1/0";
        public static String originatorOfStatement = "https://adminshell.io/idta/InspectionDocumentsOfSteelProducts/OriginatorOfStatement/1/0";

        public static class CeMarking {
            public static String id = "0173-1#01-AHD206#001";
            public static String markingName = "https://adminshell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingName";
            public static String designationOfCertificateOrApproval = "0112/2///61987#ABH783#001";
            public static String issueDate = "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/IssueDate";
            public static String markingFile = "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingFile";
            public static String markingAdditionalText = "https://admin-shell.io/zvei/nameplate/2/0/Nameplate/Markings/Marking/MarkingAdditionalText";
        }
    }
}
