package com.github.enriqueabsurdum.models;

public class Mobile {

    private int id;
    private String imei;
    private String brand;
    private String model;
    private String storageCapacity;
    private String frontCamera;
    private String backCamera;
    private String internalStorage;
    private String operatingSystem;
    private boolean antivirus;
    private String mobileDate;
    private String mobileNumber;
    private boolean mobileStatus;

    public Mobile() {
    }

    public Mobile(int id, boolean mobileStatus) {
        this.id = id;
        this.mobileStatus = mobileStatus;
    }

    public Mobile(int id, String imei, String brand, String model, String storageCapacity, String frontCamera, String backCamera, String internalStorage, String operatingSystem, boolean antivirus, String mobileDate, String mobileNumber, boolean mobileStatus) {
        this.id = id;
        this.imei = imei;
        this.brand = brand;
        this.model = model;
        this.storageCapacity = storageCapacity;
        this.frontCamera = frontCamera;
        this.backCamera = backCamera;
        this.internalStorage = internalStorage;
        this.operatingSystem = operatingSystem;
        this.antivirus = antivirus;
        this.mobileDate = mobileDate;
        this.mobileNumber = mobileNumber;
        this.mobileStatus = mobileStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(String storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(String backCamera) {
        this.backCamera = backCamera;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isAntivirus() {
        return antivirus;
    }

    public void setAntivirus(boolean antivirus) {
        this.antivirus = antivirus;
    }

    public String getMobileDate() {
        return mobileDate;
    }

    public void setMobileDate(String mobileDate) {
        this.mobileDate = mobileDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isMobileStatus() {
        return mobileStatus;
    }

    public void setMobileStatus(boolean mobileStatus) {
        this.mobileStatus = mobileStatus;
    }

    @Override
    public String toString() {
        return "Mobile{" + "id=" + id + ", imei=" + imei + ", brand=" + brand + ", model=" + model + ", storageCapacity=" + storageCapacity + ", frontCamera=" + frontCamera + ", backCamera=" + backCamera + ", internalStorage=" + internalStorage + ", operatingSystem=" + operatingSystem + ", antivirus=" + antivirus + ", mobileDate=" + mobileDate + ", mobileNumber=" + mobileNumber + ", mobileStatus=" + mobileStatus + '}';
    }

}
