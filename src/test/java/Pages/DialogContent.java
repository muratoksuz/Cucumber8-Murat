package Pages;

import Utilities.GWD;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DialogContent extends ParentPage {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css = "[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement headText;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    public WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement shortName;

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']//button")
    public WebElement saveButton;

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']//button")
    public WebElement feeSaveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'exist')]")
    public WebElement existMessage;

    @FindBy(xpath = "//div[contains(text(),'deleted')]")
    public WebElement deletedMessage;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'FIELD.SHORTNAME')]//input")
    public WebElement searchCode;

    @FindBy(xpath = "//ms-text-field/input[@placeholder='Name']")
    public WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteSubmit;

    @FindBy(xpath = "//ms-search-button/div/button")
    public WebElement searchButton;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    public WebElement feeIntCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    public WebElement feePriority;

    @FindBy(xpath = "//ms-delete-button[@class='ng-star-inserted']/button")
    public WebElement deleteButton;


    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> nameList;


    // Login locators silinecek
    @FindBy(linkText = "Sign In")
    public WebElement signInLink;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "pass")
    public WebElement passwordBox;

    @FindBy(id = "send2")
    public WebElement signInButton;

    @FindBy(xpath = "//span[@class='logged-in']")
    public WebElement welcomeText;

    // Login locators


    // TC706 locators
    @FindBy(xpath = "//strong[@class='product-item-name']/a")
    public List<WebElement> productNameList;

    @FindBy(xpath = "//div[@class='product-item-info']/a")
    public List<WebElement> productLinkList;

    @FindBy(xpath = "//h1/span")
    public WebElement productPageTitle;

    @FindBy(id = "product-addtocart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='swatch-option text']")
    public List<WebElement> sizeList;

    @FindBy(xpath = "//div[@class='swatch-option color']")
    public List<WebElement> colorList;

    @FindBy(id = "qty")
    public WebElement quantityBox;

    @FindBy(xpath = "//div[@class='content-heading']")
    public WebElement productSide;

    @FindBy(xpath = "//div[@data-block='minicart']")
    public WebElement basketButton;

    @FindBy(xpath = "//a[@class='action viewcart']/span")
    public WebElement viewCartLink;

    @FindBy(xpath = "//a[@class='action action-edit']")
    public WebElement basketEditButton;

    @FindBy(id = "product-updatecart-button")
    public WebElement updateProductButton;

    @FindBy(xpath = "//li/button[@title='Proceed to Checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//button[@data-role='opc-continue']")
    public WebElement nextButton;

    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//h1[@class='page-title']")
    public WebElement successMessageBox;


    public void verifyMessageContainsText(WebElement element, String searchText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().contains(searchText));
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void deleteItem(String deleteName) {

        mySendKeys(searchInput, deleteName);
        myclick(searchButton);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        myclick(deleteButton);
        myclick(deleteSubmit);
    }

    public WebElement getWebElement(String strName) {
        switch (strName) {
            case "addButton": return this.addButton;
            case "saveButton": return this.saveButton;
            case "nameInput": return this.nameInput;
            case "codeInput": return this.codeInput;
            case "shortName": return this.shortName;
            case "feePriority": return this.feePriority;
            case "feeIntCode": return this.feeIntCode;

            // login locators
            case "signInLink": return this.signInLink;
            case "passwordBox": return this.passwordBox;
            case "signInButton": return this.signInButton;
            case "welcomeText": return this.welcomeText;
            // TC706
            case "productPageTitle": return this.productPageTitle;
            case "addToCartButton": return this.addToCartButton;
            case "quantityBox": return this.quantityBox;
            case "productSide": return this.productSide;
            case "basketButton": return this.basketButton;
            case "viewCartLink": return this.viewCartLink;
            case "basketEditButton": return this.basketEditButton;
            case "updateProductButton": return this.updateProductButton;
            case "proceedToCheckout": return this.proceedToCheckout;
            case "nextButton": return this.nextButton;
            case "placeOrderButton": return this.placeOrderButton;

        }
        return null;
    }

}
