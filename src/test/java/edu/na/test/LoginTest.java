package edu.na.test;

import edu.na.utilities.ConfigurationReader;
import edu.na.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void PositiveUsernameTest() {
        driver.findElement(By.id("userName")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue")).click();
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.name("siteNavBar$welcomeBackBarLoggedOut$ButtonLogin")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://portal.na.edu/ICS/");
    }

    @Test
    public void NegativeUsernameTest() {
        driver.findElement(By.id("userName")).sendKeys("mustafa");
        driver.findElement(By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue")).click();
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.name("siteNavBar$welcomeBackBarLoggedOut$ButtonLogin")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://portal.na.edu/ics/");
    }
    @Test
    public void PositivePasswordTest() {
        driver.findElement(By.id("userName")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue")).click();
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.name("siteNavBar$welcomeBackBarLoggedOut$ButtonLogin")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://portal.na.edu/ICS/");
    }

    @Test
    public void NegativePasswordTest() {
        driver.findElement(By.id("userName")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue")).click();
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.name("siteNavBar$welcomeBackBarLoggedOut$ButtonLogin")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://portal.na.edu/ics/");
    }
}
