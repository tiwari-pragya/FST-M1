package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class Activity21_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        //get title of page and print
        System.out.println("Title of main page is: "+ driver.getTitle());

        //locate button and click
        WebElement button = driver.findElement(By.id("launcher"));
        button.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

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

        //wait for button to be clickable and click
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Title of 1st child page is: "+ driver.getTitle());
        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        //switch to 2nd new tab
        String firstChild = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String window : allWindowHandles){
            if (window != parentWindow && window != firstChild) {
                driver.switchTo().window(window);
            }
        }

        //quit driver
        driver.quit();
    }

}
