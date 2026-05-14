package definitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.HelperClass;

public class Hooks {

	private WebDriver driver;

	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");
		options.addArguments("--remote-allow-origins=*");

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		HelperClass.setDriver(driver);

		driver.manage().window().maximize();
		driver.get("https://demo.smart-hospital.in/site/login");
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = HelperClass.captureScreenshotBytes();
			scenario.attach(screenshot, "image/png", scenario.getName());
			HelperClass.captureScreenshot(scenario.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	}
}
