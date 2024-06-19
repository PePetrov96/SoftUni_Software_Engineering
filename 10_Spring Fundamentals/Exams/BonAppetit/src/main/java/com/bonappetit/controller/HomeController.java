package com.bonappetit.controller;

import com.bonappetit.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import static com.bonappetit.util.Constants.HOME_URL;
import static com.bonappetit.util.Constants.RECIPE_FAVORITE_URL;

@Controller
public class HomeController {
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(HOME_URL)
    public String displayHomePage(HttpSession httpSession, Model model) {
        return this.homeService.displayHomePage(httpSession, model);
    }

    @GetMapping(RECIPE_FAVORITE_URL)
    public String favoriteRecipeHandler(@PathVariable Long id, HttpSession httpSession, Model model) {
        return this.homeService.handleFavoriteRecipe(id, httpSession, model);
    }
}
