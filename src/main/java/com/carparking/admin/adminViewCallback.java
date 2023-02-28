package com.carparking.admin;

import com.carparking.dto.Admin;
import com.carparking.dto.ParkingLot;

public interface adminViewCallback {

    void signUpSuccess(Admin admin);

    void signUpFailure(String could_not_signup);

    void addParkingFailure(String s);

    void addParkingSuccess(ParkingLot parkingLot);

    void loginSuccess(Admin admin);

    void loginFailure(String login_failed);
}