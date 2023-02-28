package com.carparking.admin;

import com.carparking.dto.Admin;
import com.carparking.dto.ParkingLot;

import java.util.List;

public class adminController implements adminViewControllerCallback, adminModelControllerCallback {
    private adminViewCallback adminView;
    private adminModelCallback adminModel;

    adminController(adminViewCallback adminView) {
        this.adminView = adminView;
        adminModel = new adminModel(this);
    }


    @Override
    public void signUp(String userName, String userEmail, String password) {
        adminModel.signUp(userName,userEmail,password);
    }

    @Override
    public void setParkingLots(String location, int no_of_floors, int lotCapacity,float price) {
        adminModel.setParkingLots(location,no_of_floors,lotCapacity,price);
    }

    @Override
    public void checkAdminCredential(String adminId, String password) {
        adminModel.checkAdminCredential(adminId,password);
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return adminModel.getParkingLots();
    }

    @Override
    public void signUpSuccess(Admin admin) {
        adminView.signUpSuccess(admin);
    }

    @Override
    public void signUpFailure(String could_not_signup) {
        adminView.signUpFailure(could_not_signup);
    }

    @Override
    public void addParkingSuccess(ParkingLot parkingLot) {
        adminView.addParkingSuccess(parkingLot);
    }

    @Override
    public void addParkingFailure(String s) {
        adminView.addParkingFailure(s);
    }

    @Override
    public void loginFailure(String login_failed) {
        adminView.loginFailure(login_failed);
    }

    @Override
    public void loginSuccess(Admin admin) {
        adminView.loginSuccess(admin);
    }
}