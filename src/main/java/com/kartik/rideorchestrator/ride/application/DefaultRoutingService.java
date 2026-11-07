package com.kartik.rideorchestrator.ride.application;

import com.kartik.rideorchestrator.common.Location;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoutingService implements RoutingService {

    @Override
    public RouteResult calculateRoute(
            Location pickup,
            Location drop
    ) {
        // Temporary implementation.
        // Real routing provider will be integrated later.
        return new RouteResult(10.0, 20);
    }
}