package com.javaproject.employeerequest.request;

import com.javaproject.employeerequest.profession.Profession;

public interface Request {
    double payAssign();
    void professionAssign(Profession profession);
    double birthAssign();
    double experienceAssign();
    String fNameAssign();
    String lNameAssign();
    String mailAssign();


}
