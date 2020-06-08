package com.javaproject.employeerequest;

import com.javaproject.employeerequest.information.EmployeeInfo;
import com.javaproject.employeerequest.profession.Profession;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your profession: ");
        String p = scanner.next().toUpperCase();
        Profession profession = Profession.valueOf(p);
        System.out.println(profession);

        EmployeeInfo.getProfessionInfo(profession);


    }
}
