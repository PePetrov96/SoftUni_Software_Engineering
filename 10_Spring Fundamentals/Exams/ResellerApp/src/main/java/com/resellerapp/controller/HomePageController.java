package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferViewDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomePageController {
    private final UserService userService;
    private final OfferService offerService;

    @Autowired
    public HomePageController(UserService userService, OfferService offerService, HttpSession session) {
        this.userService = userService;
        this.offerService = offerService;
    }

    @Transactional
    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        User sessionUser = (User) session.getAttribute("user");
        User user = userService.getUserWithInitializedCollections(sessionUser.getUsername());

        model.addAttribute("user", user);

        List<OfferViewDTO> allOffers = this.offerService.returnAllOffersForUser(user.getId());
        model.addAttribute("allOffers", allOffers);

        return "home";
    }
}
