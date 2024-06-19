package com.bonappetit.service.impl;

import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.model.entity.enums.CategoryName;
import com.bonappetit.repo.CategoryRepository;
import com.bonappetit.repo.RecipeRepository;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.HomeService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import java.util.Set;

import static com.bonappetit.util.Constants.*;

@Service
public class HomeServiceImpl implements HomeService {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public HomeServiceImpl(CategoryRepository categoryRepository,
                           RecipeRepository recipeRepository,
                           UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String displayHomePage(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:" + INDEX_URL;
        } else {
            setAllRecipesView(model, getUserBySession(httpSession));
            return HOME_HTML;
        }
    }

    @Override
    public String handleFavoriteRecipe(Long id, HttpSession httpSession, Model model) {
        Recipe recipe = this.recipeRepository.getById(id);
        User user = getUserBySession(httpSession);

        user.getFavouriteRecipes().add(recipe);
        this.userRepository.save(user);

        return "redirect:" + HOME_URL;
    }

    private void setAllRecipesView(Model model, User user) {
        Set<Recipe> desertsList = this.recipeRepository.findAllByCategory_CategoryName(CategoryName.DESSERT);
        model.addAttribute("desertsList", desertsList);

        Set<Recipe> cocktailsList = this.recipeRepository.findAllByCategory_CategoryName(CategoryName.COCKTAIL);
        model.addAttribute("cocktailsList", cocktailsList);

        Set<Recipe> mainDishesList = this.recipeRepository.findAllByCategory_CategoryName(CategoryName.MAIN_DISH);
        model.addAttribute("mainDishesList", mainDishesList);

        Set<Recipe> favouritesList = this.recipeRepository.findAllFavouritesByUser(user);
        model.addAttribute("favouritesList", favouritesList);
    }

    private User getUserBySession(HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        return this.userRepository.findByUsername(sessionUser.getUsername());
    }
}
