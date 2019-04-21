package Day10_04062019;

import Reusable_Classes.Reusable_Methods;
import net.bytebuddy.agent.builder.AgentBuilder;
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

public class Class_ActionItem extends Reusable_Methods {

    WebDriver driver;
    JavascriptExecutor jse;
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void openbrowser() throws IOException {

        driver = navigate(driver,"https://www.yahoo.com");

        getTitle(driver,"Yahoo");

        jse = (JavascriptExecutor)driver;





    }//end of before method








    @Test
    public void testScenario() throws InterruptedException {
        driver.navigate().to("https://www.yahoo.com");

        softAssert.assertEquals("Yahoo",driver.getTitle());


        List<WebElement>tabsCount = driver.findElements(By.xpath("//span[contains(@class, 'Mstart(2')]"));
        System.out.println("Tabs count is " + tabsCount.size());


        sendKeys(driver,"//*[@id='uh-search-box']",0,"Nutrition","SearchBox");


        click(driver,"//*[@type = 'submit']",0,"SearchButton");

        jse.executeScript("scroll(0,2000)");
        Thread.sleep(2000);




        String results = getText(driver,"//*[@class = 'compPagination']",0,"Results");
        String[] searchResults = results.split("Next");

        System.out.println(searchResults[1]);

        jse.executeScript("scroll(0,-2000)");

        click(driver,"//*[contains(text(),'Images')]",0,"Images");

        List<WebElement>imagesCount = driver.findElements(By.xpath("//*[contains(@class, 'ld')]"));
        System.out.println("Image count is " + imagesCount.size());

        click(driver,"//*[contains(text(), 'Sign in')]",0,"signIn");
Thread.sleep(3000);

        sendKeys(driver,"//*[@name = 'username']",0,"invaliduser033rj","invalidUserName");
Thread.sleep(3000);
        click(driver,"//*[@id = 'login-signin']",0,"signIn");



        try { ArrayList<String>  tabs = new ArrayList<String>(driver.getWindowHandles());
            System.out.println("Switch tab");
            driver.switchTo().window(tabs.get(0));

        } catch (Exception e) {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));

            System.out.println("New tab did not open " + e);


        }

        click(driver,"//*[@name = 'signin']",0,"signIn1");


        String field = getText(driver,"//*[@id = 'username-error']",0,"loginField");
        System.out.println("Error message reads: " +field);




        softAssert.assertAll();






    }//end of test method



    @AfterMethod
    public void closeBrowser(){}//end of after method
}//end of public class
