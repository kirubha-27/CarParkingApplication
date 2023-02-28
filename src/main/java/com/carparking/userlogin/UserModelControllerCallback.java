package com.carparking.userlogin;

import com.carparking.dto.ParkingLot;
import com.carparking.dto.User;

import java.util.List;

public interface UserModelControllerCallback {

    void signUpSuccess(User user);

    void signUpFailure(String could_not_signup);

    void getParkingLotFailure(String s);

    void getParkingLotSuccess(List<ParkingLot> parkingLots);

    void getParkingLotForBookingFailure(String s);

    void getParkingLotForBookingSuccess(List<ParkingLot> parkingLots);

    void loginSuccess(User user);

    void loginFailure(String login_failed);

    void vehicleRemoveSuccess(User user);

    void vehicleRemoveFailure(String s);
}