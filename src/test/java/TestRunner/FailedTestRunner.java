package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "StepDefs",
        plugin = {
                "pretty",
        }
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {

    }


