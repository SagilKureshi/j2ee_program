package Unit_1_programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_10 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    ""
            );

            System.out.println("Connection Successful...");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Employee Number : ");
            int empno = sc.nextInt();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM emp WHERE empno=" + empno);

            if (rs.next()) {

                System.out.println("Emp No      : " + rs.getInt(1));
                System.out.println("Emp Name    : " + rs.getString(2));
                System.out.println("Designation : " + rs.getString(3));
                System.out.println("City        : " + rs.getString(4));
                System.out.println("Salary      : " + rs.getDouble(5));
                System.out.println("Department  : " + rs.getString(6));

            } else {

                System.out.println("Employee Record Not Found for empno : " +empno);

            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}