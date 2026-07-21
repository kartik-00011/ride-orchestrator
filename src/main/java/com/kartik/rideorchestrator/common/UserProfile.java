package com.kartik.rideorchestrator.common;
import java.util.UUID;

public class UserProfile{
    private final UUID id;
    private Name name;
    private PhoneNumber phoneNumber;
    private Email email;

    public UserProfile(
            UUID id,
            Name name,
            PhoneNumber phoneNumber,
            Email email
            ){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
