package Abstract_Test_Classes;

import Reusable_Classes.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionItem_6_TryCatch extends Reusable_Methods {
//declare all the reusable variables among methods in class level

    WebDriver driver;
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writeableFile;
    WritableSheet writeableSheet;
    int rows;
    Label label1, label2;
    String zipCode;


    @Test
    public void tc01_expressCheckout() throws InterruptedException, WriteException, IOException, BiffException {

        readableFile = Workbook.getWorkbook(new File("src/main/resources/weightWatchersExcelSheet.xls"));

//Locate the readable sheet in the excel file
        readableSheet = readableFile.getSheet(0);

//Physical count of the rows (Non empty rows)
        rows = readableSheet.getRows();

//Creating writeable file to mimic readableFile to write back
        writeableFile = Workbook.createWorkbook(new File("src/main/resources/weightWatchersExcelSheetResults.xls"), readableFile);

//CreateWritable Sheet
        writeableSheet = writeableFile.getSheet(0);


        //define driver with navigate method

        int i = 1;
        while (i < rows) {
            zipCode = readableSheet.getCell(0, i).getContents();

            driver.navigate().to("https://www.weightwatchers.com");


            Thread.sleep(3000);

//verify the title of the page
            getTitle(driver, "Weight Loss Program, Recipes & Help | Weight Watchers");


            click(driver, "//*[@class='find-a-meeting']", 0, "Finding A Studio");

            Thread.sleep(3000);

            sendKeys(driver, "//*[@name='meetingSearch']", 0, zipCode, "zipCodeField");


//click on search icon

            click(driver, "//*[@spice='SEARCH_BUTTON']", 0, "searchButton");


            Thread.sleep(5000);
//capture the first studio information


            String StudioInfo = getText(driver, "//*[@class='meeting-location__top']", 0, "meetingInfo");

            click(driver, "//*[@class='meeting-location__top']", 0, "meetingLoc");

            String opHours = getText(driver, "//*[contains(@class, 'currentday')]", 0, "opHour");
            Label label1 = new Label(1, i, StudioInfo);

            writeableSheet.addCell(label1);

            Label label2 = new Label(2, i, opHours);

            writeableSheet.addCell(label2);


            i = i + 1;

            writeableFile.write();
            writeableFile.close();//closing writeable excel;
            readableFile.close();


        }//end of while loop
    }//end of test method


}




