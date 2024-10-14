package com.EmployeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection getDBConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "Dinesh", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}