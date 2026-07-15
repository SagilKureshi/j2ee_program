package Unit_1_Programs;

import java.sql.*;

public class Pro_3To6_8 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root007"
            );

            System.out.println("Connection Successful...");

            Statement st = con.createStatement();

            // (3) Salary > 50000
            System.out.println("\nEmployees whose salary is greater than 50000");
            ResultSet rs = st.executeQuery("SELECT * FROM emp WHERE salary > 50000");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getDouble(5) + "\t"
                        + rs.getString(6));
            }

            // (4) City = Rajkot
            System.out.println("\nEmployees from Rajkot");
            rs = st.executeQuery("SELECT * FROM emp WHERE city='Rajkot'");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getDouble(5) + "\t"
                        + rs.getString(6));
            }

            // (5) Name starts with A
            System.out.println("\nEmployees whose name starts with 'A'");
            rs = st.executeQuery("SELECT * FROM emp WHERE empnm LIKE 'A%'");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getDouble(5) + "\t"
                        + rs.getString(6));
            }

            // (6) Designation = Manager
            System.out.println("\nEmployees whose designation is Manager");
            rs = st.executeQuery("SELECT * FROM emp WHERE designation='Manager'");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getDouble(5) + "\t"
                        + rs.getString(6));
            }

            // (8) Highest Salary
            System.out.println("\nEmployee with Highest Salary");
            rs = st.executeQuery("SELECT * FROM emp WHERE salary=(SELECT MAX(salary) FROM emp)");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4) + "\t"
                        + rs.getDouble(5) + "\t"
                        + rs.getString(6));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}