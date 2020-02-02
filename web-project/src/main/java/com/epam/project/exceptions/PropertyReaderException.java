package com.epam.project.exceptions;

public class PropertyReaderException extends Exception {
    public PropertyReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertyReaderException(String message) {
        super(message);
    }

    public PropertyReaderException() {
    }

}
