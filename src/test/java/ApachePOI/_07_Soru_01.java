package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_Soru_01 {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        int yeniSatirNo = 0;


        for (int i = 0; i < 10; i++) {
            Row yeniSatir = sheet.createRow(yeniSatirNo++);

            Cell hucre1 = yeniSatir.createCell(0); hucre1.setCellValue(1);
            Cell hucre2 = yeniSatir.createCell(1); hucre2.setCellValue("x");
            Cell hucre3 = yeniSatir.createCell(2); hucre3.setCellValue(i);
            Cell hucre4 = yeniSatir.createCell(3); hucre4.setCellValue("=");
            Cell hucre5 = yeniSatir.createCell(4); hucre5.setCellValue((1*i));
        }



        inputStream.close();
        FileOutputStream outputStream =new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();

    }
}
