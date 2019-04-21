package Reusable_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Reusable_Methods {

    static int timeOut = 100;


    //method for navigating to a site
    public static WebDriver navigate(WebDriver driver, String url) throws IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");


        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-fullscreen", "incognito", "disable-infobars");

        //define the chrome web driver
        driver = new ChromeDriver(options);

        //navigate to usps.com
        driver.navigate().to(url);

        return driver;
    }

    //method to click on an element
    public static void click(WebDriver driver, String locator, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("Clicking on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of click method

    //method to enter on an element
    public static void sendKeys(WebDriver driver, String locator, int index, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("Entering value " + userInput + " on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            element.clear();
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to enter on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //method to hover to an element
    public static void mouseHover(WebDriver driver, String locator, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        Actions mouse = new Actions(driver);
        System.out.println("Hovering to an element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            mouse.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouse hover


    //method for get Title
    public static void getTitle(WebDriver driver, String expectedTitle) {
        //verify the title of the page matches with your expected
        String actualtitle = driver.getTitle();
        if (actualtitle.equals(expectedTitle)) {
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match - " + actualtitle);
        }//end of if else

    }//end of get title method

    public static String getText(WebDriver driver, String locator, int index, String elementName) {
        String result = null;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        System.out.println("capturing text element from " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            result = element.getText();
        } catch (Exception e) {

            System.out.println("Unable to locate element " + elementName + " " + e);

        }

        return result;
    }

    public static void dropDown(WebDriver driver, String locator, int index, String input, String elementName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
            Select selectName = new Select(element);

            selectName.selectByVisibleText(input);
        } catch (Exception e) {
            System.out.println("Unable to select element " + elementName + " " + e);
        }


    }

    public static void scrollToElement(WebDriver driver, String locator, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);

        WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(index);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);


    }
}
