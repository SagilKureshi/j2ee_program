package Unit_1_programs;

import java.sql.*;
import java.util.Scanner;

public class Pro_19 {

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

            System.out.println("\n===== PRODUCT CRUD MENU =====");
            System.out.println("1. Insert Product");
            System.out.println("2. Display Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");

            System.out.print("\nEnter Your Choice : ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:

                    System.out.print("Enter Product ID : ");
                    int pid = sc.nextInt();

                    System.out.print("Enter Product Name : ");
                    String pname = sc.next();

                    System.out.print("Enter Price : ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity : ");
                    int qty = sc.nextInt();

                    PreparedStatement ps1 = con.prepareStatement(
                            "INSERT INTO product VALUES(?,?,?,?)");

                    ps1.setInt(1, pid);
                    ps1.setString(2, pname);
                    ps1.setDouble(3, price);
                    ps1.setInt(4, qty);

                    ps1.executeUpdate();

                    System.out.println("Product Inserted Successfully...");
                    break;

                case 2:

                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery("SELECT * FROM product");

                    while (rs.next()) {

                        System.out.println("---------------------------");
                        System.out.println("Product ID   : " + rs.getInt(1));
                        System.out.println("Product Name : " + rs.getString(2));
                        System.out.println("Price        : " + rs.getDouble(3));
                        System.out.println("Quantity     : " + rs.getInt(4));

                    }

                    break;

                case 3:

                    System.out.print("Enter Product ID : ");
                    pid = sc.nextInt();

                    System.out.print("Enter New Product Name : ");
                    pname = sc.next();

                    System.out.print("Enter New Price : ");
                    price = sc.nextDouble();

                    System.out.print("Enter New Quantity : ");
                    qty = sc.nextInt();

                    PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE product SET productname=?, price=?, quantity=? WHERE pid=?");

                    ps2.setString(1, pname);
                    ps2.setDouble(2, price);
                    ps2.setInt(3, qty);
                    ps2.setInt(4, pid);

                    int i = ps2.executeUpdate();

                    if (i > 0) {
                        System.out.println("Product Updated Successfully...");
                    } else {
                        System.out.println("Product Not Found...");
                    }

                    break;

                case 4:

                    System.out.print("Enter Product ID : ");
                    pid = sc.nextInt();

                    PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM product WHERE pid=?");

                    ps3.setInt(1, pid);

                    i = ps3.executeUpdate();

                    if (i > 0) {
                        System.out.println("Product Deleted Successfully...");
                    } else {
                        System.out.println("Product Not Found...");
                    }

                    break;

                default:

                    System.out.println("Invalid Choice...");

            }

            con.close();

        } catch (Exception e) {

            System.out.println("Error : " + e);

        }

    }
}