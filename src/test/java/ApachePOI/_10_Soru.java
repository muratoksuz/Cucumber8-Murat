package ApachePOI;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO :
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 * a) alt alta   b) yan yana
 */


public class _10_Soru {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        String path = "src/test/java/ApachePOI/Resource/CarpimTablosu.xlsx";

        int rowNumber=0;

        for (int i = 1; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                Row newLine = sheet.createRow(rowNumber++);
                Cell hucre1 = newLine.createCell(0); hucre1.setCellValue(i);
                Cell hucre2 = newLine.createCell(1); hucre2.setCellValue("x");
                Cell hucre3 = newLine.createCell(2); hucre3.setCellValue(j);
                Cell hucre4 = newLine.createCell(3); hucre4.setCellValue("=");
                Cell hucre5 = newLine.createCell(4); hucre5.setCellValue((i*j));

            }
            Row newLine = sheet.createRow(rowNumber++);
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");
    }
}
