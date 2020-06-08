package com.javaproject.employeerequest.information;

import com.javaproject.employeerequest.profession.Profession;

import java.util.ArrayList;

public class NannyInfo extends EmployeeInfo{
    private double hourlyPay;
    private ArrayList<Integer> childrenAge;
//    Необходимо будет исправить возравта детей

    public NannyInfo(double experience, String about,
                    PrevEmployer employer, double hourlyPay, ArrayList<Integer> childrenAge) {
        super(Profession.NANNY, experience, about, employer);
        this.hourlyPay = hourlyPay;
        this.childrenAge = childrenAge;
    }

    public static void getProfessionInfo() {
        System.out.println("I am Nanny");
    }

}
