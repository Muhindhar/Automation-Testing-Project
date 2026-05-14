package definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import actions.OPD_SearchActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OPD_SearchDefinitions {
	

	@Before
    public void setUp() {
        driver = new ChromeDriver();
        sa = new OPD_SearchActions(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
    WebDriver driver;
	OPD_SearchActions sa;
	
    
	@Given("the user is logged into the Smart Hospital portal as a receptionist")
	public void the_user_is_logged_into_the_smart_hospital_portal_as_a_receptionist() {
	    driver.get("https://demo.smart-hospital.in/site/login");
	    driver.findElement(By.xpath("//div[@class='btn-group btn-group-justified'][3]/a[2]")).click();
	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

	@Given("the user is on the OPD page")
	public void the_user_is_on_the_opd_page() {
	    sa.navigateToOPDPage();
	}

	@When("the user types {string} into the OPD search box")
	public void the_user_types_into_the_opd_search_box(String string) {
	    sa.searchPatient(string);
	}

	@Then("the patient table should display \"The single record for Patient ID \"Maria\"\"")
	public void the_patient_table_should_display_patient_records_containing_the_name_maria() {
		System.out.println(sa.verifySearchnameResult());
	    Assert.assertTrue(sa.verifySearchnameResult().contains("Maria"));
	}
	
	@Then("the patient table should display \"A \"No data available in table\" message\"")
	public void the_patient_table_should_display_a_no_data_available_in_table_message() {
		 System.out.println(sa.verifySearchFailed());
	    Assert.assertTrue(sa.verifySearchFailed().contains("No data available in table"));
	}

}
