package Yahoo_POM_TestScenarios;

import PageObjectClasses.Yahoo_Page_Object.Yahoo_HomePage;
import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

import java.io.IOException;

import static PageObjectClasses.Yahoo_Page_Object.Yahoo_Base_Class.yahoo_homePage;


public class TC91_YahooSearchResult extends Abstract_Class {

    @Test
    public void YahooSearch() throws IOException {

        driver.navigate().to("https://www.yahoo.com");

        yahoo_homePage().searchKey("Cars");



        //navigating to yahoo homepage





        //enter a key word on search field





    }


}
