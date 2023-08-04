package com.rusio.pavlovsky.spring.boot312.controller;

import com.rusio.pavlovsky.spring.boot312.model.User;
import com.rusio.pavlovsky.spring.boot312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/add-user")
    public String addUserPage (Model model) {
        model.addAttribute("user", new User() );
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser (@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update-user/{id}")
    public String updateUserPage (Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.get(id));
        return "update-user";
    }

    @PatchMapping("/update")
    public String updateUser (@ModelAttribute("user")User user) {
        userService.update(user);
        return "redirect:/";
    }

}
