package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",

        glue = "definitions",

        plugin = {

                "pretty",

                "html:target/cucumber-report.html",

                "json:target/cucumber-report.json",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

                "rerun:target/failed-rerun.txt"
        },

        tags = "not @Bug and not @UnderDevelopment",

        monochrome = true,

        publish = true
)

public class TestRunner
        extends AbstractTestNGCucumberTests {

    @Override

    @DataProvider(parallel = false)

    public Object[][] scenarios() {

        return super.scenarios();
    }
}
