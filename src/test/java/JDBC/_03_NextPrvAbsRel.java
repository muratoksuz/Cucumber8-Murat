package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrvAbsRel extends JDBC_Parent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from language");

        rs.next();
        System.out.println("1.Satır= "+rs.getNString("name"));

        rs.next();
        System.out.println("2.Satır= "+rs.getNString("name"));

        rs.previous();

    }

    @Test
    public void Test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from film");

        rs.absolute(10);
        System.out.println("10.satır= "+ rs.getNString("title"));

        rs.absolute(5);
        System.out.println("5.satır= "+ rs.getNString("title"));

        rs.relative(5);
        System.out.println("10.satır= "+ rs.getNString("title"));



    }
}
