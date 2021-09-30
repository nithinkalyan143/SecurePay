package com.pages;

import Utilities.CommonUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ElementIdentifiers {
    CommonUtilities utilities= new CommonUtilities();

    WebDriver driver;
    @FindBy(xpath = "//*[@title='Search']")
    WebElement searchBar;
    @FindBy(partialLinkText = "securepay.com.au")
    WebElement securePaylink;
    @FindBy(xpath = "//*[text()='Pricing']")
    WebElement pricing;
    @FindBy(partialLinkText = "Standard pricing")
    WebElement standardPricing;
    //     @FindBy(xpath = "//div[@Class='c-card-detail']/div/a")
    @FindBy(xpath = "//a[contains(@href,'https://www.polipayments.com/')]")
    WebElement poliLearnmore;
    @FindBy(partialLinkText = "Sell")
    WebElement sell;
    @FindBy(partialLinkText = "Make a sales enquiry")
    WebElement makeAsalesEnquiry;
    @FindBy(id = "Company")
    WebElement company;
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(id = "Description")
    WebElement enquiry;
    @FindBy(id = "Phone")
    WebElement phoneNo;
    @FindBy(id = "Website")
    WebElement website;
    @FindBy(id = "Email")
    WebElement emailId;

    public ElementIdentifiers(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void searchText() throws AWTException {
        searchBar.click();
        searchBar.sendKeys("SecurePay"+"\n");
    }
    public void navigateToSecurepay(){
        securePaylink.click();
    }
    public void clickPricing(){
        pricing.click();
    }
    public void clickStandardPricing(){
        Actions actions = new Actions(driver);
        actions.moveToElement(standardPricing).click().perform();
        //  standardPricing.click();
    }
    public boolean isUserLandOnStandardPricing() throws InterruptedException {
        Thread.sleep(5000);
        if(driver.getPageSource().contains("No regular, setup or hidden fees")){
            return true;
        }else{
            return false;
        }
    }
    public void clickPoliLearnMore(){
        utilities.scrollTillElement(driver,poliLearnmore);
        poliLearnmore.click();
    }
    public Boolean verifyPoliNewTab() throws InterruptedException {
        Thread.sleep(5000);
        utilities.switchToNewTab(driver);
        if(driver.getPageSource().contains("POLi Payments")){
            return true;
        }
        else{
            return false;
        }
    }

    public void clickMakeaSaleEnquiry(){
        Actions actions = new Actions(driver);
        actions.moveToElement(sell).perform();
        actions.moveToElement(makeAsalesEnquiry).click().perform();
    }
    public void enterCompanyName(){
        company.sendKeys(utilities.getRandomChars(12, "alphabetic"));
    }
    public void enterFirstName(){
        firstName.sendKeys(utilities.getRandomChars(6,"alphabetic"));
    }
    public void enterLastName(){
        lastName.sendKeys(utilities.getRandomChars(4,"alphabetic"));
    }
    public void enterEnquiry(){
        enquiry.sendKeys(utilities.getRandomChars(5,"alphabetic")+" "+utilities.getRandomChars(4,"alphabetic")+ " " +utilities.getRandomChars(6,"alphabetic"));
    }
    public void enterPhone(){
        phoneNo.sendKeys(utilities.getRandomChars(10,"numeric"));
    }
    public void enterWesite(){
        website.sendKeys("www."+utilities.getRandomChars(6,"alphabetic")+".com");
    }
    public void enterEmail(){
        emailId.sendKeys(utilities.getRandomChars(5,"alphaNumeric")+"@"+utilities.getRandomChars(4,"alphabetic")+".com");
    }

}
