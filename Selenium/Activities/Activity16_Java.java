package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity16_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage. get title of page and print
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("Title of page is: "+ driver.getTitle());

        //perform activity
        WebElement username = driver.findElement(By.xpath("//*[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//*[contains(@class, '-password')]"));
        WebElement cnfrPass = driver.findElement(By.xpath("//*[contains(@class, '-password')]/following::input"));
        WebElement email = driver.findElement(By.xpath("//*[contains(@class, 'email-')]"));
        WebElement signUpBtn = driver.findElement(By.xpath("//*[contains(@class, '-password')]/following::button"));

        username.sendKeys("test15_09_2023");
        password.sendKeys("qwerty@12345");
        cnfrPass.sendKeys("qwerty@12345");
        email.sendKeys("test15_09_2023@gmail.com");
        signUpBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Message printed on console: " + message);

        //quit driver
        driver.quit();

    }
}
