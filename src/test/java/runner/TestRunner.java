package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "definitions",
		plugin = {"pretty", 
						"html:target/cucumber-report.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
						"rerun:target/failed-rerun.txt"},
		tags = "@negative"
			
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
