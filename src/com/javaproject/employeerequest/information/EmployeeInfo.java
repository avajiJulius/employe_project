package com.javaproject.employeerequest.information;

import com.javaproject.employeerequest.profession.Profession;

public abstract class EmployeeInfo {
    private Profession profession;
    private double experience;
    private String about;
    private PrevEmployer employer;


//    Нужно сделать конструктор для нескольких прошлых работодателей, списоком
    public EmployeeInfo(Profession profession, double experience,
                        String about, PrevEmployer employer) {
        this.profession = profession;
        this.experience = experience;
        this.about = about;
        this.employer = employer;
    }

    public static  void getProfessionInfo(Profession profession) {
        if (profession.equals(Profession.NANNY))
            NannyInfo.getProfessionInfo();
        else
            DriverInfo.getProfessionInfo();
    }
}
