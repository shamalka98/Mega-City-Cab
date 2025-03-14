package com.megacitycab.controller;

import com.megacitycab.util.FileUtil;
import com.megacitycab.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    // Show the login page (GET request)
    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        // If user is already logged in, redirect to the dashboard
        if (session.getAttribute("username") != null) {
            return "redirect:/dashboard";
        }
        return "login";  // Resolves to /WEB-INF/login.jsp
    }

    // Handle user login (POST request)
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session, Model model) {

            boolean isValidUser = FileUtil.validateUser(username, password);
            boolean isAdmin = FileUtil.isAdmin(username, password);

            if (isValidUser) {
                session.setAttribute("username", username);
                session.setAttribute("role", isAdmin ? "admin" : "user");// Store user in session
                return "redirect:/ride-booking";  // Redirect to dashboard after login
            } else if (isAdmin) {
                session.setAttribute("username", username);
                session.setAttribute("role", "admin");// Store user in session
                return "redirect:/car-management";
            } else {
                model.addAttribute("error", "Invalid username or password.");
                return "login";  // Stay on login page with error message
            }
    }

    // Handle user logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Destroy session
        return "redirect:/login";  // Redirect to login page
    }
}
