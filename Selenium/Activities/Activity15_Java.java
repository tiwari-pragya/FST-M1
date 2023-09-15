package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        //get title of page and print
        System.out.println("Title of page is: "+ driver.getTitle());

        //locate element and enter details
        WebElement username = driver.findElement(By.xpath("//*[contains(@class, 'username-')]"));
        WebElement pass = driver.findElement(By.xpath("//*[contains(@class, 'password-')]"));
        WebElement login = driver.findElement(By.xpath("//*[contains(@class, 'password-')]/following::button"));
        username.sendKeys("admin");
        pass.sendKeys("password");
        login.click();

        //wait for login message and print
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("action-confirmation"))));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: "+ message);


        //quit driver
        driver.quit();
    }

}
