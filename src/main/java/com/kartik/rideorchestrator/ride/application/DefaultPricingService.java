package com.kartik.rideorchestrator.ride.application;

import com.kartik.rideorchestrator.common.Money;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class DefaultPricingService implements PricingService {

    @Override
    public FareEstimate calculateFare(RouteResult routeResult) {

        BigDecimal baseFare = BigDecimal.valueOf(50);
        BigDecimal perKm = BigDecimal.valueOf(12);

        BigDecimal total = baseFare.add(
                perKm.multiply(BigDecimal.valueOf(routeResult.distanceInKm()))
        );

        return new FareEstimate(
                new Money(
                        total,
                        Currency.getInstance("INR")
                )
        );
    }
}