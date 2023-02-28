package com.carparking.admin;

import com.carparking.dto.ParkingLot;

import java.util.List;

public interface adminModelCallback {

    void signUp(String userName, String userEmail, String password);

    void setParkingLots(String location, int no_of_floors, int lotCapacity,float price);

    void checkAdminCredential(String adminId, String password);
    List<ParkingLot> getParkingLots();
}