package runner;


import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		features = "src\\test\\resources\\features\\pathalogy\\search.feature",
		glue = "definitions",
		
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failed-rerun.txt" },
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}

