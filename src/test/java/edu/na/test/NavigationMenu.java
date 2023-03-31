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

public class NavigationMenu {
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
    public void HomeButtonAssertion() {
        driver.findElement(By.linkText("Home")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("homeButtonUrl"));
    } @Test
    public void CampusLifeButtonAssertion() {
        driver.findElement(By.linkText("Campus Life")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("campusLifeButtonUrl"));
    } @Test
    public void AcademicsButtonAssertion() {
        driver.findElement(By.linkText("Academics")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("academicsButtonUrl"));
    } @Test
    public void StudentsButtonAssertion() {
        driver.findElement(By.linkText("Students")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("studentsButtonUrl"));
    } @Test
    public void AlumniButtonAssertion() {
        driver.findElement(By.linkText("Alumni")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("alumniButtonUrl"));
    }
    @Test
    public void MyPagesButtonAssertion() {
        driver.findElement(By.linkText("My Pages")).click();
        Assert.assertEquals(driver.getCurrentUrl(),ConfigurationReader.get("myPagesButtonUrl"));
    }
}
