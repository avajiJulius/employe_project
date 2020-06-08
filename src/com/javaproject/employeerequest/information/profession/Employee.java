package com.javaproject.employeerequest.information.profession;

import com.javaproject.employeerequest.profession.Profession;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    private Profession profession;
    private double experience;
    private String about;
    private List<PrevEmployer> employers;


    public Employee(Profession profession, double experience,
                    String about, ArrayList<PrevEmployer> employers) {
        this.profession = profession;
        this.experience = experience;
        this.about = about;
        for(PrevEmployer employer : employers)
            this.employers.add(employer);
    }

//    public void addEmployer(PrevEmployer employer) {
//        if (employers == null) {
//            employers = new ArrayList<>();
//        }
//        employers.add(employer);
//    }

    public static  void getProfessionInfo(Profession profession) {
        if (profession.equals(Profession.NANNY))
            Nanny.getProfessionInfo();
        else
            Driver.getProfessionInfo();
    }
}
