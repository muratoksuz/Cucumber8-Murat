package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetSpecificData_Method {
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);
        System.out.print("Aranacak kelimeyi giriniz=");
        String searchWord = read.nextLine();

        String result = bringFromExcel(searchWord);
        System.out.println("returned data = " + result);
    }

    public static String bringFromExcel(String searchWord1) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/LoginData.xlsx";
        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(dosyaOkumaBaglantisi);
        Sheet sheet = workbook.getSheetAt(0);
        String returned = "";

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(searchWord1)){
                for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    returned += sheet.getRow(i).getCell(j)+" ";
                }
            }
        }

        return returned;
    }
}
