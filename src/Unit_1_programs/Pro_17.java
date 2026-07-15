package Unit_1_programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_17 {

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

            System.out.print("Enter Employee Number : ");
            int empno = sc.nextInt();

            CallableStatement cs = con.prepareCall("{call getDesignation(?,?)}");

            cs.setInt(1, empno);

            cs.registerOutParameter(2, Types.VARCHAR);

            cs.execute();

            System.out.println("Designation : " + cs.getString(2));

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }
    }
}