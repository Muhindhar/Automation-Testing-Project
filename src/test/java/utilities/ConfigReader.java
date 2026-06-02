package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        loadProperties();
    }

    public static void loadProperties() {

        if (prop != null) {
            return;
        }

        try {

            prop = new Properties();

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/data.properties");

            prop.load(fis);

            fis.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}