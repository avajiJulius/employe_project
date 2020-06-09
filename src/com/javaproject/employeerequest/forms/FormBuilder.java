package com.javaproject.employeerequest.forms;


import com.javaproject.employeerequest.information.EmployeeInfo;
import com.javaproject.employeerequest.information.PreviousEmployer;

import java.time.LocalDate;
import java.util.List;

public abstract class FormBuilder {
    private String firstName;
    private String lastName;
    private String sex;
    private LocalDate birthDay;
    private double experience;
    private String about;
    private String email;
    private List<PreviousEmployer> previousEmployers;


    public FormBuilder(String firstName, String lastName, String sex, LocalDate birthDay,
                       double experience, String about, String email, List<PreviousEmployer> previousEmployers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDay = birthDay;
        this.experience = experience;
        this.about = about;
        this.email = email;
        this.previousEmployers = previousEmployers;
    }

    public FormBuilder() {
    }

    public abstract EmployeeInfo buildForm();
}
