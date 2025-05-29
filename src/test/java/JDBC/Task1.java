package JDBC;

import Utilities.DBUtility;
import org.testng.annotations.Test;
import java.sql.SQLException;
import java.util.ArrayList;

public class Task1{

    @Test
    public void Task1() throws SQLException {

        String sorgu1 = "select * from employees";

        ArrayList<ArrayList<String>> employees = DBUtility.getListData(sorgu1);
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.get(i).size(); j++) {
                System.out.print(employees.get(i).get(j).toString() + " ");
            }
            System.out.println();
        }

    }
}
