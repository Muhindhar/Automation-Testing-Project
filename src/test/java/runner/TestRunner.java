package runner;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "definitions",
		plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
<<<<<<< HEAD
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/failed-rerun.txt" },
		monochrome = true,
		tags = "not @UnderDevelopment and not @Bug"
		)
=======
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:target/failed-rerun.txt" },
				tags = "(@Muhindhar or @Vigneshwaran or @jerishwin or @Malavicka or @Mythily) and not (@Developing or @Bug or @UnderDevelopment or @develop)",
		//tags = "@Addcall",
		monochrome = true)

>>>>>>> 66d126c (updated add complaint)


public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider

	public Object[][] scenarios() {

		return super.scenarios();
	}
}