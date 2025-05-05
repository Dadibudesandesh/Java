package com.librarySystem.controller;

import com.librarySystem.entity.Student;
import com.librarySystem.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String loginPage(@RequestParam String email,
                            @RequestParam String password,
                            Model model,
                            HttpSession session) {

        Student student = loginService.login(email, password);

        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            session.setAttribute("loggedInUser", null);
            session.setAttribute("role", "admin");
            return "redirect:/admin/home";
        }

        if (student != null) {
            session.setAttribute("loggedInUser", student);
            session.setAttribute("role", "student");
            return "redirect:/student/home";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/current-user")
    public String currentUser(HttpSession session, Model model) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            model.addAttribute("message", "No user is logged in.");
            return "error";
        }
        model.addAttribute("user", loggedInUser);
        return "userDetails";
    }

    @PostMapping("/logout")
    public String logoutPage(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
