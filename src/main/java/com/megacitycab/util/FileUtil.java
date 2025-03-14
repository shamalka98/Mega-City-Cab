package com.megacitycab.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.megacitycab.model.Car;
import com.megacitycab.model.Driver;
import com.megacitycab.model.Ride;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

public class FileUtil {

    private static final String CAR_FILE = "data/cars.json";
    private static final String DRIVER_FILE = "data/drivers.json";
    private static final String BOOKED_RIDES_FILE = "src/main/resources/data/booked_rides.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static Gson gson = new Gson();

    public static List<Car> getCars() throws IOException {
        return readFile(CAR_FILE, new TypeToken<List<Car>>(){}.getType());
    }

    public static void saveCar(Car car) throws IOException {
        List<Car> cars = getCars();
        cars.add(car);
        writeFile(CAR_FILE, cars);
    }

    public static void saveDriver(Driver driver) throws IOException {
        List<Driver> drivers = getDrivers();
        if (driver.getAssignedVehicle() == null) {
            driver.setAssignedVehicle("");
        }
        if (driver.getLicense() == null) {
            driver.setLicense("");
        }
        if (driver.getName() == null) {
            driver.setName("");
        }
        if (driver.getDriverId() == null) {
            driver.setDriverId("");
        }
        if (driver.getBooked() == null) {
            driver.setBooked(false);
        }

        drivers.add(driver);
        writeFile(DRIVER_FILE, drivers);
    }

    private static <T> List<T> readFile(String fileName, Type type) throws IOException {
        File file = new File(fileName);

        // If the file doesn't exist, create it with an empty array (JSON)
        if (!file.exists()) {
            file.getParentFile().mkdirs();  // Create the parent directories if they don't exist
            file.createNewFile();           // Create the file itself
            writeFile(fileName, new ArrayList<>()); // Write an empty list to the file
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(reader, type);  // Deserialize directly into List<T>
        }
    }

    private static <T> void writeFile(String fileName, List<T> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            gson.toJson(data, writer);
        }
    }

    private static final String RIDE_FILE = "data/rides.json";

    public static List<Ride> getRides() throws IOException {
        return readFile(RIDE_FILE, new TypeToken<List<Ride>>(){}.getType());
    }

    public static void saveRide(Ride ride) throws IOException {
        List<Ride> rides = getRides();
        rides.add(ride);
        writeFile(RIDE_FILE, rides);
    }

    // Ensure the file exists, create if not
    private static void ensureFileExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();  // Create parent directories if necessary
            file.createNewFile();
            objectMapper.writeValue(file, new ArrayList<>());  // Initialize with empty list
        }
    }

    // Get all drivers
    public static List<Driver> getDrivers() throws IOException {
        return readFile(DRIVER_FILE, new TypeToken<List<Driver>>(){}.getType());
    }

    // Save drivers
    public static void saveDrivers(List<Driver> drivers) throws IOException {
        ensureFileExists(DRIVER_FILE);
        objectMapper.writeValue(new File(DRIVER_FILE), drivers);
    }

    // Get booked drivers
    public static List<Driver> getBookedDrivers() throws IOException {
        ensureFileExists(DRIVER_FILE); // Ensure the drivers file exists

        List<Driver> allDrivers = objectMapper.readValue(new File(DRIVER_FILE), new TypeReference<List<Driver>>() {});

        // Filter drivers who are not booked
        return allDrivers.stream()
                .filter(driver -> !driver.getBooked()) // Only return drivers who are NOT booked
                .collect(Collectors.toList());
    }


    // Save booked drivers
    public static void saveBookedDriver(Driver driver) throws IOException {
        ensureFileExists(BOOKED_RIDES_FILE);
        List<Driver> bookedDrivers = getBookedDrivers();
        bookedDrivers.add(driver);
        objectMapper.writeValue(new File(BOOKED_RIDES_FILE), bookedDrivers);
    }

    // Update logic in FileUtil.java
    public static void updateDriver(Driver updatedDriver) throws IOException {
        List<Driver> drivers = getDrivers();
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getDriverId().equals(updatedDriver.getDriverId())) {
                // If isBooked is null, set it to false
                if (updatedDriver.getBooked() == null) {
                    updatedDriver.setBooked(false);  // Set default value if it's null
                }

                // Set booked to true
                updatedDriver.setBooked(true);

                // Replace the old driver object in the list
                drivers.set(i, updatedDriver);
                break; // Stop searching after updating
            }
        }


        // Save only the modified list
        saveDrivers(drivers);
    }

}
