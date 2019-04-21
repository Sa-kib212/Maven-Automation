package actionItems;

import Reusable_Classes.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

public class macysActionItem<softassert> extends Reusable_Methods {
        //declare driver
    WebDriver driver;
        //define jse to be reused
    JavascriptExecutor jse;
        //defining excel Paths
    Workbook readableFile;
    Sheet readableSheet;
    WritableWorkbook writeableFile;
    WritableSheet writeableSheet;
    int rows;
    Label label1, label2;
    SoftAssert softAssert;



    @BeforeMethod
    public void openBrowser() throws IOException, BiffException, InterruptedException {
        driver = navigate(driver,"http://www.express.com");



        /*soft assert
        softAssert = new SoftAssert(); */



        Thread.sleep(4000);

    jse = (JavascriptExecutor)driver;


        //Locate the readable file
        readableFile = Workbook.getWorkbook(new File("src/main/resources/expressExcelData.xls"));

            //Locate the readable sheet in the excel file
        readableSheet = readableFile.getSheet(0);

            //Physical count of the rows (Non empty rows)
        rows = readableSheet.getRows();

            //Creating writeable file to mimic readableFile to write back
        writeableFile = Workbook.createWorkbook(new File("src/main/resources/expressExcelDataResults.xls"), readableFile);

            //CreateWritable Sheet
        writeableSheet = writeableFile.getSheet(0);

        driver.manage().deleteAllCookies();








    }//end of before Method


    @Test
    public void test() throws InterruptedException, WriteException {
        int i = 1;
        while(i<rows) {
                //acquiring contents of excel sheet
            //
            String size = readableSheet.getCell(0, i).getContents();
            String quanity = readableSheet.getCell(1, i).getContents();
            String firstName = readableSheet.getCell(3, i).getContents();
            String lastName = readableSheet.getCell(4, i).getContents();
            String address = readableSheet.getCell(5, i).getContents();
            String State = readableSheet.getCell(6, i).getContents();
            String zipCode = readableSheet.getCell(7, i).getContents();
            String city = readableSheet.getCell(8, i).getContents();
            String phoneNumber = readableSheet.getCell(9, i).getContents();
            String cardType = readableSheet.getCell(10, i).getContents();
            String cardNumber = readableSheet.getCell(11, i).getContents();
            String email = readableSheet.getCell(12, i).getContents();

                        /** Your test begins here **/


            //navigate to express
            driver.navigate().to("http://www.express.com");

            //Hard assert
           /* Assert.assertEquals("Mens and Women's Clothing",driver.getTitle());*/

            //Soft Assert
           /*softAssert.assertEquals("Mens and Womens Clothing",driver.getTitle());*/

                //confirming title of express homepage
            getTitle(driver,"Men’s and Women’s Clothing");
                //hovering to womens tab
            mouseHover(driver,"//*[@href='/womens-clothing']",0,"womens-clothing");
                //clicking womens dresses

            mouseHover(driver,"//*[@href='/womens-clothing/dresses/cat550007']",0,"dresses");
                //clicking on shop by style
            click(driver,"//*[@href='/womens-clothing/dresses/style/cat4480003']",0,"shopByStyle");
            driver.manage().deleteAllCookies();
                //give page loading time
            Thread.sleep(4000);
                //scrolling to first dress
            jse.executeScript("scroll(0,400)");
                //clicking on first dress
            click(driver,"//*[contains(@alt , 'strapless')]",0,"addtoBag");

                //Choosing size

            click(driver,"//*[@value = '" + size + "']",0,"clothingSize");
                //Click addToBag using absolute path (other classes weren't working)
            click(driver,"//*[@id=\"content\"]/div/div/section/section[1]/section/button",0,"addToBag");
                //click check out
            click(driver,"//*[@class = 'cta  last-step']",0,"checkout");
                //select quantity
            dropDown(driver,"//*[@id = 'qdd-0-quantity']",0,quanity,"SelectQuantity");
                //click check out again
            click(driver, "//*[@id = 'continue-to-checkout']", 0, "checkout2");
                //click check out as guest
            click(driver,"//*[contains (text(), 'Continue as Guest')]",0,"checkoutAsGuest");

                //input first name
            sendKeys(driver,"//*[@name = 'firstname']",0,firstName,"firstName");
                //input last name
            sendKeys(driver,"//*[@name = 'lastname']",0,lastName,"lastName");
                //input email
            sendKeys(driver,"//*[@id=\"contact-information\"]/form/div[3]/div/input",0,email,"email");
                //confirm email
            sendKeys(driver,"//*[@id=\"contact-information\"]/form/div[4]/div/input",0,email,"confirmEmail");
                //input phone number
            sendKeys(driver,"//*[@name = 'phone']",0,phoneNumber,"phoneNumber");
                //click continue
            click(driver,"//*[@id=\"contact-information\"]/form/div[6]/button",0,"continueButton");
                //click continue again
            click(driver,"//*[@id=\"delivery-and-pickup\"]/div/div/button",0,"continueButton0");
                //inputting address
            sendKeys(driver,"//*[@name = 'shipping.line1']",0,address,"myAddress");
                //inputting postal code
            sendKeys(driver,"//*[@name = 'shipping.postalCode']",0,zipCode,"postalCodes");
                //inputting city name
            sendKeys(driver,"//*[@name = 'shipping.city']",0,city,"myCity");
                //selecting State from drop down menu
            dropDown(driver,"//*[@name = 'shipping.state']", 0,State,"selectState");
                //clicking continue again
            click(driver,"//*[contains (text(), 'Continue')]",0,"continueButton1");
                //send keys to credit card
            sendKeys(driver,"//*[@name = 'creditCardNumber']",0,cardNumber,"cardNumber");
            driver.manage().deleteAllCookies();
            click(driver,"//*[contains(text(),'Place Order')]",0,"placeOrder");
                //storing label

            String error = getText(driver,"//*[@class = 'dOxMH labelError']",0,"text");

            //storing error message
            label2 = new Label(13,i,error);
            writeableSheet.addCell(label2);
            //giving page time
            Thread.sleep(5000);

            System.out.println("=============================================");

            driver.manage().deleteAllCookies();






            i++;
            softAssert.assertAll();


        }//end of loop




        }//end of test method









    @AfterMethod
    public void afterTest() throws IOException, WriteException {
            writeableFile.write();
            writeableFile.close();//closing writeable excel;
            readableFile.close();
            driver.close();


    }//end of after method
}//end of public class
