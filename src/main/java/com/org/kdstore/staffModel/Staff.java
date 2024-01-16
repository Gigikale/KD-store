package com.org.kdstore.staffModel;

public class Staff {
    private String name;
    private String phoneNumber;
    private String role;

    public Staff(String name, String phoneNumber, String role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Staff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
