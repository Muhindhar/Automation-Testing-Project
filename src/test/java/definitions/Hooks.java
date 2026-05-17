package definitions;

import io.cucumber.java.After;

import io.cucumber.java.Before;

import utilities.ConfigReader;

import utilities.DriverFactory;

public class Hooks {

	@Before
	public void setUp() {

	    DriverFactory.initDriver();
	    DriverFactory.getDriver().manage().deleteAllCookies();
		ConfigReader.loadProperties();
		DriverFactory.initDriver();

	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}