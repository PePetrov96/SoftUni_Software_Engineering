package com.project.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandsController {
    @GetMapping("/brands/all")
    public String login() {
        return "brands";
    }
}
