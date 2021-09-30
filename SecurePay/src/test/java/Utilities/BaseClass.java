package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public static WebDriver driver;

    public WebDriver getDriver() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void quitDriver() {
        if(driver!=null)
            driver.quit();
    }
}
