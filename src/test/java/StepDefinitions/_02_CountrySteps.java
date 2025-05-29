package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class _02_CountrySteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();


    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myclick(ln.setup);
        ln.myclick(ln.parameters);
        ln.myclick(ln.countries);
    }

    @When("Create a country")
    public void createACountry() {

        String ulkeAdi = RandomStringUtils.randomAlphabetic(6);
        String ulkeKodu = RandomStringUtils.randomAlphanumeric(3);

        dc.myclick(dc.addButton);
        dc.mySendKeys(dc.nameInput,ulkeAdi);
        dc.mySendKeys(dc.codeInput, ulkeKodu);
        dc.myclick(dc.saveButton);


    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyMessageContainsText(dc.successMessage,"successfully");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String arg0, String arg1) {
        dc.myclick(dc.addButton);
        dc.mySendKeys(dc.nameInput,arg0);
        dc.mySendKeys(dc.codeInput, arg1);
        dc.myclick(dc.saveButton);
    }

    @When("Delete a country code of {string}")
    public void deleteACountryCodeOf(String arg0) {
        GWD.getDriver().navigate().refresh();
        dc.deleteItem(arg0);
    }
}
