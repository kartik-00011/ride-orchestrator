package com.kartik.rideorchestrator.ride.application;

public interface PricingService {

    FareEstimate calculateFare(RouteResult routeResult);
}