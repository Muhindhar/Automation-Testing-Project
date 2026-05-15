package definitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import utilities.DriverFactory;

public class Helper {
	
	
	
	public static Properties getPropertyFile()
	{
		try
		{
			File dataFile = new File("src/test/resources/data.properties");
			FileInputStream fis = new FileInputStream(dataFile);
			
			Properties prop = new Properties();
			prop.load(fis);
			
			return prop;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void launchApplication()
	{
		Properties prop = getPropertyFile();
		
		String url = prop.getProperty("url");
		
		DriverFactory.getDriver().get(url);
	}
	
//	public static void login()
//	{
//		Properties prop = getPropertyFile();
//		
//		String email = prop.getProperty("email");
//		String password = prop.getProperty("password");
//		
//		la.login(email, password);
//	}
	
}
