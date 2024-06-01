package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WordController {
    private final WordService wordService;
    private final UserService userService;

    @Autowired
    public WordController(WordService wordService, UserService userService) {
        this.wordService = wordService;
        this.userService = userService;
    }

    @GetMapping("/word/add")
    public String displayAddWordForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/user/login";
        }
        model.addAttribute("wordBindingModel", new WordBindingModel());
        return "word-add";
    }

    @PostMapping("/word/add")
    public String processAddWordForm(@Valid WordBindingModel wordBindingModel,
                                     BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "word-add";
        }

        User user = (User) session.getAttribute("user");
        this.wordService.addWord(wordBindingModel, user.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/word/remove/{id}")
    public String processRemoveWord(@PathVariable Long id) {
        this.wordService.removeWord(id);
        return "redirect:/home";
    }
}
