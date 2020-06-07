package com.javaproject.employeerequest.employee;

import com.javaproject.employeerequest.profession.Profession;

import java.time.LocalDate;

public class Employee {
    private String fName;
    private String lName;
    private Profession profession;
    private double experience;
    private LocalDate birthDay;
    private String mail;

    public Employee(String fName, String lName, Profession profession,
                    double experience, LocalDate birthDay, String mail) {
        this.fName = fName;
        this.lName = lName;
        this.profession = profession;
        this.experience = experience;
        this.birthDay = birthDay;
        this.mail = mail;
    }
}
