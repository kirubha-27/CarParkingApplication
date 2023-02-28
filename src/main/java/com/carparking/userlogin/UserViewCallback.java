package com.carparking.userlogin;

import com.carparking.dto.ParkingLot;
import com.carparking.dto.User;

import java.util.List;

public interface UserViewCallback {

    void signUpSuccess(User user);

    void signUpFailure(String could_not_signup);

    void getParkingLotFailure(String str);

    void getParkingLotSuccess(List<ParkingLot> parkingLots);

    void getParkingLotForBookingFailure(String errorMessage);

    void getParkingLotForBookingSuccess(List<ParkingLot> parkingLots);

    void loginSuccess(User user);

    void loginFailure(String login_failed);

    void vehicleRemoveFailure(String s);

    void vehicleRemoveSuccess(User user);
}