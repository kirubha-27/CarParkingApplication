package com.carparking.admin;

import com.carparking.dto.Admin;
import com.carparking.dto.ParkingLot;

public interface adminModelControllerCallback {

    void signUpSuccess(Admin admin);

    void signUpFailure(String could_not_signup);

    void addParkingSuccess(ParkingLot parkingLot);

    void addParkingFailure(String s);

    void loginFailure(String login_failed);

    void loginSuccess(Admin admin);
}