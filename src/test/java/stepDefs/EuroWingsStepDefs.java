package stepDefs;

import io.cucumber.java.an.E;
import io.cucumber.java.an.Y;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pagesCode.EuroWingsPageCode;

public class EuroWingsStepDefs {


    EuroWingsPageCode euroWingsPageCode = new EuroWingsPageCode(BrowserDriver.getWebDriver());

    @Given("User is on Eurowings website")
    public void userIsOnEurowingsWebsite() {
    }


    @And("user selects the airport for departure {string}")
    public void userSelectsTheAirportForDeparture(String depart) throws InterruptedException {

        euroWingsPageCode.SelectingDepatureAirport(depart);

    }

    @And("user selects the airport for destination {string}")
    public void userSelectsTheAirportForDestination(String desti) throws InterruptedException {
        euroWingsPageCode.SelectingDestinationAirport(desti);


    }

    @And("Selects the Date for going {string} and {string} and {string}")
    public void selectsTheDateAndAnd(String Year, String Month, String Date) throws InterruptedException {

        euroWingsPageCode.SelectDateforgoing(Year, Month, Date);

    }

    @And("Selects the Date for return {string} and {string} and {string}")
    public void selectsTheDateForReturnAndAnd(String Year, String Month, String Date) throws InterruptedException {
        euroWingsPageCode.SelectDateforReturn(Year, Month, Date);
    }

    @And("selects the {int}")
    public void selectsThe(int Adultpassengers) {


    }

    @Then("Click on Search Flights")
    public void clickOnSearchFlights() throws InterruptedException {

        euroWingsPageCode.ClickOnSearchFlights();
    }
}
