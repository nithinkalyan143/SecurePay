package Utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Locale;

public class CommonUtilities {

public void scrollTillElement(WebDriver driver, WebElement element){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
}
    public void scrollTillEndofthePage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void switchToNewTab(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getRandomChars(int length, String ranDataType) {
        String randomChars="";
        switch (ranDataType.toLowerCase()) {
            case "numeric":
                randomChars = RandomStringUtils.randomNumeric(length);
                break;
            case "alphanumeric":
                randomChars = RandomStringUtils.randomAlphanumeric(length);
                break;
            case "alphabetic":
                randomChars = RandomStringUtils.randomAlphabetic(length);
                break;
        }
        return randomChars.toLowerCase();
    }

}
