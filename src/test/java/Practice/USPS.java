package Practice;

import Reusable_Classes.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class USPS extends Reusable_Methods {
    WebDriver driver;



    @BeforeMethod
    public void openBrowser() throws IOException {

        driver = navigate(driver,"https://usps.com");



    }

    @Test
    public void navigationMethod() throws InterruptedException {

        driver.navigate().to("https://usps.com");

        mouseHover(driver,"//*[@id=\"g-navigation\"]/div/nav/ul/li[1]/a[2]",0,"menu");
        Thread.sleep(2000);

         driver.navigate().to("https://mlcalc.com");
         Thread.sleep(2000);
         dropDown(driver,"//*[@id=\"mortgageForm\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/select[2]",0,"2021","DropDown");

         Thread.sleep(1000);
         click(driver,"//*[@id=\"mortgageForm\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[13]/td/input",0,"Button");
         Thread.sleep(3000);



    }




}
