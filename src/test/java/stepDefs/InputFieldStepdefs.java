package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import pagesCode.InputFieldCode;

public class InputFieldStepdefs {

    InputFieldCode inputFieldCode = new InputFieldCode(BrowserDriver.getWebDriver());

    @Given("User opens application")
    public void userOpensApplication() {

        System.out.println("opened");

    }


    @When("User enters data in inputField and capture all suggestions")
    public void userEntersDataInInputField() {

        inputFieldCode.SearchAnProduct();



    }


    @Given("User searches for {string}")
    public void userSearchesFor(String PhoneName) {

        inputFieldCode.SearchForanProduct(PhoneName);
    }

    @Then("Verifies Iphone search results are showing")
    public void verifiesIphoneSearchResultsAreShowing() {
        inputFieldCode.Validationofsearchresults();
    }

    @When("User selects the product {string}")
    public void userSelectsTheProduct(String ProductName) {
        inputFieldCode.SelectProductFromSugeestion(ProductName);
    }


}

