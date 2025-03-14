package com.megacitycab.model;

public class User {
    private String regNo;
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String nicNumber;

    // No-Argument Constructor (Required for frameworks)
    public User() {}

    // Parameterized Constructor
    public User(String regNo, String username, String password, String name, String address, String phoneNumber, String nicNumber) {
        this.regNo = regNo;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.nicNumber = nicNumber;
    }

    // Getters and Setters
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNic() { return nicNumber; }
    public void setNicNumber(String nicNumber) { this.nicNumber = nicNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
