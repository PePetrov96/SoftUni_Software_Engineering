package com.bonappetit.model.entity.enums;

import lombok.Getter;

@Getter
public enum CategoryName {
    MAIN_DISH ("Heart of the meal, substantial and satisfying; main dish delights taste buds."),
    DESSERT("Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy."),
    COCKTAIL("Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.");

    private final String description;

    CategoryName(String description) {
        this.description = description;
    }
}
