package com.javaproject.employeerequest.employee;

import com.javaproject.employeerequest.profession.Profession;

import java.time.LocalDate;

public class Driver extends Employee{
    private double salary;

    public Driver(String fName, String lName, Profession profession,
                  double experience, LocalDate birthDay, String mail, double salary) {
        super(fName, lName, profession, experience, birthDay, mail);
        this.salary = salary;
    }
}
