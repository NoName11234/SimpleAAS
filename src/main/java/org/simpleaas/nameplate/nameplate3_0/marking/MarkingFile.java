package org.simpleaas.nameplate.nameplate3_0.marking;

/**
 * Represents a marking file of a marking in a submodel of type nameplate 3.0.
 */
public class MarkingFile {
    /**
     * The mime type of the associated file.
     * Needed for proper usage.
     */
    private String mimeType;
    /**
     * The path and the name of the file in an aasx file.
     */
    private String path;

    /**
     * @param mimeType the mime type of the associated file
     * @param path path and name of the file in an aasx file
     */
    public MarkingFile(String mimeType, String path) {
        this.mimeType = mimeType;
        this.path = path;
    }

    /**
     * Returns the path and name of the marking file in an aasx file.
     * @return marking file name and path
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the mime type of the marking file.
     * @return mime type
     */
    public String getMimeType() {
        return mimeType;
    }
}
