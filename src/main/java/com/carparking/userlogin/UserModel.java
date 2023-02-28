package com.carparking.userlogin;

import com.carparking.dto.ParkingLot;
import com.carparking.dto.User;
import com.carparking.repository.ParkingRepository;

import java.util.List;

public class UserModel implements UserModelCallback {
    private static int generateUserId = 1;
    public String userId = "U000";
    UserModelControllerCallback userController;

    UserModel(UserModelControllerCallback userController) {
        this.userController = userController;
    }

    @Override
    public void signUp(String userName, String userEmail, String carNumber, String password) {
        User user = ParkingRepository.getInstance().setUserDetails(userName, userEmail, carNumber, password, userId + (++generateUserId));
        if (user != null) {
            userController.signUpSuccess(user);
        } else {
            userController.signUpFailure("Could not signup");
        }
    }

    @Override
    public void getParkingLot(String location) {
        List<ParkingLot> parkingLots = ParkingRepository.getInstance().getParkingLot(location);
        if (parkingLots.isEmpty()) {
            userController.getParkingLotFailure("There is no parking lot available in ");
        } else {
            userController.getParkingLotSuccess(parkingLots);
        }
    }

    @Override
    public void getParkingLotForBooking(String location) {
        List<ParkingLot> parkingLots = ParkingRepository.getInstance().getParkingLot(location);
//        if(parkingLots==null){
//            userController.getParkingLotForBookingFailure("There is no parking lot available");
//            return;
//        }
        if (parkingLots.isEmpty()) {
            userController.getParkingLotForBookingFailure("There is no parking lot available");
        } else {
            userController.getParkingLotForBookingSuccess(parkingLots);
        }
    }

    @Override
    public void checkUserCredential(String userId, String password) {
        User user = ParkingRepository.getInstance().checkUserCredential(userId, password);
        if (user != null) {
            userController.loginSuccess(user);
        } else {
            userController.loginFailure("Login failed");
        }
    }

    @Override
    public User getUser(String vehicle_number) {
        return ParkingRepository.getInstance().getUser(vehicle_number);
    }

    @Override
    public void removeVehicle(String vehicleNumber) {
        User user = ParkingRepository.getInstance().removeVehicle(vehicleNumber);
        if (user != null){
            userController.vehicleRemoveSuccess(user);
    }else

    {
        userController.vehicleRemoveFailure("There no car in this vehicle number");
    }
}

}