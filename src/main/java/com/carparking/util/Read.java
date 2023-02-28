package com.carparking.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Read {
    static private Scanner scanner = new Scanner(System.in);

    public static String input(String prompt){
        while(true){
            try{
                System.out.println(prompt);
                String val = scanner.nextLine();
                return val;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static int stringToInt(String val){
        return Integer.parseInt(val);
    }
    public static float stringToFloat(String val){
        return Float.parseFloat(val);
    }

    public static String getEmail(String prompt) {
        while (true) {
            try {
                String res = input(prompt);
                if (Check.isValidEmail(res)) {
                    return res;
                } else {
                    System.out.println("Please Enter a Valid Email.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    public static String getPassword(String prompt) {
        while (true) {
            String res = input(prompt);
            if (Check.isStrongPassword(res)) {
                return res;
            } else {
                System.out.println("password is to weak. Password must contain one Special Characters,one Capital " +
                        "letters,and numbers");
            }
        }
    }
}
