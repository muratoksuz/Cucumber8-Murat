package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _08_Soru extends JDBC_Parent{


    @Test
    public void Test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");
        ResultSetMetaData rsmd = rs.getMetaData();


        // önce kolon isimlerini yazalım
        for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
            System.out.print(rsmd.getColumnName(i)+"\t");
        }

        System.out.println();

       while (rs.next()){
           for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
               System.out.print(rs.getString(i)+"\t");
           }
           System.out.println();
       }

    }
}
