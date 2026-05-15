package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

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
}
