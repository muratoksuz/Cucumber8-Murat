package JDBC;

import com.mysql.cj.protocol.Resultset;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_Soru {
    // city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız
    @Test
    public void test1() throws SQLException {
        String serverURL = "jdbc:mysql://demo.mersys.io:33906/sakila";
        String userName = "student";
        String password = "DEkzTd3#pzPm";


        Connection baglanti = DriverManager.getConnection(serverURL, userName, password);
        Statement sorguEkrani = baglanti.createStatement();
        ResultSet sonucTablosuGostergesi = sorguEkrani.executeQuery("select * from city");

        while (sonucTablosuGostergesi.next()) {
            System.out.println(sonucTablosuGostergesi.getNString("city"));
        }

        baglanti.close();

    }
}
