package Abstract_ClassesActionItem;

import Reusable_Classes.Abstract_Class;
import Reusable_Classes.Reusable_Methods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EXPRESS<softassert> extends Abstract_Class {






    @Test
    public void tc02_EXPRESS() throws InterruptedException, WriteException, IOException, BiffException {
        //acquiring contents of excel sheet
        //
        ArrayList<String> size =new ArrayList<String>();
        size.add("0");
        size.add("2");
        size.add("4");

        ArrayList<String> quantity =new ArrayList<String>();
        quantity.add("1");
        quantity.add("2");
        quantity.add("3");

        ArrayList<String> firstName =new ArrayList<String>();
        firstName.add("Sally");
        firstName.add("Britney");
        firstName.add("Ariana");



        ArrayList<String> lastName =new ArrayList<String>();
        lastName.add("Mae");
        lastName.add("Spears");
        lastName.add("Grande");

        ArrayList<String> address =new ArrayList<String>();
        address.add("111");
        address.add("222");
        address.add("333");

        ArrayList<String> State =new ArrayList<String>();
        State.add("New York");
        State.add("New York");
        State.add("New York");

        ArrayList<String> zipCode =new ArrayList<String>();
        zipCode.add("10453");
        zipCode.add("11219");
        zipCode.add("10005");

        ArrayList<String> city =new ArrayList<String>();
        city.add("Bronx");
        city.add("Brooklyn");
        city.add("NYC");

        ArrayList<String> phoneNumber =new ArrayList<String>();
        phoneNumber.add("6463471718");
        phoneNumber.add("3476461718");
        phoneNumber.add("7186461347");

        ArrayList<String> cardNumber =new ArrayList<String>();
        cardNumber.add("4911830000000");
        cardNumber.add("545455454");
        cardNumber.add("601000000");

        ArrayList<String> email =new ArrayList<String>();
        email.add("mike123@gmail.com");
        email.add("john1234@yahoo.com");
        email.add("jay321@hotmail.com");






        int i = 1;
        while(i<email.size()) {

                        /** Your test begins here **/


            //navigate to express
            driver.navigate().to("http://www.express.com");

            //Hard assert
           /* Assert.assertEquals("Mens and Women's Clothing",driver.getTitle());*/

            //Soft Assert
           /*softAssert.assertEquals("Mens and Womens Clothing",driver.getTitle());*/

                //confirming title of express homepage
            getTitle(driver,logger,"Men’s and Women’s Clothing");
                //hovering to womens tab
            mouseHover(driver,logger,"//*[@href='/womens-clothing']",0,"womens-clothing");
                //clicking womens dresses

            mouseHover(driver,logger,"//*[@href='/womens-clothing/dresses/cat550007']",0,"dresses");
                //clicking on shop by style
            click(driver,logger,"//*[@href='/womens-clothing/dresses/style/cat4480003']",0,"shopByStyle");
            driver.manage().deleteAllCookies();
                //give page loading time
            Thread.sleep(4000);
                //scrolling to first dress
            jse.executeScript("scroll(0,400)");
                //clicking on first dress
            click(driver,logger,"//*[contains(@alt , 'strapless')]",0,"addtoBag");

                //Choosing size

            click(driver,logger,"//*[@value = '" + size + "']",0,"clothingSize");
                //Click addToBag using absolute path (other classes weren't working)
            click(driver,logger,"//*[@id=\"content\"]/div/div/section/section[1]/section/button",0,"addToBag");
                //click check out
            click(driver,logger,"//*[@class = 'cta  last-step']",0,"checkout");
                //select quantity
            dropDown(driver,logger,"//*[@id = 'qdd-0-quantity']",0,quantity.get(i),"SelectQuantity");
                //click check out again
            click(driver,logger,"//*[@id = 'continue-to-checkout']", 0, "checkout2");
                //click check out as guest
            click(driver,logger,"//*[contains (text(), 'Continue as Guest')]",0,"checkoutAsGuest");

                //input first name
            sendKeys(driver,logger,"//*[@name = 'firstname']",0,firstName.get(i),"firstName");
                //input last name
            sendKeys(driver,logger,"//*[@name = 'lastname']",0,lastName.get(i),"lastName");
                //input email
            sendKeys(driver,logger,"//*[@id=\"contact-information\"]/form/div[3]/div/input",0,email.get(i),"email");
                //confirm email
            sendKeys(driver,logger,"//*[@id=\"contact-information\"]/form/div[4]/div/input",0,email.get(i),"confirmEmail");
                //input phone number
            sendKeys(driver,logger,"//*[@name = 'phone']",0,phoneNumber.get(i),"phoneNumber");
                //click continue
            click(driver,logger,"//*[@id=\"contact-information\"]/form/div[6]/button",0,"continueButton");
                //click continue again
            click(driver,logger,"//*[@id=\"delivery-and-pickup\"]/div/div/button",0,"continueButton0");
                //inputting address
            sendKeys(driver,logger,"//*[@name = 'shipping.line1']",0,address.get(i),"myAddress");
                //inputting postal code
            sendKeys(driver,logger,"//*[@name = 'shipping.postalCode']",0,zipCode.get(i),"postalCodes");
                //inputting city name
            sendKeys(driver,logger,"//*[@name = 'shipping.city']",0,city.get(i),"myCity");
                //selecting State from drop down menu
            dropDown(driver,logger,"//*[@name = 'shipping.state']", 0,State.get(i),"selectState");
                //clicking continue again
            click(driver,logger,"//*[contains (text(), 'Continue')]",0,"continueButton1");
                //send keys to credit card
            sendKeys(driver,logger,"//*[@name = 'creditCardNumber']",0,cardNumber.get(i),"cardNumber");
            driver.manage().deleteAllCookies();
            click(driver,logger,"//*[contains(text(),'Place Order')]",0,"placeOrder");
                //storing label

            String error = getText(driver,logger,"//*[@class = 'dOxMH labelError']",0,"text");


            //giving page time
            Thread.sleep(5000);

            System.out.println("=============================================");

            driver.manage().deleteAllCookies();






            i++;

            //end the test here


        }//end of loop




        }//end of test method











}//end of public class
