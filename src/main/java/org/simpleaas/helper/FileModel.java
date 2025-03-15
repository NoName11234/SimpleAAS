package org.simpleaas.helper;

import org.eclipse.digitaltwin.aas4j.v3.model.File;

public class FileModel {
    private final String value;
    private final String contentType;

    public FileModel(String value, String contentType) {
        this.value = value;
        this.contentType = contentType;
    }

    public static FileModel fromFileElement(File file) {
        return new FileModel(file.getValue(), file.getContentType());
    }

    public String getValue() {
        return this.value;
    }

    public String getContentType() {
        return  this.contentType;
    }
}
