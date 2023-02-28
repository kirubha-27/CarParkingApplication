package com.carparking.userlogin;

import com.carparking.dto.ParkingLot;
import com.carparking.dto.User;

import java.util.List;

public class UserController implements UserViewControllerCallback, UserModelControllerCallback {
    private UserViewCallback userView;
    private UserModelCallback userModel;

    UserController(UserViewCallback userView) {
        this.userView = userView;
        userModel = new UserModel(this);
    }


    @Override
    public void signUp(String userName, String userEmail, String carName, String password) {
        userModel.signUp(userName,userEmail,carName,password);
    }

    @Override
    public void getParkingLots(String location) {
        userModel.getParkingLot(location);
    }

    @Override
    public void getParkingLotsForBooking(String location1) {
        userModel.getParkingLotForBooking(location1);
    }

    @Override
    public void checkUserCredential(String userId, String password) {
        userModel.checkUserCredential(userId,password);
    }

    @Override
    public User getUser(String vehicle_number) {
        return userModel.getUser(vehicle_number);
    }

    @Override
    public void removeVehicle(String vehicleNumber) {
        userModel.removeVehicle(vehicleNumber);
    }

    @Override
    public void signUpSuccess(User user) {
        userView.signUpSuccess(user);
    }

    @Override
    public void signUpFailure(String could_not_signup) {
        userView.signUpFailure(could_not_signup);
    }

    @Override
    public void getParkingLotFailure(String str) {
        userView.getParkingLotFailure(str);
    }

    @Override
    public void getParkingLotSuccess(List<ParkingLot> parkingLots) {
        userView.getParkingLotSuccess(parkingLots);
    }

    @Override
    public void getParkingLotForBookingFailure(String errorMessage) {
        userView.getParkingLotForBookingFailure(errorMessage);
    }

    @Override
    public void getParkingLotForBookingSuccess(List<ParkingLot> parkingLots) {
        userView.getParkingLotForBookingSuccess(parkingLots);
    }

    @Override
    public void loginSuccess(User user) {
        userView.loginSuccess(user);
    }

    @Override
    public void loginFailure(String login_failed) {
        userView.loginFailure(login_failed);
    }

    @Override
    public void vehicleRemoveSuccess(User user) {
        userView.vehicleRemoveSuccess(user);
    }

    @Override
    public void vehicleRemoveFailure(String s) {
        userView.vehicleRemoveFailure(s);
    }


}