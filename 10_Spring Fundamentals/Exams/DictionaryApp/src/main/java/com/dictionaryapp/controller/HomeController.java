package com.dictionaryapp.controller;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final WordService wordService;

    @Autowired
    public HomeController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/home")
    public String displayHomePage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/user/login";
        }

        List<Word> germanWords = wordService.getAllWordsForLanguage("GERMAN");
        model.addAttribute("germanWords", germanWords);

        List<Word> spanishWords = wordService.getAllWordsForLanguage("SPANISH");
        model.addAttribute("spanishWords", spanishWords);

        List<Word> frenchWords = wordService.getAllWordsForLanguage("FRENCH");
        model.addAttribute("frenchWords", frenchWords);

        List<Word> italianWords = wordService.getAllWordsForLanguage("ITALIAN");
        model.addAttribute("italianWords", italianWords);

        return "home";
    }

    @GetMapping("/")
    public String displayIndex(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home/remove-all")
    public String removeAllWords(HttpSession session) {
        if (session.getAttribute("user") != null) {
            this.wordService.removeAllWords();
            return "redirect:/home";
        }
        return "redirect:/";
    }
}

