package pro_11;

import java.sql.*;
import java.util.Scanner;

public class Pro_11 {

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

            System.out.print("Enter Department Name : ");
            String deptName = sc.next();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM emp WHERE department='" + deptName + "'");


            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Emp Name    : " + rs.getString("empnm"));
                System.out.println("Designation : " + rs.getString("designation"));
                System.out.println("---------------------------");
            }

            if (!found) {
                System.out.println("Employee Record Not Found for department : " + deptName);
            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}