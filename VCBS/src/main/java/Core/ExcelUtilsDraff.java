package Core;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtilsDraff {
    static Workbook book;
    static Sheet sheet;


    public static String[][] getTestData(String sheetName, String path) throws InvalidFormatException {
        FileInputStream file = null;

        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e){
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum()-1;
        String[][] dataTest = new String[lastRowNum][lastCellNum];
        int dataTestCurrentRow = 0;

        for (int i = 1; i <= lastRowNum; i++) {
            Cell cell = sheet.getRow(i).getCell(0);
            if (cell !=null){
                String firstCellStr = cell.getStringCellValue().trim();
                if (firstCellStr != null && !firstCellStr.isEmpty()) {
                    for (int j = 1; j <= lastCellNum; j++) {
                        Cell currentCell = sheet.getRow(i).getCell(j);
                        if (currentCell != null) {
                            switch (currentCell.getCellType()) {

                                case NUMERIC:
                                    dataTest[dataTestCurrentRow][j-1] = String.valueOf(currentCell.getNumericCellValue());

                                    break;
                                case STRING:
                                    dataTest[dataTestCurrentRow][j-1] =currentCell.getStringCellValue();
                                    break;


                                // CELL_TYPE_FORMULA will never occur

                            }
                        }
                    }
                    dataTestCurrentRow++;
                } else break;
            }

        }
        String[][] dataClone = new String[dataTestCurrentRow-1][lastCellNum];
        for (int i = 0; i<dataTestCurrentRow-1 ; i++)
            for (int j = 0; i<lastCellNum ; j++)
                dataClone[i][j] = dataTest[i][j];
        return dataClone;
//        sheet = book.getSheet(sheetName);
//
//        String[][] data = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        for (int i = 1; i < sheet.getLastRowNum(); i++){
//            for (int j = 0; j <= sheet.getRow(0).getLastCellNum();j++){
//                Cell cell = sheet.getRow(i).getCell(j);
//                String value = cell.getStringCellValue();
//                data[i][j] = value;
//            }
//        }
//        return data;

    }
}
