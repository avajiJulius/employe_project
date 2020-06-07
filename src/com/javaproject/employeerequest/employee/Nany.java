package com.javaproject.employeerequest.employee;

import com.javaproject.employeerequest.profession.Profession;

import java.time.LocalDate;

public class Nany extends Employee {
    private double payPerHour;

    public Nany(String fName, String lName, Profession profession,
                double experience, LocalDate birthDay, String mail, double payPerHour) {
        super(fName, lName, profession, experience, birthDay, mail);
        this.payPerHour = payPerHour;
    }
}
