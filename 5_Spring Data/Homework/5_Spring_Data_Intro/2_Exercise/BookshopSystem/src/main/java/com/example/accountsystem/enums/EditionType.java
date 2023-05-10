package com.example.accountsystem.enums;

public enum EditionType {
    NORMAL(0),
    PROMO(1),
    GOLD(2);

    private final int value;

    EditionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EditionType fromValue(int value) {
        for (EditionType level : EditionType.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid value for Edition Type: " + value);
    }
}