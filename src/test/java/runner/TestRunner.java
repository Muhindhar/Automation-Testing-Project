package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "src/test/resources/features",
		glue = "definitions",
		tags = "@Muhindhar",
		plugin = {
				"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed-rerun.txt" },
		monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}