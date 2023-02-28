package com.carparking.admin;

import com.carparking.dto.Admin;
import com.carparking.dto.ParkingLot;
import com.carparking.util.Read;

import java.util.List;

public class adminView implements adminViewCallback {
    private adminViewControllerCallback adminController;

    public adminView() {
        adminController = new adminController(this);
    }

    public void adminSignUp(){
        String userName = Read.input("Enter the admin Name: ");
        String userEmail = Read.getEmail("Enter the email: ");
        String password = Read.getPassword("Enter the password: ");
        adminController.signUp(userName,userEmail,password);
    }

    @Override
    public void signUpSuccess(Admin admin) {
        System.out.println(admin.getAdminId()+" is successfully created");
        adminPage(admin);
    }
//
//    public static void main(String[] args) {
//        adminView admin = new adminView();
//        admin.adminSignUp();
//    }
    private void adminPage(Admin admin) {
        //boolean flag = true;
        while(true) {
            System.out.println("-------------Admin Page--------------");
            System.out.println();
            System.out.println("1.set parking lots");
            System.out.println("2.show parking lots");
            System.out.println("3.change prices");
            System.out.println("4.logout");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            } catch (NumberFormatException e) {
            }
            if (choice == 4) {
                return;
            }
            adminChoice(choice, admin);
        }
    }

    private void adminChoice(int choice, Admin admin) {
//        private String parkingId;
//        private String address;
//        private int no_of_floors;
//        private int lotCapacity;
//        private List<String> no_of_vehicles;
        switch (choice){
            case 1:
                String location = Read.input("Enter the location: ");
                int no_of_floors = Read.stringToInt(Read.input("Enter the Number of floors: "));
                int lotCapacity = Read.stringToInt(Read.input("Enter the lot capacity"));
                float prices = Read.stringToFloat(Read.input("Enter the prices: "));
                adminController.setParkingLots(location,no_of_floors,lotCapacity,prices);
                break;
            case 2:
                List<ParkingLot> parkingLotList = adminController.getParkingLots();
                showParkingLot(parkingLotList);
        }
    }

    private void showParkingLot(List<ParkingLot> parkingLotList) {
        if(parkingLotList.isEmpty()){
            System.out.println("There is no parking lots");
            return;
        }
        System.out.println("------------->parking lots<----------------");
        int i = 1;
        for (ParkingLot parkingLot : parkingLotList) {
            System.out.println("----------->parking lot " + i++ + "<------------");
            System.out.println("Parking Lot Id: " + parkingLot.getParkingId());
            System.out.println("Parking Lot Address: " + parkingLot.getAddress());
            System.out.println("parking Lot Capacity: " + parkingLot.getLotCapacity());
            System.out.println("parking lot floors: " + parkingLot.getNo_of_floors());
            System.out.println("parking Lot capacity: " + ((parkingLot.getLotCapacity()) * (parkingLot.getNo_of_floors())));

        }
    }
    @Override
    public void signUpFailure(String could_not_signup) {
        System.out.println(could_not_signup);
    }

    @Override
    public void addParkingFailure(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void addParkingSuccess(ParkingLot parkingLot) {
        System.out.println("parking lot Successfully added");

    }

    @Override
    public void loginSuccess(Admin admin) {
        System.out.println(admin.getAdminId()+" Login successfully");
        adminPage(admin);
    }

    @Override
    public void loginFailure(String login_failed) {
        System.out.println("login failure");
    }

    public void adminSignIn() {
        String adminId = Read.input("Enter the admin Id: ");
        String password = Read.input("Enter the password: ");
        adminController.checkAdminCredential(adminId,password);

    }
}
    