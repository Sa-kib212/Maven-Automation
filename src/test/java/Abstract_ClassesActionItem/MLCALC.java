package Abstract_ClassesActionItem;

import Reusable_Classes.Abstract_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class MLCALC extends Abstract_Class {

    @Test

    public void TC_02_MLCALC() throws InterruptedException, IOException {


//Create list of array using ArrayList

//list for purchase price
        ArrayList<String> pPrice =new ArrayList<String>();
        pPrice.add("320000");
        pPrice.add("330000");
        pPrice.add("340000");
        pPrice.add("350000");
//list for down payment
        ArrayList<String> dPayment = new ArrayList<String >();
        dPayment.add("21");
        dPayment.add("25");
        dPayment.add("28");
        dPayment.add("30");
//list for the interest rate
        ArrayList<String> intRate = new ArrayList<String>();
        intRate.add("4.2");
        intRate.add("5.1");
        intRate.add("6");
        intRate.add("7.5");

//list for PMI
        ArrayList<String> pmiValue = new ArrayList<String>();
        pmiValue.add("1");
        pmiValue.add("2");
        pmiValue.add("3");
        pmiValue.add("4");
//List for start month
        ArrayList<String> startMnt = new ArrayList<String>();
        startMnt.add("Feb");
        startMnt.add("Mar");
        startMnt.add("Apr");
        startMnt.add("May");
//List for start year
        ArrayList<String> startYr = new ArrayList<String>();
        startYr.add("2019");
        startYr.add("2017");
        startYr.add("2022");
        startYr.add("2026");

        for(int i =0; i<startMnt.size();i++){
//Navigate to ml calc
        driver.navigate().to("https://www.mlcalc.com");
//Wait a few seconds
            Thread.sleep(1000);
//Get HomePage Title
         String homePageTitle = driver.getTitle();
         if (homePageTitle.equals("Mortgage Calculator & Loan Calculator")){
             System.out.println("The titles match");
         } else {
             System.out.println("The title did not match and it is " +homePageTitle);
         }
//Purchase Values
      sendKeys(driver,logger,"//*[@name='ma']",0,pPrice.get(i),"purchaseP");

//Down Payment Values
            sendKeys(driver,logger,"//*[@name='dp']",0,dPayment.get(i),"downP");

//Interest Rate Values
            WebElement interestR,button;
            interestR = driver.findElement(By.xpath("//*[@name='ir']"));
            interestR.clear();
            Thread.sleep(1000);
            interestR.sendKeys(intRate.get(i));
            Thread.sleep(1000);
           // sendKeys(driver,logger,"//*[@name='ir']",0,dPayment.get(i),"downP");


//PMI values
            sendKeys(driver,logger,"//*[@name='mi']",0,pmiValue.get(i),"PMI");

//Start Month
            dropDown(driver,logger,"//*[@id=\"mortgageForm\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/select[1]",0,startMnt.get(i),"stM");

//Start Year
            dropDown(driver,logger,"//*[@id=\"mortgageForm\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[10]/td[2]/select[2]",0,startYr.get(i),"stY");

//Clicking button
            Thread.sleep(1000);
            button= driver.findElement(By.xpath("//*[@class='button-calculate action']"));
            button.click();
            //click(driver,logger,"//*[@class='button-calculate action']",0,"button");


//Storing Monthly Payment into a variable
            String monthlyPayment = getText(driver,logger,"//*[@class='big']",0,"payment");
        //String monthlyPayment = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
//Storing End Payment date into a variable
            String Payoff = getText(driver,logger,"//*[@class='big']",2,"payoff");
       // String payoff = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();

//Giving Website time to load
            Thread.sleep(3000);

         System.out.println("The monthly payment is " +monthlyPayment+
                 " and the pay off date is " + Payoff);






        }
        driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(1000);
        //Original Purchase Price
        String attributePrice = driver.findElement(By.xpath("//*[@name='ma']")).getAttribute("value");
        System.out.println("My default price was $" + attributePrice);
            Thread.sleep(1000);


    }



}
