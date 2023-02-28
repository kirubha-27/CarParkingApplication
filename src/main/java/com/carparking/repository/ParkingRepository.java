package com.carparking.repository;

import com.carparking.dto.*;
import com.carparking.util.Read;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepository {
    private static ParkingRepository parkingRepository;

    List<AdminCredentials> adminList = new ArrayList<>();
    List<UserCredentials> userList = new ArrayList<>();
    List<ParkingLot> parkingList = new ArrayList<>();

    private ParkingRepository() {

    }
    public static ParkingRepository getInstance(){
        if(parkingRepository==null){
            parkingRepository = new ParkingRepository();
        }
        return parkingRepository;
    }


    public User setUserDetails(String userName, String userEmail, String carNumber, String password,String userId) {
        userList.add(new UserCredentials(userName,userId,userEmail,carNumber, Read.getCurrentDate(),Read.getCurrentDate(),password));
        return userList.get(userList.size()-1);
    }

    public List<ParkingLot> getParkingLot(String location) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        for(ParkingLot parkingLot:parkingList){
            if(parkingLot.getAddress().equals(location)){
                if(parkingLot.getNo_of_vehicles().size()<(parkingLot.getLotCapacity()* parkingLot.getNo_of_floors())) {
                    parkingLots.add(parkingLot);
                    break;
                }
            }
        }
        return parkingLots;
    }

    public Admin setAdmin(String adminName, String adminEmail, String password,String adminId) {
        adminList.add(new AdminCredentials(adminName,adminId,adminEmail,password));
        return adminList.get(adminList.size()-1);
    }

    public ParkingLot setParkingLots(String location, int no_of_floors, int lotCapacity, String s,float price) {
        parkingList.add(new ParkingLot(s,location,no_of_floors,lotCapacity,price,new ArrayList<>()));
        return parkingList.get(parkingList.size()-1);
    }

    public User checkUserCredential(String userId, String password) {
        for(UserCredentials user:userList){
            if(user.getUserId().equals(userId)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public Admin checkAdminCredential(String adminId, String password) {
        for(AdminCredentials admin:adminList){
            if(admin.getAdminId().equals(adminId)&&admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingList;
    }

    public User getUser(String vehicle_number) {
        for(User user:userList){
            if(user.getCarNumber().equals(vehicle_number)){
                return user;
            }
        }
        return null;
    }

    public User removeVehicle(String vehicleNumber) {
        for(ParkingLot parkingLot : parkingList){
            if(parkingLot.getNo_of_vehicles().contains(vehicleNumber)){
                User temp = null;
                for(User string : userList) {
                  temp  = string;
                }
                parkingLot.getNo_of_vehicles().remove(vehicleNumber);
                return temp;
            }
        }
        return null;
    }
}
