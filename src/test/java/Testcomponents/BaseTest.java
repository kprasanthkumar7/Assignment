package Testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.klaarhq.com/auth/sign_in?returnUrl=%2Fprofile");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
   @AfterSuite
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
    public String takeScreenShot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        String path =System.getProperty("user.dir") + "//reports//failedTests//" + testCaseName + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

}
