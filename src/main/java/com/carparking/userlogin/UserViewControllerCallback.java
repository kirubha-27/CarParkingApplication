package com.carparking.userlogin;

import com.carparking.dto.User;

public interface UserViewControllerCallback {

    void signUp(String userName, String userEmail, String carName, String password);

    void getParkingLots(String location);

    void getParkingLotsForBooking(String location1);

    void checkUserCredential(String userId, String password);

    User getUser(String vehicle_number);

    void removeVehicle(String vehicleNumber);
}