package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Soru_2 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        String path = "src/test/java/ApachePOI/Resource/CarpimTablosu2.xlsx";

        Row okumaSatiri = null;
        int satirSayisi1 = 0;
        int satirSayisi2 = 0;
        int ilkSayi =1;

        for (int i = 0; i < 10; i++) {
            Row newLine2 = sheet.createRow(satirSayisi2++);
        }

        for (int i = 1; i < 60; i+=6) {
            for (int j = 1; j < 10; j++) {
                    okumaSatiri = sheet.getRow(satirSayisi1++);
                    Cell cell1 = okumaSatiri.createCell((i - 1));cell1.setCellValue(ilkSayi);
                    Cell cell2 = okumaSatiri.createCell(i);cell2.setCellValue("x");
                    Cell cell3 = okumaSatiri.createCell((i + 1));cell3.setCellValue(j);
                    Cell cell4 = okumaSatiri.createCell((i + 2));cell4.setCellValue("=");
                    Cell cell5 = okumaSatiri.createCell((i + 3));cell5.setCellValue((ilkSayi * j));
                if (satirSayisi1 >8){
                    satirSayisi1 =0;
                }
            }
            Cell cell6 = okumaSatiri.createCell((i + 4));
            cell6.setCellValue((""));
            ilkSayi++;
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
