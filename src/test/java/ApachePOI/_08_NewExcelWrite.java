package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String [] args) throws IOException {
        // hafızada bir workbook oluştur
        // onun içine yine hafızadan bir sheet oluştur
        //yazma işlemlerini yap
        // kaydet

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet =  workbook.createSheet("Sayfa1");


        // kalan kısım aynı
        Row newLine = sheet.createRow(0);
        Cell newCell = newLine.createCell(0);
        newCell.setCellValue("Merhaba Yeni Excel");

        // ctrl+S
        String path = "src/test/java/ApachePOI/Resource/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem tamam");
    }
}
