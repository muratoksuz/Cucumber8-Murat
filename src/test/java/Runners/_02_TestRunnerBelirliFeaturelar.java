package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_03_CitizenShip.feature",
                "src/test/java/FeatureFiles/_12_NationalityDatatableSO.feature"
        },
        glue = {"StepDefinitions"}

)

public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}
