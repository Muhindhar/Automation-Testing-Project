package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features =
	"src/test/resources/features/addAppointment.feature",
	glue = { "definitions" },
	plugin = {
		"pretty",
		"html:reports/Cucumber.html",
		"json:reports/Cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	},
	monochrome = true,
	publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}