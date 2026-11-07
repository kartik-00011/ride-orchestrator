package com.kartik.rideorchestrator.ride.application;

import com.kartik.rideorchestrator.common.Location;

public interface RoutingService {

    RouteResult calculateRoute(
            Location pickup,
            Location drop
    );
}
