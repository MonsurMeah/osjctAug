package com.example.osjcttwo;

public class Device {

    private String id;
    private String make;
    private String model;
    private String serialNumber;

    private String assetTag;

    public Device() {
        // Default constructor required for calls to DataSnapshot.getValue(Device.class)
    }

    public Device(String id, String make, String model, String serialNumber, String assetTag) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
        this.assetTag = assetTag;
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

    public String getAssetTag() {return assetTag;}
}