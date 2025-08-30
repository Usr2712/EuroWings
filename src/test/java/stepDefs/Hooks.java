package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;


import static Utilities.ReusableMethods.takesScreenshotAsByte;
import static stepDefs.BrowserDriver.Quitdriver;

public class Hooks {

   // public static BrowserDriver driver;

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After");

        if(scenario.isFailed()) {
            scenario.attach(takesScreenshotAsByte(), "image/png", scenario.getName());
        }


        Quitdriver();
    }
}
