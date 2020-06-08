package com.javaproject.employeerequest.profession;


public enum Profession {
    NANNY("nanny"), DRIVER("driver");

    private String profession;

    Profession(String profession) {
        this.profession = profession.toLowerCase();
    }


}
