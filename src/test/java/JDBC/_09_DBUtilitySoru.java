package JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.*;
import java.util.ArrayList;

public class _09_DBUtilitySoru {
    public static Connection baglanti;
    public static Statement sorguEkrani;


    public static void main(String[] args) {
        // Gönderilen sorgu sonucundaki tüm datayı bir List olarak döndüren metodu yazınız.

        String sorguSql="select first_name, last_name from customer";

        ArrayList< ArrayList<String> > donenData= getListData(sorguSql);

        for(ArrayList<String> satir : donenData) {
            for (String kolonItem : satir)
                System.out.print(kolonItem + "\t");

            System.out.println();
        }

    }

    public static ArrayList< ArrayList<String> > getListData(String sorgu){
        ArrayList< ArrayList<String> > donecekTablo=new ArrayList<>();
        DBConnectionOpen();

        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData();
            // gelen sorguyu alıp , DB den çalıştırıp, donecek tabloya atınız.
            while (rs.next()) {
                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    satir.add(rs.getString(i));
                }

                donecekTablo.add(satir);
            }
        }
        catch (Exception ex)
        {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBConnectionClose();
        return  donecekTablo;
    }



    public static void DBConnectionOpen() {
        String serverUrl = "jdbc:mysql://demo.mersys.io:33906/sakila";  //port,dbname,mySql
        String username = "student";
        String password = "DEkzTd3#pzPm";

        try {
            baglanti = DriverManager.getConnection(serverUrl, username, password);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose() {
        try {
            baglanti.close();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }
}
