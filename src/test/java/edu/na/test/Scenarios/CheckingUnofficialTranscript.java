package edu.na.test.Scenarios;

import edu.na.utilities.ConfigurationReader;
import edu.na.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckingUnofficialTranscript {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("userName")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.id("siteNavBar_welcomeBackBarLoggedOut_JicsLoginRedirectContinue")).click();
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("password"));
        driver.findElement(By.name("siteNavBar$welcomeBackBarLoggedOut$ButtonLogin")).click();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void CheckingOverview() throws InterruptedException {
        driver.findElement(By.linkText("Academics")).click();
        driver.findElement(By.linkText("Grades")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("pg0_V_lnkViewTrans")).click();
    }
}