package com.example.osjcttwo;
public class Device {
    private String id;
    private String make;
    private String model;
    private String serialNumber;
    private String assetTag;
    private String siteName;  // Add siteName field

    // Constructor to initialize all six fields
    public Device(String id, String make, String model, String serialNumber, String assetTag, String siteName) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.serialNumber = serialNumber;
        this.assetTag = assetTag;
        this.siteName = siteName;  // Initialize siteName
    }

    // Getters and Setters for all fields (optional)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}