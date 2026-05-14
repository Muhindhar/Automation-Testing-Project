package definitions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.HelperClass;

public class Hooks {

	WebDriver driver;

	@Before
	public void setup() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		options.addArguments("--disable-popup-blocking");

		options.addArguments("--disable-infobars");

		options.addArguments("--disable-extensions");

		options.addArguments("--guest");

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("profile.default_content_setting_values.notifications", 2);

		prefs.put("credentials_enable_service", false);

		prefs.put("profile.password_manager_enabled", false);

		prefs.put("profile.managed_default_content_settings.ads", 2);

		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);

		HelperClass.setDriver(driver);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demo.smart-hospital.in/site/login");
	}

	@After
	public void tearDown() {

		HelperClass.getDriver().quit();
	}
}