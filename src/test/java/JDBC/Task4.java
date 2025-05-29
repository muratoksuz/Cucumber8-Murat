package JDBC;
import Utilities.DBUtility;
import org.testng.annotations.Test;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import static Utilities.DBUtility.sorguEkrani;

public class Task4 {

    @Test
    public void Task4() throws SQLException {
        String sorgu2 = "select count(gender) as toplam_erkek_personel,sum(salary)/count(salary) as ortalama_maas from (select gender as gender, salary as salary from employees left join salaries on employees.emp_no = salaries.emp_no where gender like 'M') as ort";

        ArrayList<ArrayList<String>> line = DBUtility.getListData(sorgu2);

        for (int i = 0; i < line.size(); i++) {
            for (int j = 0; j < line.get(i).size(); j++) {
                System.out.print(line.get(i).get(j).toString() + " ");
            }
            System.out.println();
        }
    }


}
