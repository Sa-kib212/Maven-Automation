package Abstract_ClassesActionItem;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YAHOO extends Abstract_Class {








    @Test
    public void TC_04_YAHOO() throws InterruptedException, IOException {


        driver.navigate().to("https://www.yahoo.com");

        getTitle(driver,logger,"Yahoo");



        List<WebElement>tabsCount = driver.findElements(By.xpath("//span[contains(@class, 'Mstart(2')]"));
        System.out.println("Tabs count is " + tabsCount.size());


        sendKeys(driver,logger,"//*[@id='uh-search-box']",0,"Nutrition","SearchBox");


        click(driver,logger,"//*[@type = 'submit']",0,"SearchButton");

        jse.executeScript("scroll(0,2000)");
        Thread.sleep(2000);




        String results = getText(driver,logger,"//*[@class = 'compPagination']",0,"Results");
        String[] searchResults = results.split("Next");

        System.out.println(searchResults[1]);

        jse.executeScript("scroll(0,-2000)");

        click(driver,logger,"//*[contains(text(),'Images')]",0,"Images");

        List<WebElement>imagesCount = driver.findElements(By.xpath("//*[contains(@class, 'ld')]"));
        System.out.println("Image count is " + imagesCount.size());

        click(driver,logger,"//*[contains(text(), 'Sign in')]",0,"signIn");
Thread.sleep(3000);

        sendKeys(driver,logger,"//*[@name = 'username']",0,"invaliduser033rj","invalidUserName");
Thread.sleep(3000);
        click(driver,logger,"//*[@id = 'login-signin']",0,"signIn");



        try { ArrayList<String>  tabs = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("Switch tab");
            driver.switchTo().window(tabs.get(0));

        } catch (Exception e) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));

            System.out.println("New tab did not open " + e);


        }

        click(driver,logger,"//*[@name = 'signin']",0,"signIn1");


        String field = getText(driver,logger,"//*[@id = 'username-error']",0,"loginField1");
        System.out.println("Error message reads: " +field);










    }//end of test method



}//end of public class
