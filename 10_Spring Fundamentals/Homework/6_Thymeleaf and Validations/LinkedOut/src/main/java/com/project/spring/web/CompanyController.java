package com.project.spring.web;

import com.project.spring.models.dto.CompanyBindingModel;
import com.project.spring.models.entity.Company;
import com.project.spring.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String showAddCompaniesPage(Model model) {
        if (!model.containsAttribute("bindingModel")) {
            model.addAttribute("bindingModel", new CompanyBindingModel());
        }
        return "company-add";
    }

    @PostMapping("/add")
    public String saveCompany(@Valid @ModelAttribute("bindingModel") CompanyBindingModel companyBindingModel,
                              BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("bindingModel", companyBindingModel);
            return "redirect:/companies/add";
        }

        this.companyService.save(companyBindingModel);
        return "redirect:/companies/all";
    }

    @GetMapping("/all")
    public String showAllCompaniesPage(Model model) {
        model.addAttribute("companies", this.companyService.getAllCompanies());
        return "company-all";
    }

    @GetMapping("/details/{id}")
    public String showDetailsCompany(@PathVariable("id") Long id, Model model) {
        Company company = this.companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id, Model model) {
        this.companyService.deleteCompanyById(id);
        return "redirect:/companies/all";
    }
}
