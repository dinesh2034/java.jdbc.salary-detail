package com.EmployeeManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee e;
        EmployeeManagement em = new EmployeeManagement();
        Login l = new Login();
        User u = null;

        String name, id, department, u_name, pwd;
        float salary;
        boolean isLoggedIn = false;

        do {
            if (!isLoggedIn) {
                System.out.println("Login Details ");
                System.out.println("Enter User Name: ");
                u_name = scan.next();
                System.out.println("Enter Password: ");
                pwd = scan.next();
                u = new User(u_name, pwd);
                int lc = l.checkUser(u);

                if (lc == 1) {
                    isLoggedIn = true;
                } else if (lc == 2) {
                    isLoggedIn = true;
                } else {
                    System.out.println("Invalid Login. Showing Employee List.");
                }
            }

            if (isLoggedIn) {
                if (l.checkUser(u) == 1) {
                    boolean isAdminLoggedIn = true;
                    do {
                        System.out.println("1-Add\n2-Update\n3-Remove\n4-Search\n5-Display\n6-Logout\n7-Exit");
                        System.out.println("Enter Option: ");
                        int option = scan.nextInt();

                        switch (option) {
                            case 1:
//                                System.out.println("Enter ID: ");
//                                id = scan.next();
                                System.out.println("Enter Name: ");
                                name = scan.next();
                                System.out.println("Enter Department: ");
                                department = scan.next();
                                System.out.println("Enter Salary: ");
                                salary = scan.nextFloat();
                                em.add(new Employee(name, department, salary));
                                break;

                            case 2:
                                System.out.println("Enter ID: ");
                                id = scan.next();
                                em.update(id);
                                break;

                            case 3:
                                System.out.println("Enter ID: ");
                                id = scan.next();
                                em.remove(id);
                                break;

                            case 4:
                                System.out.println("Enter ID: ");
                                id = scan.next();
                                e = em.search(id);
                                if (e != null) {
                                    System.out.println(e);
                                } else {
                                    System.out.println("Employee not found!");
                                }
                                break;

                            case 5:
                                em.show();
                                break;

                            case 6:
                                System.out.println("Do you want to logout? (yes/no)");
                                String logout = scan.next();
                                if (logout.equalsIgnoreCase("yes")) {
                                    System.out.println("Logging out...");
                                    isLoggedIn = false;
                                    isAdminLoggedIn = false;
                                } else {
                                    continue;
                                }

                            case 7:
                                System.out.println("Do you want to exit? (yes/no)");
                                String exit = scan.next();
                                if (exit.equalsIgnoreCase("yes")) {
                                    System.out.println("Exiting...");
                                    return;
                                } else {
                                    continue;
                                }

                            default:
                                System.out.println("Invalid Option!");
                                break;
                        }

                    } while (isAdminLoggedIn);
                } else if (l.checkUser(u) == 2) {
                    boolean isUserLoggedIn = true;
                    do {
                        System.out.println("1-Display\n2-Search\n3-Logout\n4-Exit");
                        System.out.println("Enter Option: ");
                        int option = scan.nextInt();

                        switch (option) {
                            case 1:
                                em.show();
                                break;

                            case 2:
                                System.out.println("Enter ID: ");
                                id = scan.next();
                                e = em.search(id);
                                if (e != null) {
                                    System.out.println(e);
                                } else {
                                    System.out.println("Employee not found!");
                                }
                                break;

                            case 3:
                                System.out.println("Do you want to logout? (yes/no)");
                                String logout = scan.next();
                                if (logout.equalsIgnoreCase("yes")) {
                                    System.out.println("Logging out...");
                                    isLoggedIn = false;
                                    isUserLoggedIn = false;
                                } else {
                                    continue;
                                }

                            case 4:
                                System.out.println("Do you want to exit? (yes/no)");
                                String exit = scan.next();
                                if (exit.equalsIgnoreCase("yes")) {
                                    System.out.println("Exiting...");
                                    return;
                                } else {
                                    continue;
                                }

                            default:
                                System.out.println("Invalid Option!");
                                break;
                        }

                    } while (isUserLoggedIn);
                }
            }

        } while (true);
    }
}