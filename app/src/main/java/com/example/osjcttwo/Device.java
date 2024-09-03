package com.example.osjcttwo;

public class Device {

    private String id;
    private String make;
    private String model;
    private String serialNumber;

    public Device() {
        // Default constructor required for calls to DataSnapshot.getValue(Device.class)
    }

    public Device(String id, String make, String model, String serialNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}