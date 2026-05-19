package utilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReaderUtil {
	public static String[] getCSVData(String filePath, int rowNumber) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
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
}