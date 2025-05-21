package org.simpleaas.inspectiondocumentssteelproducts;

public class InspectionDocumentsSteelProducts {
    public static String id = "";

    public static class Manufacturer {
        public static String id = "";
        public static String companyName = "";
        public static String street = "";
        public static String zipCode = "";
        public static String city = "";
        public static String nationalCode = "";
        public static String mailAddress = "";
    }

    public static class Customer {
        public static String id = "";
        public static String companyName = "";
        public static String customerRole = "";
        public static String street = "";
        public static String zipCode = "";
        public static String city = "";
        public static String nationalCode = "";
        public static String mailAddress = "";
    }

    public static class OrderData {
        public static String id = "";
        public static String typeOfInspectionDocument = "";
        public static String orderDate = "";
        public static String manufacturerOrderNumber = "";
        public static String purchaserOrderNumber = "";
        public static String deliveryNoteNumber = "";
    }

    public static class ProductData {
        public static String id = "";
        public static String manufacturerProductNumber = "";
        public static String customerProductNumber = "";
        public static String productDescription = "";
        public static String additionalProductRequirements = "";
        public static String batchNumber = "";
        public static String materialNumber = "";
        public static String materialShortName = "";
        public static String materialAdditionalInformation = "";
        public static String numberOfPieces = "";
        public static String theoreticalMass = "";
        public static String actualMass = "";
        public static String drawing = "";

        public static class SemiFinishedProductSpecification {
            public static String id = "";

            public static class Tube {
                public static String id = "";
                public static String wallThickness = "";
                public static String outerDiameter = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class RectangularTube {
                public static String id = "";
                public static String wallThickness = "";
                public static String height = "";
                public static String width = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class RoundBar {
                public static String id = "";
                public static String outerDiameter = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class HexagonalBar {
                public static String id = "";
                public static String widthAcrossFlats = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class RectangularBar {
                public static String id = "";
                public static String height = "";
                public static String width = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class SheetMetal {
                public static String id = "";
                public static String thickness = "";
                public static String width = "";
                public static String length = "";
                public static String standardReference = "";
            }

            public static class Profile {
                public static String id = "";
                public static String profileSpecification = "";
                public static String height = "";
                public static String width = "";
                public static String length = "";
                public static String standardReference = "";
            }
        }
    }

    public static class MechanicalTests {
        public static String id = "";

        public static class TensileTest {
            public static String id = "";
            public static String yieldOrProofStrengthMean = "";
            public static String tensileStrengthMean = "";
            public static String elongationAfterFractureMean = "";
            public static String yieldOrProofStrengthIndividualValues = "";
            public static String tensileStrengthIndividualValues = "";
            public static String elongationAfterFractureIndividualValues = "";
            public static String testTemperature = "";
            public static String sampleShape = "";
            public static String locationOfSample = "";
            public static String directionOfSample = "";
        }

        public static class HardnessTest {
            public static String id = "";
        }

        public static class NotchImpactTest {
            public static String id = "";
        }
    }

    public static class ChemicalAnalysis {
        public static String id = "";
    }

    public static class Validation {
        public static String id = "";
    }
}
