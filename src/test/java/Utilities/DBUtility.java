package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

    public static Connection baglanti;
    public static Statement sorguEkrani;

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
        String serverUrl = "jdbc:mysql://demo.mersys.io:33906/employees";  //port,dbname,mySql
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
