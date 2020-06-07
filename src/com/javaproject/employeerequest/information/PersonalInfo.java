package com.javaproject.employeerequest.information;

import java.time.LocalDate;

public class PersonalInfo {
    private String sex;
    private String fName;
    private String lName;
    private LocalDate birthDay;

    public PersonalInfo(String sex, String fName, String lName, LocalDate birthDay) {
        this.sex = sex;
        this.fName = fName;
        this.lName = lName;
        this.birthDay = birthDay;
    }
}
