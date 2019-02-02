package com.github.enriqueabsurdum.enums;

public enum OperatingSystem {

    ANDROID("Google Android"),
    IPHONEOS("Apple iOS"),
    WINDOWS("Windows Phone"),
    HUAWEI("Huawei Embedded OS"),
    SYMBIAN("Accenture Symbian");

    private String operatingSystem;

    private OperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" + "operatingSystem=" + operatingSystem + '}';
    }
}
