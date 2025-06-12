package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pagesCode.CalendarCode;

public class CalendarStepDefs {


    CalendarCode calendarCode = new CalendarCode(BrowserDriver.getWebDriver());

    @When("User clicks selects dates")
    public void userClicksSelectsDates() {
    }


    @When("User clicks selects From date as {string} and {string}")
    public void userClicksSelectsFromDateAsAnd(String month, String date) {

        calendarCode.SelectFromDate(month,date);


    }

}
