package com.carparking.dto;

import java.time.LocalDate;

public class User {
    private String userName;
    private String userId;
    private String userEmail;
    private String carNumber;

    private String inDateTime;

    private String outDateTime;

    public User(String userName, String userId, String userEmail, String carNumber, String inDateTime, String outDateTime) {
        this.userName = userName;
        this.userId = userId;
        this.userEmail = userEmail;
        this.carNumber = carNumber;
        this.inDateTime = inDateTime;
        this.outDateTime = outDateTime;
    }

    public String getInDateTime() {
        return inDateTime;
    }

    public void setInDateTime(String inDateTime) {
        this.inDateTime = inDateTime;
    }

    public String getOutDateTime() {
        return outDateTime;
    }

    public void setOutDateTime(String outDateTime) {
        this.outDateTime = outDateTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
