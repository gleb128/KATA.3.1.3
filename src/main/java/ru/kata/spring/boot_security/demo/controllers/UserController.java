package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceInterface;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/user")
    public String userInfo(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", user);
        return "User_Info";
    }
}
