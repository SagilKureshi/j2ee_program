package Unit_1_programs;

import java.sql.*;

public class Pro_1 {

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

            st.executeUpdate("INSERT INTO emp VALUES(NULL,'Amit','Manager','Rajkot',65000,'HR')");

            st.executeUpdate("INSERT INTO emp VALUES(NULL,'Anjali','Developer','Ahmedabad',48000,'IT')");

            st.executeUpdate("INSERT INTO emp VALUES(NULL,'Rahul','Manager','Surat',72000,'Admin')");

            st.executeUpdate("INSERT INTO emp VALUES(NULL,'Neha','Accountant','Rajkot',45000,'Accounts')");

            st.executeUpdate("INSERT INTO emp VALUES(NULL,'Arjun','Developer','Rajkot',55000,'IT')");

            System.out.println("Insert Successful...");

            // Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
