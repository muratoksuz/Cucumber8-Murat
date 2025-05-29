package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        int satirMiktari = sheet.getPhysicalNumberOfRows();
        Row yeniSatir = sheet.createRow(satirMiktari);
        Cell yeniHucre = yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba dünya");

        // okuma modunu kapaat
        inputStream.close();

        // dosya kaydet

        FileOutputStream outputStream = new FileOutputStream(path);// yazma modunu aç
        workbook.write(outputStream); // hafızaaki workbook u kapat
        outputStream.close();


        System.out.println("işlem tamam");

    }
}
