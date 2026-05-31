package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class CSVReaderUtil {

    public static String[] getCSVData(
            String filePath,
            int rowNumber) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new FileReader(filePath));

        String line;

        int count = 0;

        while ((line = br.readLine()) != null) {

            if (count == rowNumber) {

                br.close();

                return line.split(",");
            }

            count++;
        }

        br.close();

        return null;
    }

    public static Map<String, String>
    getTestDataByTestCase(

            String fileName,
            String testCase)

            throws IOException {

        String path =

                System.getProperty("user.dir")

                + "/src/test/resources/testdata/"

                + fileName

                + ".csv";

        BufferedReader br =

                new BufferedReader(
                        new FileReader(path));

        String headerLine =
                br.readLine();

        String[] headers =
                headerLine.split(",");

        String line;

        Map<String, String> data =
                new HashMap<>();

        while ((line = br.readLine()) != null) {

            String[] values =
                    line.split(",", -1);

            if (values[0]
                    .equalsIgnoreCase(testCase)) {

                for (int i = 0;
                     i < headers.length;
                     i++) {

                    data.put(

                            headers[i].trim(),

                            values[i].trim()
                    );

                    System.out.println(

                            headers[i]
                            + " : "
                            + values[i]
                    );
                }

                break;
            }
        }

        br.close();

        return data;
    }

    // ADD THIS METHOD

    public static Map<String, String>
    getFirstRow(

            String fileName,
            String testCase)

            throws IOException {

        return getTestDataByTestCase(
                fileName,
                testCase);
    }
}
