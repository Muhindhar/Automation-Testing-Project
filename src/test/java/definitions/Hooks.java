package definitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                // Attach to Cucumber/Extent report
                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                // Save to disk under test-output/screenshots/
                try {
                    String scenarioName = scenario.getName()
                            .replaceAll("[^a-zA-Z0-9]", "_");
                    Path screenshotDir = Paths.get("test-output/screenshots");
                    Files.createDirectories(screenshotDir);
                    Path screenshotPath = screenshotDir.resolve(
                            scenarioName + "_" + System.currentTimeMillis() + ".png");
                    Files.write(screenshotPath, screenshot);
                } catch (IOException e) {
                    System.out.println("[Hooks] Failed to save screenshot to disk: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // Screenshot capture itself failed — log and continue to quit
            System.out.println("[Hooks] Screenshot failed: " + e.getMessage());
        } finally {
            // Always quit the driver, even if screenshot threw an exception
            DriverFactory.quitDriver();
        }
    }
}