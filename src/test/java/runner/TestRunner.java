package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
<<<<<<< HEAD
		features = "src/test/resources/features",
		glue = "definitions",
		
		plugin = {"pretty",
				"html:target/cucumber-report.html",
				"json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failed-rerun.txt" },
		tags = "@Malavicka",
		monochrome = true)


=======
        features = "src\\test\\resources\\features",
        glue = "definitions",
        plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/failed-rerun.txt" },
        monochrome = true,
        tags = "not @UnderDevelopment and not @Bug"
)
>>>>>>> aab1ca31465cceb65c6549b7e98b80d05a31a0e6
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

