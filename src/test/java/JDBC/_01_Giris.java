package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {

        String serverURL ="jdbc:mysql://demo.mersys.io:33906/sakila";
        String userName  ="student";
        String password  ="DEkzTd3#pzPm";


        //1 - Bağlantı bilgileri girilecek
        Connection  baglanti = DriverManager.getConnection(serverURL,userName,password);

        //2 - Sorgu ekranını açtık
        Statement sorguEkrani = baglanti.createStatement();

        //3 - Sorgu ekranına sorgu yazım ve çalıştırdım
        ResultSet sonucTablosuGostergesi = sorguEkrani.executeQuery("select * from customer");

        //4 - Sonuçlar elimizde satır satır ilerleyerek bakalım
        sonucTablosuGostergesi.next();
        String ad = sonucTablosuGostergesi.getNString("first_name");
        String soyad = sonucTablosuGostergesi.getNString("last_name");
        System.out.println("1. satır ad soyad= "+ad+" "+soyad);

        sonucTablosuGostergesi.next();
        String ad2 = sonucTablosuGostergesi.getNString("first_name");
        String soyad2 = sonucTablosuGostergesi.getNString("last_name");
        System.out.println("2. satır ad soyad= "+ad2+" "+soyad2);


        baglanti.close();
    }
}
