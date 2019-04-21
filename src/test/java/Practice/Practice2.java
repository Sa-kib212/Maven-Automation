package Practice;

import Reusable_Classes.Reusable_Methods;
import Reusable_Classes.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;



public class Practice2 extends Reusable_Methods_Loggers {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    JavascriptExecutor jse;

    @BeforeMethod
    public void openWebBrowser() throws IOException {
        driver = navigate(driver, "https://www.express.com");
        report = new ExtentReports("src/main/java/Report_Folder" + shortUUID() + ".html");
        jse = (JavascriptExecutor)driver;


    }//end of before method


    @Test
    public void testExecution() throws InterruptedException {
        driver.navigate().to("https://www.express.com");
        String Expectedtitle = "Express Home";
        String title = driver.getTitle();

        if (Expectedtitle.equals(title)){
            System.out.print("The titles match");
        }else {
            System.out.println(title);
        }


        jse.executeScript("scroll(0,400)");
Thread.sleep(4000);
        WebElement element;
        element = driver.findElement(By.xpath("//*[@class= 'tile-href']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);


        }//end of Test method




    @AfterMethod
    public void closeWebBrowser(){

        driver.quit();
        report.flush();
        report.close();




    }//end of after method
}