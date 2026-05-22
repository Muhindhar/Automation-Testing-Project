package utilities;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-password-generation");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
        System.out.println(downloadPath);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.set(new ChromeDriver(options));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return getDriver();
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}


		//options.addArguments("--headless=new");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-features=PasswordLeakDetection");
		options.addArguments("--disable-password-generation");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-gpu");
		options.addArguments("--start-maximized");
		String downloadPath = System.getProperty("user.dir") + File.separator + "downloads";
		System.out.println(downloadPath);
		Map<String, Object> prefs = new HashMap<>();
	
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("safebrowsing.enabled", true);
		options.setExperimentalOption("prefs", prefs);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver.set(new ChromeDriver(options));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		return getDriver();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}


	public static void quitDriver() {
		if (driver.get() != null) {
//			driver.get().quit();
//			driver.remove();
		}
	}
}
