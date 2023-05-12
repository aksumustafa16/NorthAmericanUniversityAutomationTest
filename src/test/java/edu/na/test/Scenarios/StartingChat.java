package edu.na.test.Scenarios;

import edu.na.utilities.ConfigurationReader;
import edu.na.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StartingChat {
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
        driver.quit();
    }

    @Test
    public void ViewAssignmentFromCalender() throws InterruptedException {
        driver.findElement(By.id("myCourses-label")).click();
        driver.findElement(By.linkText("COMP 5393 1 - Capstone Project")).click();
        driver.findElement(By.linkText("Chat")).click();
        Thread.sleep(2000);
        driver.switchTo().frame("b7dea712-4d78-4dff-8045-4d2c5cd2ff38inputMessage_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Whit this chat box I will start the chat right now.");

    }
}
