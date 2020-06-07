package com.javaproject.employeerequest.information;

public class DriverInfo extends EmployeeInfo{
    private double salary;
    private double car;

    public DriverInfo(double experience, String about, PrevEmployer employer,
                      double salary, double car) {
        super(Profession.DRIVER, experience, about, employer);
        this.salary = salary;
        this.car = car;
    }
}
