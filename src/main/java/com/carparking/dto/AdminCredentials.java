package com.carparking.dto;

public class AdminCredentials extends Admin{
    private String password;


    public AdminCredentials(String adminName, String adminId, String adminEmail, String password) {
        super(adminName, adminId, adminEmail);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
