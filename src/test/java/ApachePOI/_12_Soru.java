package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class _12_Soru {
    public static void main(String[] args) throws IOException {

        String path ="src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi =4;

        ArrayList<ArrayList<String>> result = getData(path, sheetName, sutunSayisi);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j).toString()+" ");
            }
            System.out.println();
        }


    }

    public static ArrayList<ArrayList<String>> getData (String path, String sheetName, int sutunSayisi) throws IOException {

        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet sheet = workbook.getSheet(sheetName);
        ArrayList <ArrayList<String>> returned= new ArrayList<ArrayList<String>>();

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> innerList = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {
                innerList.add(sheet.getRow(i).getCell(j).toString());
            }
           returned.add(innerList);
        }

        return returned;
    }
}
