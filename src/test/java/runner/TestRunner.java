package runner;


import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
<<<<<<< HEAD
		features = "src/test/resources/features/IPD/PatientDischarge.feature",
=======

		features = "src\\test\\resources\\features\\FrontOffice\\FrontOfficeComplaint.feature",

>>>>>>> 5e8af20570419d5e34a7f167dcb3fd4525b24cce
		glue = "definitions",
		
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failed-rerun.txt" },		
		monochrome = true)



public class TestRunner extends AbstractTestNGCucumberTests {

}

