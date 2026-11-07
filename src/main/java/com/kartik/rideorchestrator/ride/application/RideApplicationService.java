package com.kartik.rideorchestrator.ride.application;

import com.kartik.rideorchestrator.common.Location;
import com.kartik.rideorchestrator.ride.dto.CreateRideRequest;
import org.springframework.stereotype.Service;

@Service
public class RideApplicationService {

    private final RoutingService routingService;
    private final PricingService pricingService;

    public RideApplicationService(
            RoutingService routingService,
            PricingService pricingService
    ) {
        this.routingService = routingService;
        this.pricingService = pricingService;
    }

    public FareEstimate estimateFare(CreateRideRequest request) {

        RouteResult route = routingService.calculateRoute(
                request.pickupLocation(),
                request.dropLocation()
        );

        return pricingService.calculateFare(route);
    }
}