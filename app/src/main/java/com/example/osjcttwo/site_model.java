package com.example.osjcttwo;

public class site_model {

    //Attributes
    private String siteName;
    private int siteImage;

    //Constructor (ALT + Insert)
    public site_model(String siteName, int siteImage) {
        this.siteName = siteName;
        this.siteImage = siteImage;
    }

    //Getters & Setters


    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public int getSiteImage() {
        return siteImage;
    }

    public void setSiteImage(int siteImage) {
        this.siteImage = siteImage;
    }
}
