package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Soru_2 extends JDBC_Parent{

    @Test
    public void test() throws SQLException {
        ResultSet stg = sorguEkrani.executeQuery("select * from city");

        while (stg.next()){
            System.out.println(stg.getNString("city"));
        }
    }
}
