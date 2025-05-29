package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class _13_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/TestSonuclari.xlsx";
        String senaryoAdi = "Create Country";
        String testSonuc = "Test Passed";

        writeToExcel(path, senaryoAdi, testSonuc); //excel create
    }

    public static void writeToExcel(String path, String senaryoAdi, String testSonuc) throws IOException {
        File file = new File(path);
        int rowNumber;
        try {
            if (!file.exists()) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sayfa1");
                rowNumber = 0;
                Row newLine = sheet.createRow(rowNumber);
                Cell newCell1 = newLine.createCell(0);
                Cell newCell2 = newLine.createCell(1);
                newCell1.setCellValue(senaryoAdi);
                newCell2.setCellValue(testSonuc);
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                System.out.println("ilk satır yazıldı");
            } else {
                FileInputStream inputStream = new FileInputStream(path);
                Workbook workbook2 = WorkbookFactory.create(inputStream);
                Sheet sheet2 = workbook2.getSheetAt(0);
                int rowNumber2 = sheet2.getPhysicalNumberOfRows();

                Row newLine2 = sheet2.createRow(rowNumber2);
                Cell newCell1 = newLine2.createCell(0);
                Cell newCell2 = newLine2.createCell(1);

                newCell1.setCellValue(senaryoAdi);
                newCell2.setCellValue(testSonuc);
                FileOutputStream outputStream2 = new FileOutputStream(path);
                workbook2.write(outputStream2);
                workbook2.close();
                outputStream2.close();
                System.out.println(rowNumber2 + ". satır yazıldı");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
