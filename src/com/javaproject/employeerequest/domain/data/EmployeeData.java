package com.javaproject.employeerequest.domain.data;

import com.javaproject.employeerequest.domain.data.components.PreviousEmployer;
import com.javaproject.employeerequest.domain.data.components.Profession;
import com.javaproject.employeerequest.domain.data.components.ScheduleStatus;

import java.util.List;

public class EmployeeData {
    private Profession profession;
    private ScheduleStatus scheduleStatus;
    private double experience;
    private List<PreviousEmployer> employers;
    private double salary;

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public ScheduleStatus getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(ScheduleStatus scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public List<PreviousEmployer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<PreviousEmployer> employers) {
        this.employers = employers;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
