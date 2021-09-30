package com.steps;

import Utilities.BaseClass;
import com.pages.ElementIdentifiers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;


public class SecurePayContactUsForm {
    private static Logger logger = LogManager.getLogger(SecurePayContactUsForm.class);
    static WebDriver driver;
    BaseClass baseClass = new BaseClass();
    @BeforeClass
        public void setUp(){
            driver = baseClass.getDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://google.com.au");
            logger.info("User launched the browser");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void fillContactUsForm() throws AWTException, InterruptedException {
      ElementIdentifiers elementIdentifiers = new ElementIdentifiers(driver);
       elementIdentifiers.searchText();
       logger.info("User searched with text SecurePay in google searchbar");
       elementIdentifiers.navigateToSecurepay();
       logger.info("user clicked on securepay.com.au");
       elementIdentifiers.clickPricing();
       logger.info("user clicked on pricing tab");
       elementIdentifiers.clickStandardPricing();
       logger.info("user clicked on Standard Pricing link");
       Assert.assertTrue(elementIdentifiers.isUserLandOnStandardPricing(),"Standard Pricing screen is not loaded");
       logger.error("Standard pricing is not loaded");
       logger.info("user successfully land on Standard pricing tab");
       elementIdentifiers.clickPoliLearnMore();
       Assert.assertTrue(elementIdentifiers.verifyPoliNewTab(),"POLi is not opened in New tab");
       logger.error("POLi new tab is not opened");
       elementIdentifiers.clickMakeaSaleEnquiry();
       logger.info("Contact us details are entering in the form");
       elementIdentifiers.enterCompanyName();
       elementIdentifiers.enterFirstName();
       elementIdentifiers.enterLastName();
       elementIdentifiers.enterEnquiry();
       elementIdentifiers.enterWesite();
       elementIdentifiers.enterPhone();
       elementIdentifiers.enterEmail();

    }

    @AfterClass
    public void teardown(){
        baseClass.quitDriver();
    }

}
