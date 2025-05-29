package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC706 {

    DialogContent dc = new DialogContent();


    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
    }


    @When("Enter email as {string} and password as {string}")
    public void enterEmailAsAndPasswordAs(String email, String password) {
    dc.myclick(dc.signInLink);
    dc.mySendKeys(dc.emailBox, email);
    dc.mySendKeys(dc.passwordBox, password);
    dc.myclick(dc.signInButton);
    }


    @Then("Welcome message should be displayed")
    public void WelcomeMessageShouldBeDisplayed() {
        dc.verifyMessageContainsText(dc.welcomeText,"Welcome");
    }


    @Given("Choose product after login")
    public void chooseProductAfterLogin() {

        // ürünlerin olduğu kısıma scroll et
        dc.scrollToElement(dc.productSide);

        // ürün lsitesinden random bir ürün seç
        int randomNumb = (int) (Math.random() * dc.productLinkList.size());

        //ilk sayfadan random ekelenen ürünün adını al
        String firstHand = dc.productNameList.get(randomNumb).getText();
        System.out.println("firstHand = " + firstHand);

        // tıklanan ürün sayfasındaki adı al
        dc.myclick(dc.productLinkList.get(randomNumb));
        String secondHand = dc.productPageTitle.getText();
        System.out.println("secondHand = " + secondHand);

        // seçilen ile açılanı gideni kontrol et
        Assert.assertEquals(firstHand,secondHand,"Seçilen ve tıklanan ürünler eşleşmiyor");

        // ürünü seç ve sepete ekle
        productChoice("2");
        dc.myclick(dc.addToCartButton);

    }

    @And("Observe product in basket and change the amounts")
    public void observeProductInBasketAndChangeTheAmounts() {


        // ürün sepete eklendikten sonra sepet butonuna tıklansın
        dc.myclick(dc.basketButton);
        // sepete git denilsin
        dc.myclick(dc.viewCartLink);
        // ürün düzenle butonuna tıkla
        dc.myclick(dc.basketEditButton);
        productChoice("1");
        dc.myclick(dc.updateProductButton);
        // işlemler tamamsa ürünün son hali için ödeme kısmına git
        dc.myclick(dc.proceedToCheckout);
        // adress ve seçimi ile birlikte bir sonraki stepe geçilebilir
        dc.myclick(dc.nextButton);


    }

    @Then("Enter the payment info")
    public void enterThePaymentInfo() {
       dc.myclick(dc.placeOrderButton);
    }

    @Then("Order success message should be observed")
    public void orderSuccessMessageShouldBeObserved() {
        dc.verifyMessageContainsText(dc.successMessageBox,"Thank you");
    }








    // Ek method
    public void productChoice(String quantity){
        // eğer beden seçiliyorsa beden seç
        if (!dc.sizeList.isEmpty()){
            int randomSizeIndex = (int) (Math.random() * dc.sizeList.size());
            System.out.println("randomSizeIndex = " + randomSizeIndex);
            dc.myclick(dc.sizeList.get(randomSizeIndex));
            System.out.println("dc.sizeList.get(randomSizeIndex).getText() = " + dc.sizeList.get(randomSizeIndex).getText());
        }

        // eğer renk seçiliyorsa renk seç
        if (!dc.colorList.isEmpty()){
            int randomColorIndex = (int) (Math.random() * dc.colorList.size());
            System.out.println("randomColorIndex = " + randomColorIndex);
            dc.myclick(dc.colorList.get(randomColorIndex));

        }
        // ürün adeti gir
        dc.myclick(dc.quantityBox);
        // bir adet olarak girilsin
        dc.mySendKeys(dc.quantityBox,quantity);

    }
}
