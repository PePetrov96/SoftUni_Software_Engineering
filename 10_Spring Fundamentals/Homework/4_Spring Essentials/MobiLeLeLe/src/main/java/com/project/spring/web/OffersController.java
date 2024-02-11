package com.project.spring.web;

import com.project.spring.models.dto.OfferDTO;
import com.project.spring.models.entity.Brand;
import com.project.spring.models.entity.Offer;
import com.project.spring.models.entity.User;
import com.project.spring.models.entity.enums.Engine;
import com.project.spring.models.entity.enums.Transmission;
import com.project.spring.service.BrandService;
import com.project.spring.service.OfferService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/offers")
@Controller
public class OffersController {
    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    // SHOW OFFERS logic below

    @GetMapping("/all")
    public String showOffersPage(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        model.addAttribute("offers", this.offerService.postOffers());
        return "offers";
    }

    // ADD OFFER logic below

    @GetMapping("/add")
    public String showAddOfferPage(HttpSession session, Model model){
        if (session.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        populateFields(model);
        model.addAttribute("offer", new Offer());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute("offer") OfferDTO offerDTO, HttpSession session, Model model) {
        Offer offer = (Offer) session.getAttribute("offer");
        User user = (User) session.getAttribute("user");

        List<String> errors;

        if (offer == null) {
            errors = this.offerService.addOffer(offerDTO, user.getUsername());
        } else {
            errors = this.offerService.updateOffer(offer, offerDTO);
        }

        if (errors == null) {
            if (offer != null) {
                session.removeAttribute("offer");
            }
            return "redirect:/offers/all";
        } else {
            for (String error : errors) {
                model.addAttribute(error, true);
            }
            model.addAttribute("offer", offerDTO);
            populateFields(model);
            return "offer-add";
        }
    }

    // SHOW DETAILS logic below

    @GetMapping("/details/{id}")
    public String showOfferDetails(@PathVariable("id") Long id, Model model) {
        Offer offer = this.offerService.getOffer(id);
        model.addAttribute("offer", offer);
        return "details";
    }

    // UPDATED OFFER logic below

    @GetMapping("/update/{id}")
    public String updateOffer(@PathVariable Long id, Model model, HttpSession session) {
        Offer offer = this.offerService.getOffer(id);
        populateFields(model);
        model.addAttribute("offer", offer);
        session.setAttribute("offer", offer);
        return "offer-add";
    }

    // DELETE OFFER logic below

    @GetMapping("/delete/{id}")
    public String deleteOffer(@PathVariable Long id) {
        this.offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

    // Support functions below

    private void populateFields(Model model) {
        List<Brand> brands = this.brandService.postBrands();
        model.addAttribute("brands", brands);

        List<Engine> engines = List.of(Engine.values());
        model.addAttribute("engines", engines);

        List<Transmission> transmissions = List.of(Transmission.values());
        model.addAttribute("transmissions", transmissions);
    }
}
