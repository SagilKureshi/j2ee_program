package pro_16;

import java.sql.*;
import java.util.Scanner;

public class Pro_16 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root007"
            );

            System.out.println("Connection Successful...");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee Name : ");
            String empnm = sc.next();

            System.out.print("Enter Designation : ");
            String designation = sc.next();

            System.out.print("Enter City : ");
            String city = sc.next();

            System.out.print("Enter Salary : ");
            double salary = sc.nextDouble();

            System.out.print("Enter Department : ");
            String department = sc.next();

            CallableStatement cs = con.prepareCall("{call insertEmp2(?,?,?,?,?)}");

            cs.setString(1, empnm);
            cs.setString(2, designation);
            cs.setString(3, city);
            cs.setDouble(4, salary);
            cs.setString(5, department);

            cs.execute();

            System.out.println("Record Inserted Successfully...");

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}