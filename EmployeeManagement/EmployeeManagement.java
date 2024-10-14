package com.EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private DBUtil db = new DBUtil();
    private Connection con;

    public void add(Employee e) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "INSERT INTO employees(name, department, salary) VALUES('" + e.getName() + "','" + e.getDepartment() + "','" + e.getSalary() + "')";
            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Employee added successfully");
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Employee search(String id) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM employees WHERE id='" + id + "'";
            ResultSet rs = stmt.executeQuery(qry);
//            if (rs.next()) {
//                return new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
//            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void update(String id) {
        Scanner sc = new Scanner(System.in);
        int ch;

        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();

            System.out.print("Enter to update 1.Name 2.Department 3.Salary 4.Exit: ");
            ch = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            String qry = null;
            switch (ch) {
                case 1:
                    System.out.println("Enter New Name: ");
                    String newName = sc.nextLine();
                    qry = "UPDATE employees SET name='" + newName + "' WHERE id='" + id + "'";
                    break;

                case 2:
                    System.out.println("Enter New Department: ");
                    String newDepartment = sc.nextLine();
                    qry = "UPDATE employees SET department='" + newDepartment + "' WHERE id='" + id + "'";
                    break;

                case 3:
                    System.out.println("Enter New Salary: ");
                    float newSalary = sc.nextFloat();
                    qry = "UPDATE employees SET salary=" + newSalary + " WHERE id='" + id + "'";
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice");
                    return;
            }

            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out.println("Record updated successfully.");
            } else {
                throw new Exception("No record updated.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(String id) {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            String qry = "DELETE FROM employees WHERE id='" + id + "'";
            int count = stmt.executeUpdate(qry);
            if (count == 1) {
                System.out .println("Employee removed successfully.");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void show() {
        try {
            con = db.getDBConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}