package com.plannerapp.vallidation;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException() {
        super("Incorrect username or password.");
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
