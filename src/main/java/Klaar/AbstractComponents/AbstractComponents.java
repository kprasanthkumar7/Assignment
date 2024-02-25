package Klaar.AbstractComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void waitAndCheckElementIsPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitAndClickWhenElementIsPresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void mouseOverOnElement(WebElement element){

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }
    public void moveToTheElementAndClick(WebElement element){

        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }
    public void moveToTheElementAndClickAndSendKeys(WebElement element,String text){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().sendKeys(text).build().perform();
    }


    public void moveToTheElementAndEnter(WebElement element){

        Actions action = new Actions(driver);

        action.sendKeys(element, Keys.ENTER).perform();


    }
    public void scrollToElement(WebElement element){

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element );

    }
     public void scrollToElementAndClick(WebElement element){

         JavascriptExecutor js= (JavascriptExecutor)driver;
         js.executeScript("arguments[0].scrollIntoView();",element );
         element.click();
     }



    public void scrollToTheTop() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(100,0)");
    }
    public boolean checkIsElementIsPresent(WebElement element){
        return element.isDisplayed();

    }
    public static Properties getProperties() throws IOException {

        String path = "C:\\Users\\Pavan\\IdeaProjects\\Assignment\\src\\test\\Resources\\config.properties";
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(path);
        prop.load(file);
        return prop;
    }

    public void backspaceButton_VK() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }
    public void enterButton_VK() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
