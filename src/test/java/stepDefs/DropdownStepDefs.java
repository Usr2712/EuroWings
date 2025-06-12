package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableDiff;
import io.cucumber.java.en.When;
import pagesCode.DropDownCode;

import java.util.List;
import java.util.Map;

public class DropdownStepDefs {


DropDownCode dropDownCode = new DropDownCode(BrowserDriver.getWebDriver());

    @When("User clicks on dropdown for catogeries")
    public void userClicksOnDropdownForCatogeries() {


        dropDownCode.SelectCategoryfromDropDown();


    }



    @When("User clicks on dropdown for {string}")
    public void userClicksOnDropdownFor(String Catogories) throws InterruptedException {

        dropDownCode.SelectCategoryfromDropDownExamples(Catogories);

    }
  /*  @When("User selects on dropdown :")
    public void userSelectsOnDropdown(DataTable dataTable) throws InterruptedException {

        List<String> Data = dataTable.asList(String.class);

        String type =Data.get(0);

        System.out.println(type);
        dropDownCode.SelectCategoryfromMap(type);

        }
    */

@When("User selects on dropdown :")
public void userSelectsOnDropdown(DataTable dataTable) throws InterruptedException {

    List<String> Data = dataTable.asList(String.class);

   for (String data : Data) {


       System.out.println(data);
       dropDownCode.SelectCategoryfromMap(data);

   }
   }
   }





  /*  @When("User selects on dropdown :")
    public void userSelectsOnDropdown(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> categories = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : categories) {
            String type = row.get("categry");  // key must match the feature file header
            System.out.println("Selected Category: " + type);
            dropDownCode.SelectCategoryfromMap(type);
        }
    }*/



