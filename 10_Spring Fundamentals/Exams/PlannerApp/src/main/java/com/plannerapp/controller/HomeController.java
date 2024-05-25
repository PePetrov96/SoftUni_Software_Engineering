package com.plannerapp.controller;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public HomeController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/home")
    public String displayHomePage(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        User sessionUser = (User) session.getAttribute("user");
        User user = userService.getUser(sessionUser.getUsername());

        model.addAttribute("user", user);

        List<Task> tasks = this.taskService.getAllAvailableTasks();
        model.addAttribute("availableTasks", tasks);

        return "home";
    }

    @Transactional
    @GetMapping("/")
    public String redirectLoggedUserToHome(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }

        return "index";
    }
}
