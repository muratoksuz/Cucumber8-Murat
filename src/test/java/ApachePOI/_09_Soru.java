package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class _09_Soru {
    public static void main(String[] args) throws IOException {


        String path = "src/test/java/ApachePOI/Resource/YeniExcel2.xlsx";
        File file = new File(path);


        int rowNumber;





        if (!file.exists()){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");
            rowNumber = 0;
            Row newLine = sheet.createRow(rowNumber);
            Cell newCell = newLine.createCell(0);
            newCell.setCellValue("Merhaba Dünya");

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("ilk satır yazıldı");


        } else {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook2 = WorkbookFactory.create(inputStream);
            Sheet sheet2 = workbook2.getSheetAt(0);
            int rowNumber2=sheet2.getPhysicalNumberOfRows();

            Row newLine2 = sheet2.createRow(rowNumber2);
            Cell newCell = newLine2.createCell(0);
            newCell.setCellValue("Merhaba Dünya"+rowNumber2++);

            FileOutputStream outputStream2 = new FileOutputStream(path);
            workbook2.write(outputStream2);
            workbook2.close();
            outputStream2.close();
            System.out.println(rowNumber2+". satır yazıldı");
        }

    }
}
