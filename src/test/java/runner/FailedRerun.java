package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

public class FailedRerun {
	@CucumberOptions(features = { "@target/failed-rerun.txt" }, glue = { "definitions" }, plugin = {
			"pretty", "html:target/cucumber-report-rerun.html", "json:target/cucumber-rerun-report.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true)
	public class Failed_TestNgRunner extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}

}
