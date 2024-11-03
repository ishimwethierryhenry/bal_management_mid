//UserController.java

package com.bal.bal_management_system.controller;

import com.bal.bal_management_system.model.UserEntity;
import com.bal.bal_management_system.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Landing Page
    @GetMapping("/")
    public String showLandingPage(Model model) {
        return "landing";
    }

    // About BAL Page
    @GetMapping("/aboutBal")
    public String showAboutBalPage() {
        return "aboutBal";
    }

    // Matches Page
    @GetMapping("/matches")
    public String showMatchesPage() {
        return "matches";
    }

    // Standings Page
    @GetMapping("/standings")
    public String showStandingsPage() {
        return "standings";
    }

    // Stats Page
    @GetMapping("/stats")
    public String showStatsPage() {
        return "stats";
    }

    // Players Page
    @GetMapping("/players")
    public String showPlayersPage() {
        return "players";
    }

    // Gallery Page
    @GetMapping("/gallery")
    public String showGalleryPage() {
        return "gallery";
    }

    // Registration Form
    @GetMapping("/register")
    public String showRegForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    // Registration Process
    @PostMapping("/register")
    public String registerUser (@ModelAttribute("user") UserEntity user,
                                @RequestParam("profilePicture") MultipartFile file,
                                Model model) {
        // Check if a file has been uploaded
        if (!file.isEmpty()) {
            if (file.getSize() > 1024 * 1024 * 5) { // 5MB limit
                model.addAttribute("error", "File size exceeds the maximum limit of 5MB");
                return "register";
            }
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
                model.addAttribute("error", "Only JPEG and PNG files are allowed");
                return "register";
            }

            // File upload logic
            try {
                String uploadDir = "C:/Users/USER/Documents/Uploads/";
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Avoid filename collisions
                String filePath = uploadDir + fileName;
                File destFile = new File(filePath);
                file.transferTo(destFile);

                // Set the relative file path in the user entity
                user.setProfilePicturePath("/uploads/" + fileName); // Adjust path for serving from web

            } catch (IOException e) {
                model.addAttribute("error", "File upload failed: " + e.getMessage());
                return "register";
            }
        }

        // Other validation and saving logic
        userService.save(user);
        model.addAttribute("message", "Registration successful");
        return "redirect:/login";
    }

    // Login Form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "login";
    }

    // Login User with Role-Based Redirection
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserEntity user,
                            HttpSession session, Model model) {
        if (userService.isValidUser(user.getUsername(), user.getPassword())) {
            // Fetch the complete user object from database
            Optional<UserEntity> currentUser = userService.findByUsername(user.getUsername());

            if (currentUser.isPresent()) {
                UserEntity fullUser = currentUser.get();
                String role = String.valueOf(userService.getRoleByUsername(user.getUsername()));

                // Store full user object in session
                session.setAttribute("loggedInUser", fullUser);
                session.setAttribute("username", fullUser.getUsername());
                session.setAttribute("role", role);

                // Print debug information
                System.out.println("Login - Username: " + fullUser.getUsername());
                System.out.println("Login - First Name: " + fullUser.getFirstName());
                System.out.println("Login - Last Name: " + fullUser.getLastName());

                if ("ADMIN".equalsIgnoreCase(role)) {
//                    return "admin_dashboard";
                    return "redirect:/admin/users/dashboard"; // Redirect to admin dashboard

                } else if ("USER".equalsIgnoreCase(role)) {
                    return "user_dashboard";
                }
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    // Home Page
    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        model.addAttribute("message", "Welcome to the Basketball Africa League!");
        String username = (String ) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "home";
    }

    // Logout User
    // Modify your logout method
    @GetMapping("/logout")
    public String logoutUser(HttpSession session, HttpServletResponse response) {
        session.invalidate();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        return "redirect:/login?logout";
    }
    @Controller
    public class DashboardController {

        @GetMapping("/user_dashboard")
        public String showUserDashboard(HttpSession session, Model model) {
            // Get the complete user object from session
            UserEntity loggedInUser = (UserEntity) session.getAttribute("loggedInUser");

            if (loggedInUser == null) {
                // If no user in session, try to retrieve from database using username
                String username = (String) session.getAttribute("username");
                if (username != null) {
                    Optional<UserEntity> userOpt = userService.findByUsername(username);
                    if (userOpt.isPresent()) {
                        loggedInUser = userOpt.get();
                        session.setAttribute("loggedInUser", loggedInUser);
                    } else {
                        return "redirect:/login";
                    }
                } else {
                    return "redirect:/login";
                }
            }

            // Debug prints
            System.out.println("Dashboard - Username: " + loggedInUser.getUsername());
            System.out.println("Dashboard - First Name: " + loggedInUser.getFirstName());
            System.out.println("Dashboard - Last Name: " + loggedInUser.getLastName());
            System.out.println("Dashboard - Last Name: " + loggedInUser.getRole());


            // Add user information to model
            model.addAttribute("user", loggedInUser);
            model.addAttribute("fullName",
                    loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
            model.addAttribute("profilePicture",
                    loggedInUser.getProfilePicturePath() != null ?
                            loggedInUser.getProfilePicturePath() : "/api/placeholder/80/80");

            return "user_dashboard";
        }

    }
    @GetMapping("/debug/user-info")
    @ResponseBody
    public Map<String, String> debugUserInfo(HttpSession session) {
        Map<String, String> debug = new HashMap<>();
        debug.put("username", (String) session.getAttribute("username"));
        debug.put("firstName", (String) session.getAttribute("firstName"));
        debug.put("lastName", (String) session.getAttribute("lastName"));
        debug.put("profilePicture", (String) session.getAttribute("profilePicture"));
        return debug;
    }

    // Add these methods to your UserController class
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}