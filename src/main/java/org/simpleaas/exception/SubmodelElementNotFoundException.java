package org.simpleaas.exception;

public class SubmodelElementNotFoundException extends Exception {
    public SubmodelElementNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public SubmodelElementNotFoundException(String message) {
        super(message);
    }

    public SubmodelElementNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SubmodelElementNotFoundException() {
        super();
    }
}
