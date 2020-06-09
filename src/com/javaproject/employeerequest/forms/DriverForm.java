package com.javaproject.employeerequest.forms;

import com.javaproject.employeerequest.information.DriverInfo;
import com.javaproject.employeerequest.information.EmployeeInfo;


public class DriverForm extends FormBuilder{
    private String carModel;



    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }



    @Override
    public EmployeeInfo buildForm() {
        System.out.println("I am Driver");
        return new DriverInfo();
    }

}
