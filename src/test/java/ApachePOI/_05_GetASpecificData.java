package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    public static void main(String[] arg) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            System.out.println((i+1)+"-) "+row.getCell(0));
        }
        System.out.println("Lütfen karşılığını istediğiniz başlığı giriniz= ");
        Scanner read = new Scanner(System.in);
        String answer = read.nextLine();
        String returned ="";

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(answer)){
                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    returned += sheet.getRow(i).getCell(j)+" ";
                }
            }
        }

        System.out.println("returned data = " + returned);
    }
}
