package PageObjectClasses.Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Base_Class extends Abstract_Class {

    public Yahoo_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);


    }



    //object for yahoo home page
    public static Yahoo_HomePage yahoo_homePage() {
        Yahoo_HomePage yahoo_homePage = new Yahoo_HomePage(driver);

        return yahoo_homePage;

    }

}
