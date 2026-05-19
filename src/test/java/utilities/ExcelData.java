package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

    public static Map<String, String> getRowData(String path, String sheetName, int rowNum)
            throws IOException {

        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(rowNum);

        Map<String, String> data = new HashMap<>();

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {

            String key = headerRow.getCell(i).toString();
            String value = dataRow.getCell(i).toString();

            data.put(key, value);
        }

        workbook.close();
        fis.close();

        return data;
    }
}