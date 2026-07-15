package Unit_1_Programs;

import java.sql.*;

public class Pro_20 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root007"
            );

            System.out.println("Connection Successful...");

            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("Driver Name      : " + dbmd.getDriverName());
            System.out.println("Driver Version   : " + dbmd.getDriverVersion());
            System.out.println("Database Product : " + dbmd.getDatabaseProductName());
            System.out.println("Database Version : " + dbmd.getDatabaseProductVersion());
            System.out.println("User Name        : " + dbmd.getUserName());
            System.out.println("URL              : " + dbmd.getURL());

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}