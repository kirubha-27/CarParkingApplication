package com.carparking.userlogin;

import com.carparking.dto.ParkingLot;
import com.carparking.dto.User;
import com.carparking.util.Read;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserView implements UserViewCallback {
    private UserViewControllerCallback userController;

    public UserView() {
        userController = new UserController(this);
    }
//    public static void main(String[] args){
//        UserView userView = new UserView();
//        userView.userSignUp();
//    }
    public void userSignUp(){
        String userName = Read.input("Enter the user Name: ");
        String carName = Read.input("Enter the car number: ");
        String userEmail = Read.getEmail("Enter the email: ");
        String password = Read.getPassword("Enter the password: ");
        userController.signUp(userName,userEmail,carName,password);
    }
    private void userPage(User user){
        while(true) {
            System.out.println("-------------User Page--------------");
            System.out.println();
            System.out.println("1.show parking lots");
            System.out.println("2.Book parking lots");
            System.out.println("3.view bills");
            System.out.println("4.logout");
            int choice = 0;
            try {
                choice = Read.stringToInt(Read.input("Enter the choice: "));
            } catch (NumberFormatException e) {
            }
            if (choice == 4) {
                return;
            }
            userChoice(choice, user);
        }
    }

    private void userChoice(int choice,User user) {
        switch(choice){
            case 1:
                String location = Read.input("Enter the location: ");
                userController.getParkingLots(location);
                break;
            case 2:
                String location1 = Read.input("Enter the location");
                userController.getParkingLotsForBooking(location1);
                break;
            case 3:
                String vehicleNumber = Read.input("Enter the vehicle number: ");
                User user1 = userController.getUser(vehicleNumber);
                user1.setOutDateTime(Read.getCurrentDate());
                userController.removeVehicle(vehicleNumber);


        }
    }

    @Override
    public void signUpSuccess(User user) {
        System.out.println(user.getUserId()+" is successfully created");
        userPage(user);
    }

    @Override
    public void signUpFailure(String could_not_signup) {
        System.out.println(could_not_signup);
    }
    public void userSignIn(){
        String userId = Read.input("Enter the User Id: ");
        String password = Read.input("Enter the Password: ");
        userController.checkUserCredential(userId,password);
    }
    @Override
    public void getParkingLotFailure(String str) {
        System.out.println(str);
    }

    @Override
    public void getParkingLotSuccess(List<ParkingLot> parkingLots) {
        System.out.println("------------->parking lots<----------------");
        int i=1;
        for(ParkingLot parkingLot : parkingLots){
            System.out.println("----------->parking lot "+i++ +"<------------");
            System.out.println("Parking Lot Id: "+parkingLot.getParkingId());
            System.out.println("Parking Lot Address: "+parkingLot.getAddress());
            System.out.println("parking Lot Capacity: "+parkingLot.getLotCapacity());
            System.out.println("parking lot floors: "+parkingLot.getNo_of_floors());
            System.out.println("parking Lot capacity: "+((parkingLot.getLotCapacity())*(parkingLot.getNo_of_floors())));
        }
    }


    @Override
    public void getParkingLotForBookingFailure(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void getParkingLotForBookingSuccess(List<ParkingLot> parkingLots) {

        for(ParkingLot parkingLot : parkingLots) {
                String vehicle_number = Read.input("Enter the vehicle number: ");
                User user = userController.getUser(vehicle_number);
                if(user!=null){
                    user.setInDateTime(Read.getCurrentDate());
                }
                parkingLots.get(0).getNo_of_vehicles().add(vehicle_number);
                break;
        }


    }

    @Override
    public void loginSuccess(User user) {
        System.out.println(user.getUserId()+" Login successfully");
        userPage(user);
    }

    @Override
    public void loginFailure(String login_failed) {
        System.out.println(login_failed);
    }

    @Override
    public void vehicleRemoveFailure(String s) {
        System.out.println(s);
    }

    @Override
    public void vehicleRemoveSuccess(User user) {
        System.out.println("----------->parking bill<-------------");
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        System.out.println(user.getCarNumber());
        System.out.println(user.getInDateTime());
        System.out.println(user.getOutDateTime());
    }

//    public void userLogin(){
//        String = Read.input()
//    }
}    
    