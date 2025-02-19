package com.megacitycab.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.megacitycab.model.Car;
import com.megacitycab.model.Driver;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String CAR_FILE = "data/cars.json";
    private static final String DRIVER_FILE = "data/drivers.json";

    private static Gson gson = new Gson();

    public static List<Car> getCars() throws IOException {
        return readFile(CAR_FILE, new TypeToken<List<Car>>(){}.getType());
    }

    public static void saveCar(Car car) throws IOException {
        List<Car> cars = getCars();
        cars.add(car);
        writeFile(CAR_FILE, cars);
    }

    public static List<Driver> getDrivers() throws IOException {
        return readFile(DRIVER_FILE, new TypeToken<List<Driver>>(){}.getType());
    }

    public static void saveDriver(Driver driver) throws IOException {
        List<Driver> drivers = getDrivers();
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
}
