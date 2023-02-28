package com.carparking.userlogin;

import com.carparking.dto.User;

public interface UserModelCallback {

    void signUp(String userName, String userEmail, String carName, String password);

    void getParkingLot(String location);

    void getParkingLotForBooking(String location);

    void checkUserCredential(String userId, String password);

    User getUser(String vehicle_number);

    void removeVehicle(String vehicleNumber);
}