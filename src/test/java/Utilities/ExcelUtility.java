package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ExcelUtility {
    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        Sheet sheet = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // tüm satırlardaki

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {  // istenen sütun sayısı kadar
                satir.add(sheet.getRow(i).getCell(j).toString());  // bu döngü ile tüm satır okundu
            }

            tablo.add(satir);
        }

        return tablo;
    }

    public static void writeToExcel(String path, String senaryoAdi, String testSonuc) throws IOException {
        File dosya=new File(path);
        String testDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_YYYY_HH_mm"));

        try {
            if (!dosya.exists()) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("TestSonuc");

                Row row = sheet.createRow(0);
                Cell cell1 = row.createCell(0);cell1.setCellValue(senaryoAdi);
                Cell cell2 = row.createCell(1);cell2.setCellValue(testSonuc);
                Cell cell3 = row.createCell(2);cell3.setCellValue(testDateTime);

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                System.out.println("Dosya oluşturuldu.");
            }
            else
            {
                FileInputStream inputStream=new FileInputStream(path);
                Workbook workbook= WorkbookFactory.create(inputStream);
                Sheet sheet= workbook.getSheetAt(0);

                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                Cell cell1 = row.createCell(0);cell1.setCellValue(senaryoAdi);
                Cell cell2 = row.createCell(1);cell2.setCellValue(testSonuc);
                Cell cell3 = row.createCell(2);cell3.setCellValue(testDateTime);

                inputStream.close();

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                System.out.println("Ekleme yapıldı");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
