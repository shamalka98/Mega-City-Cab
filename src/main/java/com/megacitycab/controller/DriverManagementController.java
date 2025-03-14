package com.megacitycab.controller;

import com.megacitycab.model.Driver;
import com.megacitycab.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.io.IOException;

@Controller
public class DriverManagementController {

    // GET request to show the driver management page
    @GetMapping("/driver-management")
    public String showDriverManagement(Model model) {
        try {
            model.addAttribute("drivers", FileUtil.getDrivers());  // Fetch and add drivers to the model
        } catch (IOException e) {
            e.printStackTrace();  // Log or handle the exception as needed
        }
        return "driver-management";  // This resolves to /WEB-INF/driver-management.jsp (check your view resolver config)
    }

    // POST request to add a new driver
    @PostMapping("/driver-management")
    public String addDriver(String driverId, String name, String license, String assignedVehicle) {
        try {
            Driver driver = new Driver(driverId, name, license, assignedVehicle);
            FileUtil.saveDriver(driver);  // Save the new driver
        } catch (IOException e) {
            e.printStackTrace();  // Log or handle the exception as needed
        }
        return "redirect:/driver-management";  // Ensure a redirect after POST to avoid circular view path
    }
}
