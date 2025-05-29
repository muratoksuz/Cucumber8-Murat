package JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Parent {

    public static Connection baglanti;
    public static Statement sorguEkrani;


    @BeforeClass
    public void beforeClass() throws SQLException {
        String serverURL = "jdbc:mysql://demo.mersys.io:33906/employees";
        String userName = "student";
        String password = "DEkzTd3#pzPm";


        try {
            baglanti = DriverManager.getConnection(serverURL, userName, password);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
            ;
        }


    }

    @AfterClass
    public void afterClass() throws SQLException {
        try {
            baglanti.close();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

    }
}
