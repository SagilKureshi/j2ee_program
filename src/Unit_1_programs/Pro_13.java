package Unit_1_programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_13 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    ""
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
                    "UPDATE stud SET firstname=?, lastname=?, course=?, semester=? WHERE rollno=?"
            );

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, course);
            ps.setInt(4, semester);
            ps.setInt(5, rollno);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Record Updated Successfully...");
            } else {
                System.out.println("Record Not Found...");
            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}