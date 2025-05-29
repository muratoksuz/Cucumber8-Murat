package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class _03_CitizenshipSteps {

    LeftNav lf = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenship")
    public void navigateToCitizenship() {
        lf.myclick(lf.setup);
        lf.myclick(lf.parameters);
        lf.myclick(lf.citizenship);
    }

    @When("Create a citizenship")
    public void createACitizenship() {

        String csName = RandomStringUtils.randomAlphabetic(6);
        String csCode = RandomStringUtils.randomAlphanumeric(3);

        dc.myclick(dc.addButton);
        dc.mySendKeys(dc.nameInput, csName);
        dc.mySendKeys(dc.shortName, csCode);
        dc.myclick(dc.saveButton);
    }

    @Then("Success message should be visible")
    public void successMessageShouldBeVisible() {
        dc.verifyMessageContainsText(dc.successMessage, "successfully");
    }

    @Then("UnSuccess message should be visible")
    public void unSuccessMessageShouldBeVisible() {
        dc.verifyMessageContainsText(dc.existMessage, "exists");
    }

    @Then("Deleted message should be visible")
    public void deletedMessageShouldBeVisible() {
        dc.verifyMessageContainsText(dc.deletedMessage, "deleted");
    }

    @When("Create a citizenship name as {string} code as {string}")
    public void createACitizenshipNameAsCodeAs(String arg0, String arg1) {
        dc.myclick(dc.addButton);
        dc.mySendKeys(dc.nameInput, arg0);
        dc.mySendKeys(dc.shortName, arg1);
        dc.myclick(dc.saveButton);

    }


    @When("Delete a citizenship code of {string}")
    public void deleteACitizenshipCodeOf(String arg0) {
        dc.deleteItem(arg0);

    }

    @When("User create a citizenship with ApachePOI")
    public void userCreateACitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo = ExcelUtility.getData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx","testCitizen",2);
        for (ArrayList<String> satir:tablo){
            dc.myclick(dc.addButton);
            dc.mySendKeys(dc.nameInput, satir.get(0));
            dc.mySendKeys(dc.shortName, satir.get(1));
            dc.myclick(dc.saveButton);
            dc.verifyMessageContainsText(dc.successMessage, "successfully");
        }
    }

    @Then("User delete a citizenship with ApachePOI")
    public void userDeleteACitizenshipWithApachePOI() {
        ArrayList<ArrayList<String>> tablo = ExcelUtility.getData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx","testCitizen",1);
        for (ArrayList<String> satir:tablo){
            dc.deleteItem(satir.get(0));
            dc.verifyMessageContainsText(dc.deletedMessage, "deleted");
        }
    }
}
