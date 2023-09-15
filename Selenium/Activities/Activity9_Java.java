package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage and print title
        driver.get("https://v1.training-support.net/selenium/ajax");
        System.out.println("Title of page is: " + driver.getTitle());

        //perform activity
        driver.findElement(By.xpath("//*[@class=\"ui violet button\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h1")));
        String text = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3")).getText();
        System.out.println("Text on Page: " + text);
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"ajax-content\"]/h3"), "I'm late!"));
        String lateText = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3")).getText();
        System.out.println("Late text on Page: " + lateText);

        //quit driver
        driver.quit();
    }
}
