package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void before(){

        driver.switchTo().defaultContent();

    }

    @BeforeTest
    public void setup(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Reporter.log("Starting Test |");
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Title of page: " + driver.getTitle());
        System.out.println("Title of page: " + driver.getTitle());

    }

    @AfterTest
    public void tearDown(){

        driver.quit();
        Reporter.log("Driver closed!");

    }

    @Test
    public void simpleAlertTestCase(){

        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched to Alert");
        Reporter.log("Text in simple alert window: " + alert.getText());
        System.out.println("Text in simple alert window: " + alert.getText());
        Assert.assertEquals(alert.getText(), "This is a JavaScript Alert!", "Alert message mismatch");
        alert.accept();
        Reporter.log("Closed Alert.");

    }

    @Test
    public void confirmAlertTestCase(){

        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched to Alert");
        Reporter.log("Text in confirm alert window: " + alert.getText());
        System.out.println("Text in confirm alert window: " + alert.getText());
        Assert.assertEquals(alert.getText(), "This is a JavaScript Confirmation!", "Alert message mismatch");
        alert.accept();
        Reporter.log("Closed Alert.");

    }

    @Test
    public void promptAlertTestCase(){

        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Reporter.log("Switched to Alert");
        Reporter.log("Text in prompt alert window: " + alert.getText());
        System.out.println("Text in prompt alert window: " + alert.getText());
        alert.sendKeys("Test Message");
        Assert.assertEquals(alert.getText(), "This is a JavaScript Prompt!", "Alert message mismatch");
        alert.accept();
        Reporter.log("Closed Alert.");

    }

}
