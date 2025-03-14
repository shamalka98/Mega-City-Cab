package com.megacitycab.controller;

import com.megacitycab.model.Car;
import com.megacitycab.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CarManagementController {

    // GET request to show the car management page
    @GetMapping("/car-management")
    public String showCarManagement(Model model) {
        try {
            model.addAttribute("cars", FileUtil.getCars()); // Fetch and add cars to the model
        } catch (IOException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
        return "car-management"; // Resolves to /WEB-INF/car-management.jsp
    }

    @GetMapping("/driverManagement")
    public String redirectToDriverManagement() {
        return "redirect:/driver-management"; // Redirect to the driver management page
    }

    // POST request to add a new car
    @PostMapping("/car-management")
    public String addCar(
            @RequestParam String carId,
            @RequestParam String model,
            @RequestParam boolean availability) {
        try {
            Car car = new Car(carId, model, availability);
            FileUtil.saveCar(car); // Save the new car
        } catch (IOException e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
        return "redirect:/car-management"; // Redirect to avoid re-submission issues
    }
}
