package com.carparking.admin;

import com.carparking.dto.Admin;
import com.carparking.dto.ParkingLot;
import com.carparking.repository.ParkingRepository;

import java.util.List;

public class adminModel implements adminModelCallback {
    private int generateAdminId = 1;

    private int generateParkingId = 1;
    private String parkingId = "P000";
    private String adminId = "A000";
    adminModelControllerCallback adminController;

    adminModel(adminModelControllerCallback adminController) {
        this.adminController = adminController;
    }

    @Override
    public void signUp(String userName, String userEmail, String password) {
        Admin admin = ParkingRepository.getInstance().setAdmin(userName,userEmail,password,adminId+(++generateAdminId));
        if(admin!=null){
            adminController.signUpSuccess(admin);
        }else{
            adminController.signUpFailure("Could not signup");
        }
    }

    @Override
    public void setParkingLots(String location, int no_of_floors, int lotCapacity,float price) {
        ParkingLot parkingLot = ParkingRepository.getInstance().setParkingLots(location,no_of_floors,lotCapacity,parkingId+(++generateParkingId),price);
        if(parkingLot != null){
            adminController.addParkingSuccess(parkingLot);
        }else{
            adminController.addParkingFailure("There is no parking lot available");
        }
    }

    @Override
    public void checkAdminCredential(String adminId, String password) {
        Admin admin = ParkingRepository.getInstance().checkAdminCredential(adminId,password);
        if(admin!=null){
            adminController.loginSuccess(admin);
        }else{
            adminController.loginFailure("Login failed");
        }
    }

    @Override
    public List<ParkingLot> getParkingLots() {
        return ParkingRepository.getInstance().getParkingLots();
    }


}