package org.simpleaas.helper;

public class BlobModel {
    private final String contentType;
    private final byte[] value;

    public BlobModel(String contentType, byte[] value) {
        this.contentType = contentType;
        this.value = value;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getValue() {
        return this.value;
    }
}
