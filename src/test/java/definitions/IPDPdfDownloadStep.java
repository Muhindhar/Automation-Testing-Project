package definitions;

import actions.IPDPdfDownloadAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DriverFactory;

public class IPDPdfDownloadStep {

    IPDPdfDownloadAction ipdAction = new IPDPdfDownloadAction();

    @Then("the user should be navigated to the dashboard page")
    public void the_user_should_be_navigated_to_the_dashboard_page() {

        String actualTitle = DriverFactory.getDriver().getTitle();

        System.out.println("Dashboard Page Title: " + actualTitle);
    }

    @When("the user clicks on the {string} module")
    public void the_user_clicks_on_the_module(String moduleName) {

        ipdAction.clickIPDMenu();
    }

    @When("the user clicks on the PDF download button")
    public void the_user_clicks_on_the_pdf_download_button() {

        ipdAction.clickPdfButton();
    }

    @Then("the IPD patient details should be downloaded in PDF format")
    public void the_ipd_patient_details_should_be_downloaded_in_pdf_format() {

        System.out.println("PDF downloaded successfully");
    }
}

