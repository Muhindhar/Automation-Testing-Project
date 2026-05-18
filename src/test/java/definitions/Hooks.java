package definitions;

import io.cucumber.java.After;

import io.cucumber.java.Before;

import utilities.ConfigReader;

import utilities.DriverFactory;

public class Hooks {

	@Before
	public void setUp() {

		ConfigReader.loadProperties();
		DriverFactory.initDriver();
		DriverFactory.getDriver().get(ConfigReader.getProperty("loginUrl"));
	}

	@After
	public void tearDown() {
		//DriverFactory.quitDriver();
	}
}