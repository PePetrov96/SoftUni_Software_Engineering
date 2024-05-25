package com.plannerapp.controller;

import com.plannerapp.model.dto.TaskAddBindingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.service.TaskService;
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
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/add")
    public String displayAddTaskPage(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        return "task-add";
    }

    @PostMapping("/task/add")
    public String handleAddTask(@Valid TaskAddBindingModel taskAddBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "task-add";
        }

        this.taskService.addTask(taskAddBindingModel);

        return "redirect:/home";
    }

    @GetMapping("/task/assign/{id}")
    public String assignTaskToUser(@PathVariable Long id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        this.taskService.assignTask(id, currentUser.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/task/resign/{id}")
    public String resignTaskFromUser(@PathVariable Long id) {
        this.taskService.resignTask(id);

        return "redirect:/home";
    }

    @GetMapping("/task/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        this.taskService.resignTask(id);
        this.taskService.completeTask(id);
        return "redirect:/home";
    }
}
