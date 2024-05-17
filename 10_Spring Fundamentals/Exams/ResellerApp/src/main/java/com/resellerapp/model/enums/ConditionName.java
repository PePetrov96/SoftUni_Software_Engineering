package com.resellerapp.model.enums;

import lombok.Getter;

@Getter
public enum ConditionName {
    EXCELLENT("In perfect condition"),
    GOOD("Some signs of wear and tear or minor defects"),
    ACCEPTABLE("The item is fairly worn but continues to function properly");

    private final String description;

    ConditionName(String description){
        this.description = description;
    }

}
