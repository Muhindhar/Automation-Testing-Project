package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver(WebDriver webDriver) {
		driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static String captureScreenshot(String screenshotName) {
		String dir = "reports/screenshots/";
		new File(dir).mkdirs();
		String path = dir + screenshotName + "_" + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static byte[] captureScreenshotBytes() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	public static void sleep(long millis) {
		try { Thread.sleep(millis); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	}
}
