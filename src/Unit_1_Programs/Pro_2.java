package Unit_1_Programs;

import java.sql.*;

public class Pro_2 {

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

            ResultSet rs = st.executeQuery("select * from emp");

            while(rs.next()){
                System.out.println("Emp No      : " + rs.getInt(1));
                System.out.println("Emp Name    : " + rs.getString(2));
                System.out.println("Designation : " + rs.getString(3));
                System.out.println("City        : " + rs.getString(4));
                System.out.println("Salary      : " + rs.getDouble(5));
                System.out.println("Department  : " + rs.getString(6));
                System.out.println("");
            }
            System.out.println("Select Succesful");

            // Close Connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
