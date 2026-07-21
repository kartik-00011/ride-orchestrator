package com.kartik.rideorchestrator.ride;

import com.kartik.rideorchestrator.common.Location;

import java.time.LocalDateTime;
import java.util.UUID;

public class RideRequest {

    private final UUID id;

    private final UUID riderId;

    private UUID assignedDriverId;

    private Location pickupLocation;

    private Location dropLocation;

    private RideRequestStatus status;

    private LocalDateTime createdAt;


    public RideRequest(
            UUID riderId,
            Location pickupLocation,
            Location dropLocation
    ) {
        this.id = UUID.randomUUID();

        this.riderId = riderId;

        this.pickupLocation = pickupLocation;

        this.dropLocation = dropLocation;

        this.status = RideRequestStatus.CREATED;

        this.createdAt = LocalDateTime.now();
    }

    public void startSearching(){
        if(status != RideRequestStatus.CREATED){
            throw new RuntimeException(
                    "Ride Request can only start searching from CREATED state"
            );
        }
        this.status = RideRequestStatus.SEARCHING_FOR_DRIVER;
    }

    public void assignDriver(UUID driverId){
        if(status != RideRequestStatus.SEARCHING_FOR_DRIVER){
            throw new RuntimeException(
                    "Driver can only be assigned from SEARCHING_FOR_DRIVER state"
            );
        }
        this.assignedDriverId = driverId;
        this.status = RideRequestStatus.DRIVER_ASSIGNED;
    }

    public void cancel(){
        if(status == RideRequestStatus.CANCELLED
             || status == RideRequestStatus.EXPIRED){
            throw new RuntimeException(
                    "Ride request is already cancelled or expired"
            );
        }
        this.status = RideRequestStatus.CANCELLED;
    }

    public void expire(){
        if(status == RideRequestStatus.SEARCHING_FOR_DRIVER){
            throw new RuntimeException(
                    "Ride request can only expire from SEARCHING_FOR_DRIVER state"
            );
        }
        this.status = RideRequestStatus.EXPIRED;
    }
}
