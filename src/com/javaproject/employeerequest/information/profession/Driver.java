package com.javaproject.employeerequest.information.profession;

import com.javaproject.employeerequest.profession.Profession;

import java.util.ArrayList;

public class Driver extends Employee {
    private double salary;
    private String car;

    public Driver(double experience, String about, ArrayList<PrevEmployer> employers,
                  double salary, String car) {
        super(Profession.DRIVER, experience, about, employers);
        this.salary = salary;
        this.car = car;
    }

    public static void getProfessionInfo() {
        System.out.println("I am Driver");
    }
}
