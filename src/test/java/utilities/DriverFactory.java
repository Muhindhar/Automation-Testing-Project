package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initDriver() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		options.addArguments("--disable-popup-blocking");

		options.addArguments("--disable-infobars");

		options.addArguments("--disable-extensions");

		options.addArguments("--guest");
		
		options.addArguments("--start-maximized");

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("profile.default_content_setting_values.notifications", 2);

		prefs.put("credentials_enable_service", false);

		prefs.put("profile.password_manager_enabled", false);

		prefs.put("profile.managed_default_content_settings.ads", 2);

		options.setExperimentalOption("prefs", prefs);
		WebDriver webDriver = new ChromeDriver(options);
		driver.set(webDriver);
		return webDriver;
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			//driver.get().quit();
			//driver.remove();
		}
	}
}