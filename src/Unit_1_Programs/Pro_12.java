package Unit_1_Programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_12 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "root007"
            );

            System.out.println("Connection Successful...");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Roll No : ");
            int rollno = sc.nextInt();

            System.out.print("Enter First Name : ");
            String firstname = sc.next();

            System.out.print("Enter Last Name : ");
            String lastname = sc.next();

            System.out.print("Enter Course : ");
            String course = sc.next();

            System.out.print("Enter Semester : ");
            int semester = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO stud VALUES(?,?,?,?,?)"
            );

            ps.setInt(1, rollno);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, course);
            ps.setInt(5, semester);

            ps.executeUpdate();

            System.out.println("Record Inserted Successfully...");

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}