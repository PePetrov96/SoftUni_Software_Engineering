package com.bonappetit.controller;

import com.bonappetit.model.dto.RecipeAddDTO;
import com.bonappetit.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.bonappetit.util.Constants.RECIPE_ADD_URL;

@Controller
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(RECIPE_ADD_URL)
    public String showRecipeAddPage(Model model, HttpSession session) {
        return recipeService.showRecipeAddPage(model, session);
    }

    @PostMapping(RECIPE_ADD_URL)
    public String addRecipeHandler(@Valid @ModelAttribute("recipeAddDTO") RecipeAddDTO recipeAddDTO,
                                   BindingResult bindingResult, Model model, HttpSession session) {
        return recipeService.handleAddRecipe(recipeAddDTO, bindingResult,model, session);
    }

}
