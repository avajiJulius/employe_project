package com.javaproject.employeerequest.request;

import com.javaproject.employeerequest.profession.Profession;

public class DriverRequest implements Request{

    @Override
    public String mailAssign() {
        return null;
    }

    @Override
    public String lNameAssign() {
        return null;
    }

    @Override
    public String fNameAssign() {
        return null;
    }

    @Override
    public double experienceAssign() {
        return 0;
    }

    @Override
    public double birthAssign() {
        return 0;
    }

    @Override
    public void professionAssign(Profession profession) {

    }

    @Override
    public double payAssign() {
        return 0;
    }
}
