package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Abstract_Class extends Reusable_Methods_Loggers {
    /*all the public static variables need to be set to null to be reused on
    multiple test classes */


    public static WebDriver driver = null;
    public static ExtentReports report = null;
    public static ExtentTest logger = null;
    public static JavascriptExecutor jse = null;

    //before suite is needed to define your chrome driver
    @BeforeSuite
    public void openBrowser() throws IOException {

report = new ExtentReports("src/main/java/Report_Folder/AutomationReport" + shortUUID() + ".html", true);
        //end of before suite

    }
    @Parameters("browser")
    @BeforeMethod
    public void getBrowserAndTestName(Method methodName,String browser) throws IOException {
        //logger below will get the actual name of each of your @Test methods
        if(browser.equalsIgnoreCase("Chrome")) {

            driver = navigate(driver, "https://www.google.com");
        } else if(browser.equalsIgnoreCase("Firefox")) {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");

            driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        }
        //logger below will get test name
        logger = report.startTest(methodName.getName() + "--" + browser);
        logger.log(LogStatus.INFO, "Automation Test Scenario Started....");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //define the javascript
        jse = (JavascriptExecutor)driver;


        //define the chrome driver




    }//end of before method

    @AfterMethod
    public void endTest() {
        report.endTest(logger);
        logger.log(LogStatus.INFO, "Automation Test Scenario ended....");


    }//end of after method

    @AfterSuite
    public void closeSuite() {
        report.flush();
        report.close();
        driver.quit();


    }

}//end of aftersuite



