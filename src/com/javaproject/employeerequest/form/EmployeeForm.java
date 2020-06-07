package com.javaproject.employeerequest.form;

import com.javaproject.employeerequest.information.ContactInfo;
import com.javaproject.employeerequest.information.EmployeeInfo;
import com.javaproject.employeerequest.information.PersonalInfo;

public class EmployeeForm {
    private EmployeeInfo employeeInfo;
    private PersonalInfo personalInfo;
    private ContactInfo contactInfo;

    public EmployeeForm(EmployeeInfo employeeInfo, PersonalInfo personalInfo, ContactInfo contactInfo) {
        this.employeeInfo = employeeInfo;
        this.personalInfo = personalInfo;
        this.contactInfo = contactInfo;
    }
}
