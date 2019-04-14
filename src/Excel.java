import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel implements Names {
    private double[] numericalData= new double[100];
    private String[] stringData = new String[100];
    private int a,b,c;
    private static Excel ob = new Excel();
    public Excel(double[] numericalData, String[] stringData, int a, int b, int c) {
        this.numericalData = numericalData;
        this.stringData = stringData;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private Excel() {
        super();
    }

    public static < FileNotFoundException extends Throwable >   void main(String[] args) throws FileNotFoundException {
        System.out.println("Excel with numbers only");

        ob.openingExcelWithNumbers(ob.numericalData, ob.stringData, ob.a, ob.b);
        Names.lookingForNames(ob.numericalData, ob.stringData, ob.c);
//        ob.lookingForNames(ob.numericalData,ob.stringData);
    }
    private void openingExcelWithNumbers(double[] numericalData, String[] stringData, int a, int b) {
        try {

            FileInputStream file = new FileInputStream(new File("/home/endriu/IdeaProjects/Excel/src/matma.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator< Row > rowIterator = sheet.iterator();
            a=0;b=0;
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator< Cell > cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
//                    System.out.print(a+"|");
                    Cell cell = cellIterator.next();
//                    a++;
//                    b=(int) cell+row;
                    switch (cell.getCellType()) {
//                        System.out.print(a+"|");
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue()+"|");
                            numericalData[a] = cell.getNumericCellValue();
                            a++;
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue()+"|");
                            stringData[b] = cell.getStringCellValue();
                            b++;
                            break;
                        case FORMULA:
                            System.out.print(cell.getNumericCellValue()+" ; "+cell.getCellFormula()+"|");
                            numericalData[a] = cell.getNumericCellValue();
                            a++;
                            break;
                        case BLANK:
                            System.out.print(cell.getRichStringCellValue()+"|");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue()+"|");
                            break;
                        case ERROR:
                            System.out.print(cell.getErrorCellValue()+"|");
                            break;
                    }
                    /*switch (cell.getCellType()) {
                        case FORMULA:
                            System.out.println(cell.getCellFormula()+"|");
                            break;
                    }*/
                }
                System.out.println();
                b=a;
            }

            System.out.println("Dane uzyskane z tablicy dane[] (łącznie "+a+" rekordów");
            for (int i=0;i<a;i++) {
                        System.out.print(numericalData[i]+"|");

                    }
            file.close();
            c=a;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*private void lookingForNames(double[] numericalData, String[] stringData) {
        System.out.println();
        System.out.println("Wybieram dane dot jednej osoby(łącznie rekordów "+a+" w pliku");
        Scanner input = new Scanner(System.in);
        String choice= input.nextLine();
        for (int i=0;i<a;i++) {
            if (choice.equals(stringData[i])) {
                System.out.println("Dla imienia: " + choice + "| znaleziono: |" + numericalData[i] + "|"
                        + numericalData[i + 1] + "|" + numericalData[i + 2]);
            }
//            break;

        }
    }*/
}
