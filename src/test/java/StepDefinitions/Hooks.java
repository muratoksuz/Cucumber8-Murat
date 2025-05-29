package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {

    @After
    public void after(Scenario senaryo) throws IOException {
        ExcelUtility.writeToExcel(
                "src/test/java/ApachePOI/Resource/SenaryoSonuc.xlsx",
                senaryo.getName(),
                senaryo.isFailed()?"Failed":"Passed"
        );


        if (senaryo.isFailed()){
            TakesScreenshot ts=((TakesScreenshot) GWD.getDriver());
            byte[] hafizadakiHali=ts.getScreenshotAs(OutputType.BYTES);
            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }


        GWD.quitDriver();
    }
}
