package com.kartik.rideorchestrator.common;

public class DrivingLicense {

    private final String licenseNumber;

    public DrivingLicense(String licenseNumber){
        this.licenseNumber=licenseNumber;
    }

    public String getLicenseNumber(){
        return licenseNumber;
    }
}
