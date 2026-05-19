package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReaderUtil {

    /**
     * Reads all rows from a CSV that match the given scenarioKey.
     * Matches against the "scenario" column first, then falls back to "type" column.
     * Pass null or empty string to return ALL rows.
     */
    public static List<Map<String, String>> getData(String filePath, String scenarioKey) {
        List<Map<String, String>> result = new ArrayList<>();

        File csvFile = new File(System.getProperty("user.dir"), filePath);
        if (!csvFile.exists()) {
            throw new RuntimeException(
                    "CSV file not found at: " + csvFile.getAbsolutePath());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String headerLine = br.readLine();
            if (headerLine == null) return result;

            // Trim each header to avoid whitespace issues
            String[] headers = headerLine.split(",", -1);
            for (int i = 0; i < headers.length; i++) {
                headers[i] = headers[i].trim();
            }

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                // -1 keeps trailing empty fields (e.g. missing checkinDate)
                String[] values = line.split(",", -1);

                Map<String, String> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    row.put(headers[i], i < values.length ? values[i].trim() : "");
                }

                // Match on "scenario" column OR fall back to "type" column
                boolean noFilter  = (scenarioKey == null || scenarioKey.isEmpty());
                boolean matchesScenario = row.getOrDefault("scenario", "")
                                            .equalsIgnoreCase(scenarioKey);
                boolean matchesType = row.getOrDefault("type", "")
                                        .equalsIgnoreCase(scenarioKey);

                if (noFilter || matchesScenario || matchesType) {
                    result.add(row);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to read CSV: " + csvFile.getAbsolutePath()
                    + ". Cause: " + e.getMessage());
        }

        return result;
    }

    /**
     * Returns the first matching row for the given scenarioKey.
     * Throws a descriptive RuntimeException if no match is found.
     */
    public static Map<String, String> getFirstRow(String filePath, String scenarioKey) {
        List<Map<String, String>> data = getData(filePath, scenarioKey);
        if (data.isEmpty()) {
            throw new RuntimeException(
                    "No data found in [" + filePath + "] for scenario key: ["
                    + (scenarioKey == null ? "ALL" : scenarioKey) + "]. "
                    + "Check that the 'scenario' or 'type' column contains this value.");
        }
        return data.get(0);
    }
}