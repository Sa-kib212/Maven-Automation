package Abstract_ClassesActionItem;

import Reusable_Classes.Abstract_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class GOOGLE extends Abstract_Class {


    @Test
    public void TC_01_Google() throws InterruptedException, IOException {

        String[] Cities = new String[3];
        Cities[0] = "Brooklyn";
        Cities[1] = "Albany";
        Cities[2] = "Rochester";

        for(int i=0; i<Cities.length; i++) {

            driver.navigate().to("https://www.google.com");
            //send keys to search bar
            sendKeys(driver,logger,"//*[@name='q']",0,Cities[i],"Cities");

            /*driver.findElement(By.name("q")).sendKeys(Cities[i]);
            Thread.sleep(2000);
            //Give browser time to load search*/

            //click on search icon
            click(driver,logger,"//*[@name='btnK']",0,"click");

            /*driver.findElement(By.name("btnK")).click();
            Thread.sleep(4000);*/
            //Give browser time to load

            String myResult = getText(driver,logger,"//*[@id='resultStats']",0,"results1");

            String[] myArrayResult = myResult.split(" ");
            //Splitting into an array

            System.out.println(myArrayResult[1]);
            //printing array result


        }
    }//end of main method







}//end of parent class
