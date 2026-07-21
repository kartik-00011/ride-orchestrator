package com.kartik.rideorchestrator.rider;

import com.kartik.rideorchestrator.common.UserProfile;

import java.util.UUID;

public class Rider {

    private final UUID id;

    private final UserProfile userProfile;

    public Rider(UserProfile userProfile) {

        if (userProfile == null) {
            throw new IllegalArgumentException("User profile cannot be null.");
        }

        this.id = UUID.randomUUID();
        this.userProfile = userProfile;
    }

    public UUID getId() {
        return id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}