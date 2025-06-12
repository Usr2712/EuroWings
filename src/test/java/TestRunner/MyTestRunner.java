package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "C:\\Users\\ragha\\IdeaProjects\\AllConceptsSelenium\\src\\test\\resources\\Features\\EuroWings.feature",
        glue = "stepDefs",
        tags = "@Euro",
        plugin = {
                "pretty","html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt" // Store failed scenarios again if needed
        }
)

public class MyTestRunner extends AbstractTestNGCucumberTests {


}