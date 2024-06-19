package com.bonappetit.service;

import com.bonappetit.model.dto.RecipeAddDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

public interface RecipeService {
    String showRecipeAddPage(Model model, HttpSession session);
    String handleAddRecipe(RecipeAddDTO recipeAddDTO, BindingResult bindingResult, Model model, HttpSession session);
}
