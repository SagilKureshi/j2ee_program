package Unit_1_Programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_18 {

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

            System.out.print("Enter Designation : ");
            String designation = sc.next();

            CallableStatement cs = con.prepareCall("{call getEmpByDesignation(?)}");

            cs.setString(1, designation);

            ResultSet rs = cs.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Emp No      : " + rs.getInt("empno"));
                System.out.println("Emp Name    : " + rs.getString("empnm"));
                System.out.println("Designation : " + rs.getString("designation"));
                System.out.println("City        : " + rs.getString("city"));
                System.out.println("Salary      : " + rs.getDouble("salary"));
                System.out.println("Department  : " + rs.getString("department"));
                System.out.println("-----------------------------");

            }

            if (!found) {
                System.out.println("No Employee Found.");
            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}