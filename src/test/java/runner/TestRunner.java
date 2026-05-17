package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src\\test\\resources\\features\\prescription\\add_prescription.feature",
		glue = "definitions",
				plugin = {"pretty", 
						"html:target/cucumber-report.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
