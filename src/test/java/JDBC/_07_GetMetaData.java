package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _07_GetMetaData extends JDBC_Parent{
    @Test
    public void Test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city_id, city, country_id from city");


        rs.next();
        System.out.println("rs.getString(1) = " + rs.getString(1)); // bu satırdaki city id
        System.out.println("rs.getString(city_id) = " + rs.getString("city_id"));


        int intID = rs.getInt("city_id");
        System.out.println("intID = " + intID);

    }


    @Test
    public void Test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");
        //Metafizik = fizik dışındakiler
        //MetaData = Data dışınakiler


        ResultSetMetaData rsmd = rs.getMetaData();

        int kolonSayisi = rsmd.getColumnCount();
        System.out.println("kolonSayisi = " + kolonSayisi);

        for (int i = 1; i <= kolonSayisi; i++) {
            System.out.println(rsmd.getColumnName(i)+" "+ rsmd.getColumnTypeName(i));
        }


        rs.next(); // datanın ilk satırındayım
        System.out.println("1.satır 1. kolon=" + rs.getString(1));
        System.out.println("1.satır 2. kolon=" + rs.getString(2));
        System.out.println("1.satır 3. kolon=" + rs.getString(3));


        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println("1. satır "+i+". Kolon = " + rs.getString(i));
        }


    }
}
