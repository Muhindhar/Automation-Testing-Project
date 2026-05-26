package definitions;

import actions.OPD_DischargeAction;
import io.cucumber.java.en.And;
import utilities.DriverFactory;

public class OPD_DischargeDefinition {

    OPD_DischargeAction dischargeAction =
            new OPD_DischargeAction(DriverFactory.getDriver());
    
    @And("fills in the discharge form and clicks the Save button")
    public void fills_in_the_discharge_form_and_clicks_the_save_button() throws Exception {
        dischargeAction.fillDischargeForm(); 
        dischargeAction.clickSaveDischargeButton();
    }

    @And("clicks on the Discharge icon")
    public void clicks_on_the_discharge_icon() {
        dischargeAction.clickDischargeIcon();
    }

    

}