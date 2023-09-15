package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6_Java {

    public static void main(String[] args) {

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize action class
        Actions action = new Actions(driver);

        //open webpage and print title
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of page is: " + driver.getTitle());

        //perform activity actions
        action.sendKeys("P").build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Close browser
        driver.close();

    }
}
