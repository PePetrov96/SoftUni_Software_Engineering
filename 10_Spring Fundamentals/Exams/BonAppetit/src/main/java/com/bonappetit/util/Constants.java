package com.bonappetit.util;

import lombok.Getter;

@Getter
public class Constants {
    public static final String LOGIN_URL = "/user/login";
    public static final String LOGIN_HTML = "login";

    public static final String REGISTER_URL = "/user/register";
    public static final String REGISTER_HTML = "register";

    public static final String LOGOUT_URL = "/user/logout";

    public static final String HOME_URL = "/home";
    public static final String HOME_HTML = "home";

    public static final String INDEX_URL = "/";
    public static final String INDEX_HTML = "index";

    public static final String RECIPE_ADD_URL = "/recipe/add";
    public static final String RECIPE_ADD_HTML = "recipe-add";

    public static final String RECIPE_FAVORITE_URL = "/recipe/favorite/{id}";
}
