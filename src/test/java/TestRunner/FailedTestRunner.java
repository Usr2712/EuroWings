/*
package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "@target/failedRerun.txt",
        glue = "StepDefinitions",
        tags = "@test1",
        plugin = {
                "pretty",
        }
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

        @Test(
                groups = {"cucumber"},
                description = "Runs Cucumber Scenarios",
                dataProvider = "scenarios",
                retryAnalyzer = Retry.class
        )

        @Override
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
                super.runScenario(pickleWrapper, featureWrapper);
        }
   */
/* @Override
    @DataProvider(parallel = true)
   public Object[][] scenarios(){
        return super.scenarios();
    }*//*

}*/
