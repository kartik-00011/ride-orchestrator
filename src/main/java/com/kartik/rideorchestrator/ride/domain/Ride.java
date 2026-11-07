package com.kartik.rideorchestrator.ride.domain;

import com.kartik.rideorchestrator.common.Location;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ride {
    private final UUID id;
    private final UUID rideRequestId;
    private final UUID riderId;
    private final UUID driverId;
    private final Location pickupLocation;
    private final Location dropLocation;
    private RideStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    public Ride(UUID rideRequestId,
                UUID riderId,
                UUID driverId,
                Location pickupLocation,
                Location dropLocation){

        this.id = UUID.randomUUID();
        this.rideRequestId = rideRequestId;
        this.riderId = riderId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = RideStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

}
