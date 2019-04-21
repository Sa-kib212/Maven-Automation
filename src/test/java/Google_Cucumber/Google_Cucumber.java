package Google_Cucumber;

import Reusable_Classes.Reusable_Methods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Google_Cucumber extends Reusable_Methods{


        WebDriver driver = null;

        @Given("^I navigate to google.com$")


        public void openBrowser() throws IOException {


        driver = navigate(driver,"https://www.google.com");


    }
    @When("^I verify my Google Home title states Google$")
    public void verifyHomeTitle(){
            getTitle(driver,"GOOGLE");



    }
    @Then("^I enter a keyword in my search field$")
    public void enterKeyword(){
            sendKeys(driver,"//*[@name = 'q']",0,"Cars","Search field");



    }
    @And("^I click on Search Icon$")
    public void clickOnSearch(){
            click(driver,"//*[@name='btnK']",0,"Search Button");



    }
    @When("^I verify the Google Search$")
    public void verifySearch(){
            getTitle(driver,"Google Search");


    }

    @Then("^I capture the search result$")
    public void captureSearchResult(){
            String result = getText(driver,"//*[@id='resultStats']",0,"Search results");
            String[] arrayResult = result.split(" ");
            System.out.println("Search number is " +arrayResult[1] + " results");



    }


    }//end of public class



