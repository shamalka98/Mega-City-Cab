package com.megacitycab.model;

public class Driver {
    private String driverId;
    private String name;
    private String license;
    private String assignedVehicle;
    private boolean isBooked;

    public Driver() {
    }

    public Driver(String driverId, String name, String license, String assignedVehicle, boolean isBooked) {
        this.driverId = driverId;
        this.name = name;
        this.license = license;
        this.assignedVehicle = assignedVehicle;
        this.isBooked = false;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }


    public void setLicense(String license) {
        this.license = license;
    }

    public String getAssignedVehicle() {
        return assignedVehicle;
    }

    public void setAssignedVehicle(String assignedVehicle) {
        this.assignedVehicle = assignedVehicle;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        this.isBooked = booked;
    }
}
