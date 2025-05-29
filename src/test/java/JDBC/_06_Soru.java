package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Soru extends JDBC_Parent{
    // city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız


    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city from city");
           //1.yol
        int a=01;
        while (rs.absolute(a)){
            System.out.println(rs.getString("city"));
            a++;
        }


        System.out.println("===============================");

          //2.yol

        rs.last();
        int sonSatirNo = rs.getRow();
        for (int i = 0; i < sonSatirNo; i++) {
            rs.absolute(i);
            System.out.println(rs.getString("city"));
        }

    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        //1.yol
        while (rs.relative(1)){
            System.out.println(rs.getString("city"));
        }

        System.out.println("==========");
        //2.yol

        rs.last();
        int sonSatirNo = rs.getRow();

        rs.first();
        for (int i = 1; i < sonSatirNo+1; i++) {
            rs.relative(1);
            System.out.println(rs.getString("city"));
        }
    }


}
