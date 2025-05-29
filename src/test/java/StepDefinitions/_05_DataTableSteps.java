package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.xml.crypto.Data;
import java.util.List;

public class _05_DataTableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the Element LeftNav")
    public void clickOnTheElementLeftNav(DataTable links){
        List<String> linkList = links.asList();
        for (int i = 0; i < linkList.size(); i++) {
            ln.myclick(ln.getWebElement(linkList.get(i)));
        }
    }

    @And("Click on the Element Dialog")
    public void clickOnTheElementDialog( DataTable buttons) {
        List<String> buttonList = buttons.asList();
        for (String s : buttonList) {
            dc.myclick(dc.getWebElement(s));
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable datas) {
    List<List<String>> dataList = datas.asLists();

        for (int i = 0; i < dataList.size(); i++) {
            dc.mySendKeys(dc.getWebElement(dataList.get(i).get(0)),dataList.get(i).get(1));
        }
    }

    @And("User delete the element from dialog")
    public void userDeleteTheElementFromDialog(DataTable deleteItems) {

        List<String> deleteList = deleteItems.asList();
        for (int i = 0; i < deleteList.size(); i++) {
            dc.deleteItem(deleteList.get(i));
        }
    }

    @And("User sending the Enter keys in Dialog")
    public void userSendingTheEnterKeysInDialog() {
        new Actions(GWD.getDriver()).sendKeys(Keys.ENTER).build().perform();
    }


    @And("User sending the Escape keys in Dialog")
    public void userSendingTheEscapeKeysInDialog() {
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }
}
