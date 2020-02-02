package com.epam.project.exceptions;

public class ConnectionFactoryException extends Exception {
    public ConnectionFactoryException(Throwable cause) {
        super(cause);
    }

    public ConnectionFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionFactoryException(String message) {
        super(message);
    }

    public ConnectionFactoryException() {}
}
