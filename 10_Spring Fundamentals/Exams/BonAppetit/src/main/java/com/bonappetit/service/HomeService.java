package com.bonappetit.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface HomeService {
    String displayHomePage (HttpSession httpSession, Model model);
    String handleFavoriteRecipe(Long id, HttpSession httpSession, Model model);
}
