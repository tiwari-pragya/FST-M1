package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage, get title of page and print to console
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of page is: "+ driver.getTitle());

        //locate checkbox, button and click it and wait for checkbox to disappear
        WebElement button = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/input"));
        checkbox.click();
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        Thread.sleep(1000);

        //click button again and wait for checkbox to appear and click it to uncheck
        button.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();

        Thread.sleep(1000);

        //quit driver
        driver.quit();
    }
}
