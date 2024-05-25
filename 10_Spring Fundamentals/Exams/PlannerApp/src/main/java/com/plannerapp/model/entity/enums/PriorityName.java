package com.plannerapp.model.entity.enums;

import lombok.Getter;

@Getter
public enum PriorityName {
    URGENT("An urgent problem that blocks the system use until the issue is resolved."),
    IMPORTANT("A core functionality that your product is explicitly supposed to perform is compromised."),
    LOW("Should be fixed if time permits but can be postponed.");

    private final String description;

    PriorityName(String description) {
        this.description = description;
    }

}
