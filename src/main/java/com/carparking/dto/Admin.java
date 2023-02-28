package com.carparking.dto;

public class Admin {
    private String adminName;
    private String adminId;

    private String adminEmail;

    public Admin(String adminName, String adminId, String adminEmail) {
        this.adminName = adminName;
        this.adminId = adminId;
        this.adminEmail = adminEmail;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
