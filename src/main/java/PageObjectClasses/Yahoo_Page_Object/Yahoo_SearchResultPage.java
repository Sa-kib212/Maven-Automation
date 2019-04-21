package PageObjectClasses.Yahoo_Page_Object;

import Reusable_Classes.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Yahoo_SearchResultPage extends Abstract_Class {
    ExtentTest logger;
    public Yahoo_SearchResultPage(WebDriver driver){

        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }
    public Yahoo_SearchResultPage scrollDown(String pixles) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(3000);
        jse.executeScript("scroll(0,400)");

        return new Yahoo_SearchResultPage(driver);
    }


    String searchResultLocator = "//*[@class='compPagination']";
    public Yahoo_SearchResultPage searchNumber() throws IOException {

        String searchresult = getText(driver,logger,searchResultLocator,0,"Search Result");
        String[] searchArray = searchresult.split("Next");
        logger.log(LogStatus.INFO,"My search number is " +searchArray[1]);
        return new Yahoo_SearchResultPage(driver);




    }


}
