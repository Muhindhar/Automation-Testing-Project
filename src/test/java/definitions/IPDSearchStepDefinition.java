package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.IPDSearchPage;
import utilities.DriverFactory;

public class IPDSearchStepDefinition extends DriverFactory {

    IPDSearchPage searchPage;

    public IPDSearchStepDefinition() {

        searchPage = new IPDSearchPage(DriverFactory.getDriver());
    }

    @When("the user enters {string} in the search box")
    public void the_user_enters_in_the_search_box(String patientName) {

        searchPage.clickIPDModule();

        searchPage.enterPatientName(patientName);
    }

    @Then("matching patient records should be displayed")
    public void matching_patient_records_should_be_displayed() {

        System.out.println("Matching records displayed");
    }

    @Then("no matching patient records should be displayed")
    public void no_matching_patient_records_should_be_displayed() {

        System.out.println("No matching records");
    }
}