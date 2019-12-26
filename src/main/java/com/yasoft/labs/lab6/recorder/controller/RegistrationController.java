package com.yasoft.labs.lab6.recorder.controller;

import com.yasoft.labs.lab6.recorder.interfaces.services.UserService;
import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userService.create(user);
        return "redirect:/login";
    }
}
