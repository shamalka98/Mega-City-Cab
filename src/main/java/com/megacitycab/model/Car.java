package com.megacitycab.model;

public class Car {
    private String carId;
    private String model;
    private boolean availability;

    public Car(String carId, String model, boolean availability) {
        this.carId = carId;
        this.model = model;
        this.availability = availability;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
