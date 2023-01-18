package com.example.task311.controller;

import com.example.task311.model.User;
import com.example.task311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String allUser(ModelMap model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String addUser(ModelMap model) {
        User person = new User();
        model.addAttribute("person", person);
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @RequestMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
