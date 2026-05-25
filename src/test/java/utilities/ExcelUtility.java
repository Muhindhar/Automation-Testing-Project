package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    
    public static Map<String, String> getTestDataByTestCase(
            String fileName,
            String sheetName,
            String testCase) throws IOException {

        FileInputStream fis =
                new FileInputStream(
                        System.getProperty("user.dir")
                        + "/src/test/resources/testdata/"
                        + fileName
                        + ".xlsx");

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);

        Map<String, String> data = new HashMap<>();

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row currentRow = sheet.getRow(i);

            String currentTestCase =
                    formatter.formatCellValue(
                            currentRow.getCell(0));

            if (currentTestCase.equalsIgnoreCase(testCase)) {

                for (int j = 0;
                     j < headerRow.getLastCellNum();
                     j++) {

                    String key =
                            formatter.formatCellValue(
                                    headerRow.getCell(j));

                    String value =
                            formatter.formatCellValue(
                                    currentRow.getCell(j));

                    data.put(key, value);

                    System.out.println(
                            currentTestCase + " | "
                            + key + " | "
                            + value);
                }

                break;
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}