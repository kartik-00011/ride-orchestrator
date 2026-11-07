package com.kartik.rideorchestrator.vehicle.domain;

import java.util.UUID;

public class Vehicle {

    private final UUID id;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private String manufacturer;
    private String model;
    private String color;

    public Vehicle(
            UUID id,
            String vehicleNumber,
            VehicleType vehicleType,
            String manufacturer,
            String model,
            String color
    ){
        this.id = id;
        this.vehicleNumber=vehicleNumber;
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
    }
}
