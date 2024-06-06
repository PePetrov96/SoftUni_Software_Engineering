package com.project.spring.web;

import com.project.spring.service.BrandService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandsController {
    private final BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String brands(HttpSession session, Model model) {
        model.addAttribute("brands", this.brandService.postBrands());
        return "brands";
    }
}