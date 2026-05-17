package definitions;

import java.io.File;

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
    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) driver;

            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");

            try {

                String scenarioName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9]", "_");

                Path screenshotDir = Paths.get("test-output/screenshots");

                Files.createDirectories(screenshotDir);

                Path screenshotPath = screenshotDir.resolve(
                        scenarioName + "_" + System.currentTimeMillis() + ".png");

                Files.write(screenshotPath, screenshot);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();
    }

}