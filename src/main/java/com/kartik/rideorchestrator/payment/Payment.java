package com.kartik.rideorchestrator.payment;

import com.kartik.rideorchestrator.common.Money;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private final UUID id;

    private String gatewayTransactionId;

    private final UUID rideId;

    private final Money amount;

    private final PaymentMethod paymentMethod;

    private PaymentStatus status;

    private final LocalDateTime createdAt;

    private LocalDateTime completedAt;

    public Payment(UUID rideId,
                   Money amount,
                   PaymentMethod paymentMethod) {

        if (rideId == null) {
            throw new IllegalArgumentException("Ride ID cannot be null.");
        }

        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null.");
        }

        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null.");
        }

        this.id = UUID.randomUUID();
        this.rideId = rideId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    // Move payment from PENDING -> PROCESSING
    public void initiate() {

        if (status != PaymentStatus.PENDING) {
            throw new IllegalStateException(
                    "Payment can only be initiated from PENDING state."
            );
        }

        this.status = PaymentStatus.PROCESSING;
    }

    // Move payment from PROCESSING -> COMPLETED
    public void complete(String gatewayTransactionId) {

        if (status != PaymentStatus.PROCESSING) {
            throw new IllegalStateException(
                    "Payment can only be completed from PROCESSING state."
            );
        }

        if (gatewayTransactionId == null || gatewayTransactionId.isBlank()) {
            throw new IllegalArgumentException(
                    "Gateway transaction ID cannot be null or blank."
            );
        }

        this.gatewayTransactionId = gatewayTransactionId;
        this.status = PaymentStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
    }

    // Move payment from PROCESSING -> FAILED
    public void fail() {

        if (status != PaymentStatus.PROCESSING) {
            throw new IllegalStateException(
                    "Payment can only fail from PROCESSING state."
            );
        }

        this.status = PaymentStatus.FAILED;
    }

    // Move payment from FAILED -> PROCESSING
    public void retry() {

        if (status != PaymentStatus.FAILED) {
            throw new IllegalStateException(
                    "Only failed payments can be retried."
            );
        }

        this.status = PaymentStatus.PROCESSING;
    }

    // Move payment from COMPLETED -> REFUNDED
    public void refund() {

        if (status != PaymentStatus.COMPLETED) {
            throw new IllegalStateException(
                    "Only completed payments can be refunded."
            );
        }

        this.status = PaymentStatus.REFUNDED;
    }

    // Getters

    public UUID getId() {
        return id;
    }

    public String getGatewayTransactionId() {
        return gatewayTransactionId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public Money getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
}