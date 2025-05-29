package JDBC;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;



public class _05_FirstLastGetRowgetType extends JDBC_Parent{

    @Test
    public void Test1() throws SQLException {
        ResultSet rs=sorguEkrani.executeQuery("select city from city");

        rs.last();  // son satıra gider;
        System.out.println("rs.getString(1) = " + rs.getString(1)); // aşağıdaki ile aynı
        System.out.println("rs.getString(city) = " + rs.getString("city")); // yukarıdaki ile aynı

        rs.first();  // ilk satıra gittim
        System.out.println("rs.getString(1) = " + rs.getString(1));

        rs.last();  // son satıra gittim tekrar
        int kacinciSatirdayim=rs.getRow();
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim);
    }

}
