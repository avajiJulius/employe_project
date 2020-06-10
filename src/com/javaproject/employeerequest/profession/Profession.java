package com.javaproject.employeerequest.profession;

public class Profession {
    private int profId;
    private String profession;

    public Profession(int profId, String profession) {
        this.profId = profId;
        this.profession = profession;
    }

    public Profession(String string) {
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }
}
