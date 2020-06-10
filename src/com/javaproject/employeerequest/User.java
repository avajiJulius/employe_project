package com.javaproject.employeerequest;


import com.javaproject.employeerequest.dao.DictionaryDaoImpl;
import com.javaproject.employeerequest.forms.FormBuilder;
import com.javaproject.employeerequest.profession.Profession;

import java.util.List;

public class User {
    private static FormBuilder form;

    public static void main(String[] args) throws Exception {

        List<Profession> d = new DictionaryDaoImpl().findProfession("d");
        for (Profession s : d)
            System.out.println(s.getProfession());
//        configure();
//        getForm();

    }


//    static void configure() {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter profession: ");
//        String profession = in.next().toLowerCase();
//        if (profession.equals("nanny"))
//            form = new NannyForm();
//        else
//            form = new DriverForm();
//    }
//
//    static void getForm() {
//        form.buildForm();
//    }
}
