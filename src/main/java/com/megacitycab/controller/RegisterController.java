package com.megacitycab.controller;

import com.megacitycab.model.User;
import com.megacitycab.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class RegisterController {

    // Show registration page (GET request)
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // Returns register.jsp
    }

    // Handle form submission (POST request)
    // Handle form submission (POST request)
    @PostMapping("/register")
    public String registerUser(
            @RequestParam("regNo") String regNo,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone,
            @RequestParam("nic") String nic,
            Model model) {

        // Validate form inputs
        if (regNo.isEmpty() || username.isEmpty() || password.isEmpty() ||
                name.isEmpty() || address.isEmpty() || phone.isEmpty() || nic.isEmpty()) {
            model.addAttribute("error", "All fields are required!");
            return "register";  // Stay on the registration page
        }

        // Create user object
        User user = new User(regNo, username, password, name, address, phone, nic);

        boolean isRegistered = FileUtil.registerUser(user);

        if (isRegistered) {
            return "redirect:/login";  // Redirect to login page after success
        } else {
            model.addAttribute("error", "Registration failed. Try again!");
            return "register";  // Stay on the registration page if an error occurs
        }
    }
}
