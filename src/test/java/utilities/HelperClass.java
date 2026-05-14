package utilities;

import org.openqa.selenium.WebDriver;

public class HelperClass {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {

		HelperClass.driver = driver;
	}

	public static WebDriver getDriver() {

		return driver;
	}
}