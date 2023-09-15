package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Activity12_Java {

    public static void main(String[] args) {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage, get title of page and print to console
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of page is: " + driver.getTitle());

        // check if inputbox is selected and print result
        Boolean isEnabled = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Input Box enabled: " + isEnabled);
        Assert.assertEquals(isEnabled, false, "Input Box is enabled");


        //select the enable input button and print if it is enabled
        driver.findElement(By.id("toggleInput")).click();
        driver.findElement(By.id("input-text")).sendKeys("test");

        isEnabled = driver.findElement(By.id("input-text")).isEnabled();
        System.out.println("Input Box enabled: " + isEnabled);
        Assert.assertEquals(isEnabled, true, "Input Box is not Enabled");

        //quit driver
        driver.quit();

    }
}
