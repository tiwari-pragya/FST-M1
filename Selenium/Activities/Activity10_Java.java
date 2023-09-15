package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Activity10_Java {

    public static void main(String[] args){

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        //get title of page and print to console
        System.out.println("Title of page is: "+ driver.getTitle());

        Boolean isVisible = driver.findElement(By.xpath("//*[@name=\"toggled\"]")).isDisplayed();
        System.out.println("Checkbox is visible: " + isVisible);
        Assert.assertEquals(isVisible, true, "Checkbox is not visible");

        driver.findElement(By.id("toggleCheckbox")).click();

        isVisible = driver.findElement(By.xpath("//*[@name=\"toggled\"]")).isDisplayed();
        System.out.println("Checkbox is visible: " + isVisible);
        Assert.assertEquals(isVisible, false, "Checkbox is visible");

        //quit driver
        driver.quit();

    }
}
