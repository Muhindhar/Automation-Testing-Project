package definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
	
	@Before
	public static void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public static void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
