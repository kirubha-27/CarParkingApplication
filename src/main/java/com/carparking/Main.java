package com.carparking;

import com.carparking.admin.adminView;
import com.carparking.userlogin.UserView;
import com.carparking.util.Read;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        UserView userView = new UserView();
        adminView admin = new adminView();
        while(true){
            System.out.println("1.user signUp");
            System.out.println("2.admin signUp");
            System.out.println("3.user login");
            System.out.println("4.admin login");
            System.out.println("5.Exit");
            int choice = 0;
            try{
                choice = Read.stringToInt(Read.input("Enter the choice"));
            }catch (NumberFormatException e){}
            switch (choice){
                case 1:

                    userView.userSignUp();
                    break;
                case 2:

                    admin.adminSignUp();
                    break;
                case 3:
                    userView.userSignIn();
                    break;
                case 4:
                    admin.adminSignIn();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("enter valid choice");
                    break;
            }
        }
    }
}