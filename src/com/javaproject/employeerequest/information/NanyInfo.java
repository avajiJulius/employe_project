package com.javaproject.employeerequest.information;

import java.util.ArrayList;

public class NanyInfo extends EmployeeInfo{
    private double hourlyPay;
    private ArrayList<Integer> childrenAge;
//    Необходимо будет исправить возравта детей

    public NanyInfo(double experience, String about,
                    PrevEmployer employer, double hourlyPay, ArrayList<Integer> childrenAge) {
        super(Profession.NANY, experience, about, employer);
        this.hourlyPay = hourlyPay;
        this.childrenAge = childrenAge;
    }
}
