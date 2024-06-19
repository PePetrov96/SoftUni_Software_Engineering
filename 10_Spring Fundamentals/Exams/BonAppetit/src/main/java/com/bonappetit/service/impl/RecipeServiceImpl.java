package com.bonappetit.service.impl;

import com.bonappetit.model.dto.RecipeAddDTO;
import com.bonappetit.model.entity.Category;
import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.model.entity.enums.CategoryName;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.bonappetit.util.Constants.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository,
                             CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public String showRecipeAddPage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:" + INDEX_URL;
        }
        model.addAttribute("recipeAddDTO", new RecipeAddDTO());
        return RECIPE_ADD_HTML;
    }

    @Override
    public String handleAddRecipe(RecipeAddDTO recipeAddDTO, BindingResult bindingResult, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:" + INDEX_HTML;
        }

        if (bindingResult.hasErrors()) {
            return RECIPE_ADD_HTML;
        }

        saveRecipeToDatabase(recipeAddDTO, session);
        return "redirect:" + HOME_URL;
    }

    private void saveRecipeToDatabase(RecipeAddDTO recipeAddDTO, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = this.userRepository.findByUsername(sessionUser.getUsername());

        Category category = this.categoryRepository
                .findByCategoryName(CategoryName
                        .valueOf(recipeAddDTO.getCategory()));

        Recipe recipe = modelMapper.map(recipeAddDTO, Recipe.class);
        recipe.setAddedBy(user);
        recipe.setCategory(category);

        this.recipeRepository.save(recipe);
    }
}

