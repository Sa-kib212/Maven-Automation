package Day09_03312019;

import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class yahoo extends Reusable_Methods {
        //declare your driver
    WebDriver driver;
        //define jse to be reused
    JavascriptExecutor jse;



    @BeforeMethod
    public void openBrowser() throws IOException {
       driver = navigate(driver,"https://www.yahoo.com");
        jse = (JavascriptExecutor)driver;









    }//end of before method

    @Test
    public void searchResult() throws InterruptedException {
            //enter keyword on your search field


        sendKeys(driver,"//*[@name='p']",0,"Cars","Search Field");
            //click on the search icon
        click(driver,"//*[@type='submit']",0,"Search Button");
            //scroll to the bottom of the page
        Thread.sleep(2000);
        jse.executeScript("scroll(0,10000)");


        String result = getText(driver,"//*[@class='compPagination']", 0, "results");
        String[] arrayResult = result.split("Next");
            //print the search number
        System.out.print("Search number is " +arrayResult);



    }//end of test


    @AfterMethod
    public void afterResults(){
        driver.quit();




    }//end of after method








}// end of parent class
