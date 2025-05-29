package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class _01_LoginSteps {

    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        GWD.getDriver().get("https://test.mersys.io/");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {


        dc.scrollToElement(dc.username);
        dc.mySendKeys(dc.username,"Campus25");
        dc.mySendKeys(dc.password,"Campus.2524");
        dc.myclick(dc.loginButton);


    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        dc.wait.until(ExpectedConditions.textToBePresentInElement(dc.headText, "Internship"));
        Assert.assertTrue(dc.headText.getText().equals("Internship"));


    }

}
