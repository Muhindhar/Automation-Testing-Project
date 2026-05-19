package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static String getCellData(String filePath,
                                     String sheetName,
                                     int rowNum,
                                     int colNum) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new RuntimeException(
                "Sheet not found: " + sheetName
            );
        }

        Row row = sheet.getRow(rowNum);

        if (row == null) {
            workbook.close();
            throw new RuntimeException(
                "Row not found: " + rowNum
            );
        }

        Cell cell = row.getCell(colNum);

        if (cell == null) {
            workbook.close();
            return "";
        }

        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(cell);

        workbook.close();
        return value;
    }
}