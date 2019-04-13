import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel {
    public static < FileNotFoundException extends Throwable >   void main(String[] args) throws FileNotFoundException {
        System.out.println("Excel with numbers only");
    openingExcelWithNumbers();
    }
    static void openingExcelWithNumbers() {
        try {

            FileInputStream file = new FileInputStream(new File("/home/endriu/IdeaProjects/Excel/src/matma.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator< Row > rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator< Cell > cellIterator = row.cellIterator();
//                byte a=1;
                while(cellIterator.hasNext()) {
//                    System.out.print(a+"|");
                    Cell cell = cellIterator.next();
//                    a++;
                    switch (cell.getCellType()) {
//                        System.out.print(a+"|");
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue()+"|");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue()+"|");
                            break;
                        case FORMULA:
                            System.out.print(cell.getNumericCellValue()+" ; "+cell.getCellFormula()+"|");
                            break;
                        case BLANK:
                            System.out.printf(cell.getRichStringCellValue()+"|");
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
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
