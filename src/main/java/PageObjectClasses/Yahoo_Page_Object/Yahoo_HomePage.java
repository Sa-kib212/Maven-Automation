package PageObjectClasses.Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Methods_Loggers_POM;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class Yahoo_HomePage extends Abstract_Class {
    ExtentTest logger;

    public Yahoo_HomePage(WebDriver driver) {
        super();
        //inherting driver from abstract class)
        PageFactory.initElements(driver, this);
        this.logger = super.logger;


    }

    //below is not necessary if you are using reusable elements
    @FindBy(xpath = "//*[@name = 'p']")
   public static WebElement searchField;


    public Yahoo_HomePage searchKey(String userInput) throws IOException {
        Reusable_Methods_Loggers_POM.sendKeys(driver, logger, searchField, 0, userInput, "searchKeyLocator");

        return new Yahoo_HomePage(driver);
    }
String searchIcon = "//*[@type = 'submit']";
   public Yahoo_HomePage clickonSearchIcon() throws IOException {
        click(driver,logger,searchIcon,0,"searchClick");
        return new Yahoo_HomePage(driver);


   }


}
