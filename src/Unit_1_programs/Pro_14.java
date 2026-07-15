package Unit_1_programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_14 {

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


            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM stud WHERE rollno=?"
            );

            ps.setInt(1, rollno);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Record Deleted Successfully...");
            } else {
                System.out.println("Record Not Found...");
            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}