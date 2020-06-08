package com.javaproject.employeerequest.profession;

import com.javaproject.employeerequest.information.EmployeeInfo;

public enum Profession {
    NANNY("nanny"), DRIVER("driver");

    private String profession;
    private EmployeeInfo info;

    Profession(String profession) {
        this.profession = profession.toLowerCase();
    }


}
