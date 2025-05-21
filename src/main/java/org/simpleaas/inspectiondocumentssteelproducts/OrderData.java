package org.simpleaas.inspectiondocumentssteelproducts;

import java.util.Optional;

public class OrderData {
    private final String typeOfInspectionDocument;
    private final String orderDate;
    private String manufacturerOrderNumber = null;
    private String purchaseOrderNumber = null;
    private String deliveryNoteNumber = null;

    public OrderData(String typeOfInspectionDocument, String orderDate) {
        this.typeOfInspectionDocument = typeOfInspectionDocument;
        this.orderDate = orderDate;
    }

    public String getTypeOfInspectionDocument() {
        return this.typeOfInspectionDocument;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public OrderData setManufacturerOrderNumber(String manufacturerOrderNumber) {
        this.manufacturerOrderNumber = manufacturerOrderNumber;
        return this;
    }

    public Optional<String> getManufacturerOrderNumber() {
        return Optional.ofNullable(this.manufacturerOrderNumber);
    }

    public OrderData setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        return this;
    }

    public Optional<String> getPurchaseOrderNumber() {
        return Optional.ofNullable(this.purchaseOrderNumber);
    }

    public OrderData setDeliveryNoteNumber(String deliveryNoteNumber) {
        this.deliveryNoteNumber = deliveryNoteNumber;
        return this;
    }

    public Optional<String> getDeliveryNoteNumber() {
        return Optional.ofNullable(this.deliveryNoteNumber);
    }
}
