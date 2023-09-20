package Appium_Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project_Activity_3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverUrl, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testToDoList() throws InterruptedException {

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.get("https://v1.training-support.net/selenium");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));

        //click on To-Do List Menu
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"To-Do List\")")).click();
        WebElement taskInput = driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")"));

        //add to-do's
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        taskInput.click();
        taskInput.sendKeys("Add tasks to list");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.TAB));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        taskInput.click();
        taskInput.sendKeys("Get number of tasks");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.TAB));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        taskInput.click();
        taskInput.sendKeys("Clear the list");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((3)));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.TAB));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));


        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add tasks to list\")")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((5)));
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Get number of tasks\")")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((5)));
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Clear the list\")")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((5)));

        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\" Clear List\")")).click();

        Thread.sleep(1000);
        List<WebElement> tasksPresent = driver.findElements(AppiumBy.androidUIAutomator("resourceId(\"tasksList\")"));
        int taskPresent = tasksPresent.size();
        Assert.assertEquals(taskPresent, 0, "Test Failed");

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
