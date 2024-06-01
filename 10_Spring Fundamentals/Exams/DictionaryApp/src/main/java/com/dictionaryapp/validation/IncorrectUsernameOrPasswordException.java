package com.dictionaryapp.validation;

public class IncorrectUsernameOrPasswordException extends RuntimeException {
    public IncorrectUsernameOrPasswordException() {
        super("Incorrect username or password");
    }

    public IncorrectUsernameOrPasswordException(String message) {
        super(message);
    }

    public IncorrectUsernameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
