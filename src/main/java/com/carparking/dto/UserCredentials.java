package com.carparking.dto;

public class UserCredentials extends User {
    private String password;

    public UserCredentials(String userName, String userId, String userEmail, String carNumber, String inDateTime, String outDateTime, String password) {
        super(userName, userId, userEmail, carNumber, inDateTime, outDateTime);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
