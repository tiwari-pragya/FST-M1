package Appium_Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Project_Activity_2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity("com.google.android.apps.keep.ui.activities.BrowseActivity");
        options.noReset();

        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        driver= new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

    }

    @Test
    public void addTasksInKeep() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("edit_note_text")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Appium_Test1");
        driver.findElement(AppiumBy.id("edit_note_text")).click();
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Appium_Test1_description");
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("New text note")));

        Boolean notePresent = driver.findElement(AppiumBy.accessibilityId("Appium_Test1. . ")).isDisplayed();

        Assert.assertEquals(notePresent, true, "Note not present");
        System.out.println("Note added successfully");
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
