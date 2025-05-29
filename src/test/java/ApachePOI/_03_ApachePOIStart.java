package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";

        FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);


        Workbook calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);
        
        
        Sheet calismaSayfasi = calismaKitabi.getSheet("Sheet1");
        
        
        Row satir = calismaSayfasi.getRow(0);
        
        
        Cell hucre = satir.getCell(0);

        System.out.println("hucre = " + hucre);
    }
}
