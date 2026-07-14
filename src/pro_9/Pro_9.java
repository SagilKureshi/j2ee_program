package pro_9;

import java.sql.*;

public class Pro_9 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root007"
            );


            System.out.println("Connection Successful...");
            System.out.println("Sorted Employee by name :-");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM emp ORDER BY empnm");

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