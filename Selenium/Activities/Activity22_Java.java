package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class Activity22_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage, get title of page and print
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Title of main page is: "+ driver.getTitle());

        String data = driver.findElement(By.xpath("//*[@class=\"ui huge inverted orange button\"]")).getAttribute("data-tooltip");
        System.out.println("Tool tip text: " + data);

        driver.findElement(By.xpath("//*[@class=\"ui huge inverted orange button\"]")).click();

        //get windowhandles
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        //print all window handles
        for(String window : windowHandles){
            System.out.println("Window Handle: "+ window);
        }

        //switch to new tab
        for(String window : windowHandles){
            if (window != parentWindow) {
                driver.switchTo().window(window);
            }
        }

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"password\"]/following::button"));

        userName.sendKeys("admin");
        password.sendKeys("password");
        btn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println("Text on screen: " + driver.findElement(By.id("action-confirmation")).getText());

        //quit driver
        driver.quit();
    }
}
