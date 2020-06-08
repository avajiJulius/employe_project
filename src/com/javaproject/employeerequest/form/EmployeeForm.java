package com.javaproject.employeerequest.form;

import com.javaproject.employeerequest.information.contact.Contact;
import com.javaproject.employeerequest.information.profession.Employee;
import com.javaproject.employeerequest.information.person.Person;


public class EmployeeForm {
    private Employee employee;
    private Person person;
    private Contact contact;

    public EmployeeForm(Employee employee, Person person, Contact contact) {
        this.employee = employee;
        this.person = person;
        this.contact = contact;
    }
}
