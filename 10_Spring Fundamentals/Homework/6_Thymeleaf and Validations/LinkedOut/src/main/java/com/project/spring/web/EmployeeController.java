package com.project.spring.web;

import com.project.spring.models.dto.EmployeeBindingModel;
import com.project.spring.models.entity.Employee;
import com.project.spring.service.CompanyService;
import com.project.spring.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/add")
    public String showAddEmployeePage(Model model) {
        model.addAttribute("companies", this.companyService.getAllCompanies());

        if (!model.containsAttribute("bindingModel")) {
            model.addAttribute("bindingModel", new EmployeeBindingModel());
        }
        return "employee-add";
    }

    @PostMapping("/add")
    public String saveEmployee(@Valid @ModelAttribute("bindingModel") EmployeeBindingModel employeeBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("bindingModel", employeeBindingModel);
            return "redirect:/employees/add";
        }

        this.employeeService.save(employeeBindingModel);
        return "redirect:/employees/all";
    }

    @GetMapping("/all")
    public String allEmployees(Model model) {
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employee-all";
    }

    @GetMapping("/details/{id}")
    public String showDetailsEmployee(@PathVariable("id") Long id, Model model) {
        Employee employee = this.employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, Model model) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees/all";
    }
}
