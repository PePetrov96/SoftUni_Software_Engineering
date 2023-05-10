package com.example.accountsystem.enums;

public enum AgeRestriction {
    MINOR(0),
    TEEN(1),
    ADULT(2);

    private final int value;

    AgeRestriction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AgeRestriction fromValue(int value) {
        for (AgeRestriction level : AgeRestriction.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value for Age Restriction: " + value);
    }
}