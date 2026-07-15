package Unit_1_programs;

import java.sql.*;

public class Pro_7 {

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

            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM emp");

            if (rs.next()) {
                System.out.println("Total Employees : " + rs.getInt(1));
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}