package com.resellerapp.controller;

import com.resellerapp.model.dto.OfferAddDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class OfferController {
    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offer/add")
    public String addOffer(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        model.addAttribute("offerAddDTO", new OfferAddDTO());
        return "offer-add";
    }

    @PostMapping("/offer/add")
    public String addOffer(@Valid OfferAddDTO offerAddDTO,
                           BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "offer-add";
        }

        this.offerService.addOffer(offerAddDTO, (User) session.getAttribute("user"));

        return "redirect:/home";
    }

    @GetMapping("/offer/buy/{id}")
    private String buyOffer(@PathVariable Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        this.offerService.buyOffer(id, currentUser.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/offer/remove/{id}")
    public String removeOffer(@PathVariable Long id) {
        this.offerService.deleteOffer(id);
        return "redirect:/home";
    }
}
