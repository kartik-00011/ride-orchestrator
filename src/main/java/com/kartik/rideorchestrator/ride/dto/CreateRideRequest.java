package com.kartik.rideorchestrator.ride.dto;

import com.kartik.rideorchestrator.common.Location;

import java.util.UUID;

public record CreateRideRequest(
        UUID riderId,
        Location pickupLocation,
        Location dropLocation,
        String idempotencyKey
        ) {
}