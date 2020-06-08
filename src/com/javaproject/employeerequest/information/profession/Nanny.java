package com.javaproject.employeerequest.information.profession;

import com.javaproject.employeerequest.profession.Profession;

import java.util.ArrayList;
import java.util.List;

public class Nanny extends Employee {
    private double hourlyPay;
    private List<Integer> childrenAges;


    public Nanny(double experience, String about,
                 ArrayList<PrevEmployer> employers, double hourlyPay, ArrayList<Integer> childrenAges) {
        super(Profession.NANNY, experience, about, employers);
        this.hourlyPay = hourlyPay;
        for(Integer childAge : childrenAges)
            this.childrenAges.add(childAge);
    }

//    public void addChildAge(Integer age) {
//        if (childrenAges == null)
//            childrenAges = new ArrayList<>();
//        childrenAges.add(age)
//    }

    public static void getProfessionInfo() {
        System.out.println("I am Nanny");
    }

}
