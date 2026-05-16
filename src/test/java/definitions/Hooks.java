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
	public void tearDown() {
	    DriverFactory.quitDriver();
	}
}
