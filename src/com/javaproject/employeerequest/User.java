package com.javaproject.employeerequest;


import com.javaproject.employeerequest.forms.DriverForm;
import com.javaproject.employeerequest.forms.FormBuilder;
import com.javaproject.employeerequest.forms.NannyForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class User {
    private static FormBuilder form;

    public static void main(String[] args){
//        Class.forName("org.postgresql.Driver");
//        Connection connection = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5432/js_employee",
//                "postgres", "developer");
//
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM p_info");
//        while(rs.next())
//            System.out.println(rs.getString(1) + " : " + rs.getString(2)
//                    + " : " + rs.getString(3) + " : " + rs.getString(4) + " : "
//                    + rs.getDate(5));


        configure();
        getForm();

    }


    static void configure() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter profession: ");
        String profession = in.next().toLowerCase();
        if (profession.equals("nanny"))
            form = new NannyForm();
        else
            form = new DriverForm();
    }

    static void getForm() {
        form.buildForm();
    }
}
