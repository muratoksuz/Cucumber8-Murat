package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] rgs) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                System.out.print(sheet.getRow(i).getCell(j) + " ");
            }
            System.out.println();
        }


    }
}
