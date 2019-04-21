package Abstract_ClassesActionItem;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WEIGHTWATCHERS extends Abstract_Class {
//declare all the reusable variables among methods in class level


    @Test
    public void tc03_WEIGHTWATCHERS() throws InterruptedException, WriteException, IOException, BiffException {

       ArrayList<String> zipCode = new ArrayList<String>();
       zipCode.add("11218");
       zipCode.add("11219");
       zipCode.add("11214");



        //define driver with navigate method

        int i = 0;
        while (i < zipCode.size()) {

            driver.navigate().to("https://www.weightwatchers.com");


            Thread.sleep(3000);

//verify the title of the page
            getTitle(driver,logger, "Weight Loss Program, Recipes & Help | Weight Watchers");


            click(driver,logger,"//*[@class='find-a-meeting']", 0, "Finding A Studio");

            Thread.sleep(3000);

            sendKeys(driver, logger,"//*[@name='meetingSearch']", 0, zipCode.get(i), "zipCodeField");


//click on search icon

            click(driver,logger, "//*[@spice='SEARCH_BUTTON']", 0, "searchButton");


            Thread.sleep(5000);
//capture the first studio information


            String StudioInfo = getText(driver,logger, "//*[@class='meeting-location__top']", 0, "meetingInfo");

            click(driver,logger, "//*[@class='meeting-location__top']", 0, "meetingLoc");

            String opHours = getText(driver,logger, "//*[contains(@class, 'currentday')]", 0, "opHour");
System.out.println("Studo info is " +StudioInfo+" opHours are " +opHours);




            i = i + 1;



        }//end of while loop
    }//end of test method


}




