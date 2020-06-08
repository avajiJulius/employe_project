package com.javaproject.employeerequest.information.person;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class Person {
    private String sex;
    private String fName;
    private String lName;
    private LocalDate birthDay;

    public Person(String sex, String fName, String lName, LocalDate birthDay) {
        this.sex = sex;
        this.fName = fName;
        this.lName = lName;
        this.birthDay = birthDay;
    }

//    public Map<String,? extends PersonalInfo> getPersonInfo() {
//
//    }
}
