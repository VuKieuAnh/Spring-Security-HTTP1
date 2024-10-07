package com.example.securityHTTP.controller;

import com.example.securityHTTP.model.AppUser;
import com.example.securityHTTP.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserService appUserService;

    @GetMapping("/register")
    public String registerForm(ModelMap model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/dangky")
    public String register(@RequestBody AppUser user) {
//        mac dinh la role user
//        dien passsword dc encoder vao
        String newPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(newPassword);
        appUserService.save(user);
        return "redirect:/login";
    }
}
