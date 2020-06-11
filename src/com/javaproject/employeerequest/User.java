package com.javaproject.employeerequest;


import com.javaproject.employeerequest.dao.DictionaryDaoImpl;
import com.javaproject.employeerequest.domain.EmployeeForm;
import com.javaproject.employeerequest.domain.data.components.City;

import java.util.List;

public class User {
    private static EmployeeForm form;

    public static void main(String[] args) throws Exception {

        List<City> citiesList = new DictionaryDaoImpl().findCity("burg");
        for (City city : citiesList)
            System.out.println(city.getCityName());
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
