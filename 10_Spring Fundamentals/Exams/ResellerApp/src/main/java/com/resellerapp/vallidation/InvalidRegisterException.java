package com.resellerapp.vallidation;

public class InvalidRegisterException extends RuntimeException {
    public InvalidRegisterException() {
        super();
    }

    public InvalidRegisterException(String message) {
        super(message);
    }

    public InvalidRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
