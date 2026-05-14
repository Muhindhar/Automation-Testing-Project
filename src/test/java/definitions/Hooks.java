package definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import utilities.DriverFactory;
import utilities.ExtentManager;

public class Hooks {
	
	@Before
	public static void setUp()
	{
		DriverFactory.initDriver();
	}
	
	@After
	public static void tearDown()
	{
		if(DriverFactory.getDriver() != null)
		{
			DriverFactory.quitDriver();
		}
	}
	
	@AfterAll
    public static void flushReport() {

        ExtentManager.getExtentReports().flush();
    }
}
