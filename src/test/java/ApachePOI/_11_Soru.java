package ApachePOI;

import java.util.ArrayList;

public class _11_Soru {
    public static void main(String[] arg){
        String path = "src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";
        String sheetName = "testCitizen";
        int columnNumber = 4;

        ArrayList<ArrayList<String>> result = getData(path, sheetName, columnNumber);

        System.out.println("Sonuç: "+result);
    }
    public static ArrayList<ArrayList<String>> getData(String pathWay, String sheetName, int column){


        return null;
    }
}
