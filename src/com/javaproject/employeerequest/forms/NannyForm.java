package com.javaproject.employeerequest.forms;

import com.javaproject.employeerequest.information.EmployeeInfo;
import com.javaproject.employeerequest.information.NannyInfo;


import java.util.List;

public class NannyForm extends FormBuilder{
    private double hourlyPay;
    private List<Integer> childrenAges;



    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public List<Integer> getChildrenAges() {
        return childrenAges;
    }

    public void setChildrenAges(List<Integer> childrenAges) {
        this.childrenAges = childrenAges;
    }



    @Override
    public EmployeeInfo buildForm() {
        System.out.println("I am Nanny");
        return new NannyInfo();
    }

}
