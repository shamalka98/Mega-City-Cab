package com.megacitycab.model;

public class Ride {
    private String pickupLocation;
    private String destination;
    private String time;
    private Driver driver;

    public Ride(String pickupLocation, String destination, String time, Driver driver) {
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.time = time;
        this.driver = driver;
    }

    public String getPickupLocation() { return pickupLocation; }
    public String getDestination() { return destination; }
    public String getTime() { return time; }
    public Driver getDriver() { return driver; }
}
