package com.kartik.rideorchestrator.ride.application;

public record RouteResult(
        double distanceInKm,
        long durationInMinutes
) {
}