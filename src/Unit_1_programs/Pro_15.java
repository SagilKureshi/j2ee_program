package Unit_1_programs;

import java.sql.*;

public class Pro_15 {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    ""
            );

            System.out.println("Connection Successful...");

            CallableStatement cs = con.prepareCall("{call insertEmp()}");

            cs.execute();

            System.out.println("Record Inserted Successfully...");

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}