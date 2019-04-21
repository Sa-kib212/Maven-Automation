package Reusable_Classes;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

public class Reusable_Methods_Loggers {

    static int timeOut = 15;


    //method for navigating to a site
    public static WebDriver navigate(WebDriver driver, String url) throws IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");


        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("maximize", "incognito", "disable-infobars");

        //define the chrome web driver
        driver = new ChromeDriver(options);


        //navigate to usps.com
        driver.navigate().to(url);

        return driver;
    }

    //method to click on an element
    public static void click(WebDriver driver, ExtentTest logger, String locator, int index, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element" + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();

            logger.log(LogStatus.PASS,"Successfully Clicked on Element" + elementName);

        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenshot(driver,logger,elementName);

        }
    }//end of click method

    //method to enter on an element
    public static void sendKeys(WebDriver driver, ExtentTest logger, String locator, int index, String userInput, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("Entering value " + userInput + " on element " + elementName);
        logger.log(LogStatus.INFO,"Entering value " + userInput + " on element " + elementName);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.clear();
            element.sendKeys(userInput);
            logger.log(LogStatus.PASS,"Successfully SentKeys to Element" + elementName);

        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to enter on element " + elementName + " " + e);
            getScreenshot(driver,logger,elementName);

        }
    }//end of sendkeys method

    //method to hover to an element
    public static void mouseHover(WebDriver driver, ExtentTest logger, String locator, int index, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Actions mouse = new Actions(driver);
        System.out.println("Hovering to an element " + elementName);
        logger.log(LogStatus.INFO,"Hovering to an element " + elementName);


        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            mouse.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully mouseHovered on Element" + elementName);

        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " + e);
            getScreenshot(driver,logger,elementName);

        }
    }//end of mouse hover


    //method for get Title
    public static void getTitle(WebDriver driver, ExtentTest logger, String expectedTitle) throws IOException {
        //verify the title of the page matches with your expected
        String actualtitle = driver.getTitle();
        System.out.println("Performing getTitle, expected title is " +expectedTitle);
        logger.log(LogStatus.INFO,"Performing getTitle, expexted title is " + expectedTitle);


        if (actualtitle.equals(expectedTitle)) {
            System.out.println("Title matches");
            logger.log(LogStatus.PASS,"Title matches");

        } else {
            System.out.println("Title doesn't match - " + actualtitle);
            logger.log(LogStatus.FAIL,"Title doesn't match - " + actualtitle);
            getScreenshot(driver,logger,expectedTitle);


        }//end of if else

    }//end of get title method

    public static String getText(WebDriver driver, ExtentTest logger, String locator, int index, String elementName) throws IOException {
        String result = null;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("capturing text element from " + elementName);
        logger.log(LogStatus.INFO,"capturing text element from " + elementName);


        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            result = element.getText();
        } catch (Exception e) {

            System.out.println("Unable to locate element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to locate element " + elementName + " " + e);
            getScreenshot(driver,logger,elementName);


        }

        return result;
    }

    public static void dropDown(WebDriver driver, ExtentTest logger, String locator, int index, String input, String elementName) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);

        System.out.println("Selecting element from drop down menu");
        logger.log(LogStatus.INFO,"Selecting element from drop down menu");



        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            Select selectName = new Select(element);
            System.out.println("Successfully selected element");
            logger.log(LogStatus.PASS,"Successfully selected element " + elementName);

            selectName.selectByVisibleText(input);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
            logger.log(LogStatus.PASS,"Unable to select element " + elementName + " " + e);
            getScreenshot(driver,logger,elementName);


        }


    }

    public static void scrollToElement(WebDriver driver, String locator, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);

        WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);



    }

    public static void getScreenshot(WebDriver driver, ExtentTest logger, String screenshotName) throws IOException {
        String path = "src/main/java/Report_Folder/ScreenShots/";
        String fileName = screenshotName + ".png";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture("ScreenShots\\" + fileName);
        logger.log(LogStatus.FAIL, "", image);
    }

    public static String shortUUID() {

        UUID uuid = UUID.randomUUID();

        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();

        return Long.toString(l, Character.MAX_RADIX);

    }


}

