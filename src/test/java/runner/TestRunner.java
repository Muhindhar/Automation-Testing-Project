package runner;


import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		features = "src\\test\\resources\\features",

		glue = "definitions",
		
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed-rerun.txt" },
		tags = "@jerishwin",
		monochrome = true)



public class TestRunner extends AbstractTestNGCucumberTests {

}

