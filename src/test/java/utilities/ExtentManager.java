package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport/Spark.html");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("OS", "Windows");
            extent.setSystemInfo("Tester", "Vigneshwaran");
        }

        return extent;
    }
}