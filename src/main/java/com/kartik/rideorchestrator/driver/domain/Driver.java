package com.kartik.rideorchestrator.driver.domain;

import com.kartik.rideorchestrator.common.*;
import com.kartik.rideorchestrator.vehicle.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Driver {
//    private final UUID id;

    private UserProfile profile;

    private DrivingLicense drivingLicense;

    private double averageRating;

    private DriverStatus status;

    private List<Vehicle> vehicles;

    private Vehicle activeVehicle;

    public Driver(
            UserProfile profile,
            DrivingLicense drivingLicense
    ){
        this.profile = profile;
        this.drivingLicense = drivingLicense;
        this.averageRating = 0.0;
        this.status = DriverStatus.OFFLINE;
        this.vehicles = new  ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void assignActiveVehicle(Vehicle vehicle){
        if(!vehicles.contains(vehicle)){
            throw new RuntimeException("Vehicle is not registered");
        }
        this.activeVehicle = vehicle;
    }

    public void goOnline(){
        if(activeVehicle==null){
            throw new RuntimeException("Driver must select an active vehicle before going online");
        }
        this.status = DriverStatus.ONLINE;
    }

    public void goOffline(){
        this.status = DriverStatus.OFFLINE;
    }

}
