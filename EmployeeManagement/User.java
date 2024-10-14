package com.EmployeeManagement;

public class User {
    private String u_name;
    private String password;

    public User(String u_name, String password) {
        this.u_name = u_name;
        this.password = password;
    }

    public String getU_name() {
        return u_name;
    }

    public String getPassword() {
        return password;
    }
}