package com.javaproject.employeerequest;

import com.javaproject.employeerequest.information.profession.Employee;
import com.javaproject.employeerequest.profession.Profession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class User {
    public static void main(String[] args) throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/js_employee",
                "postgres", "developer");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM p_info");
        while(rs.next())
            System.out.println(rs.getString(1) + " : " + rs.getString(2)
                    + " : " + rs.getString(3) + " : " + rs.getString(4) + " : "
                    + rs.getDate(5));


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your profession: ");
//        String p = scanner.next().toUpperCase();
//        Profession profession = Profession.valueOf(p);
//        System.out.println(profession);
//
//        Employee.getProfessionInfo(profession);


    }
}
