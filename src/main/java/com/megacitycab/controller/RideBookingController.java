package com.megacitycab.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.megacitycab.model.Driver;
import com.megacitycab.model.Ride;
import com.megacitycab.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static jdk.jfr.FlightRecorder.isAvailable;

@Controller
public class RideBookingController {

    // GET request to show the ride booking page
    @GetMapping("/ride-booking")
    public String showRideBookingPage(Model model) {
        try {
            // Get available drivers
            List<Driver> availableDrivers = FileUtil.getDrivers().stream()
                    .filter(driver -> !driver.getBooked())
                    .collect(Collectors.toList());

            // Get booked rides
            List<Ride> rides = FileUtil.getRides();

            model.addAttribute("rides", rides);
        } catch (IOException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
        return "ride-booking"; // Resolves to ride-booking.jsp
    }

    // POST request to book a ride
    @PostMapping("/ride-booking")
    public String bookRide(@RequestParam String pickup,
                           @RequestParam String destination,
                           @RequestParam String time,
                           Model model, RedirectAttributes redirectAttributes) {
        try {

            List<Driver> drivers = FileUtil.getDrivers();

            boolean isAvailable = false;
            Driver availableDriver = null;  // Declare a variable to hold the available driver

            // Loop through the drivers to check availability
            for (Driver driver : drivers) {
                if (!driver.getBooked()) {
                    availableDriver = driver;  // Store the first available driver
                    isAvailable = true;  // Set availability to true
                    break;  // Exit the loop after finding the first available driver
                }
            }

            if (isAvailable) {
                availableDriver.setBooked(true);  // Mark driver as booked

                // Create and save the ride
                Ride ride = new Ride(pickup, destination, time, availableDriver);
                FileUtil.saveRide(ride);

                // Save updated driver status
                FileUtil.updateDriver(availableDriver);  // Update only the assigned driver
            } else {
                System.out.println("No available drivers at the moment.");
            }

        } catch (IOException e) {
            System.err.println("Error booking ride: " + e.getMessage());
        }

        // Calculate the total amount (for now, it's hardcoded)
        double totalAmount = 100.00;  // Replace with your logic to calculate the amount

        // Add the total amount to RedirectAttributes to pass it to the redirected page
        redirectAttributes.addFlashAttribute("totalAmount", totalAmount);

        // Redirect to the bill page
        return "redirect:/bill"; // Redirect to the bill page where the total amount will be displayed
    }

    // GET request to display the bill page with the total amount
    @GetMapping("/bill")
    public String showBillPage(Model model) {
        // The totalAmount will be available in the model as a flash attribute
        // because it was passed using RedirectAttributes.
        return "bill"; // Resolves to bill.jsp
    }



}
