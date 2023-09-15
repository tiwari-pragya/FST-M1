package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize action class
        Actions action = new Actions(driver);

        //open webpage and print title
        driver.get("https://v1.training-support.net/selenium/input-events");
        System.out.println("Title of page is: "+ driver.getTitle());

        //perform click operation
        action.click().pause(1000).build().perform();
        //String text = driver.findElement(By.className("active")).getText();
        //System.out.println("Value of side after left click: " + text);
        System.out.println("Value of side after left click: " + driver.findElement(By.xpath("//*[@class=\"active\"]")).getText());

        action.doubleClick().pause(1000).build().perform();
        action.pause(1000).build().perform();
        //text = driver.findElement(By.className("active")).getText();
        //System.out.println("Value of side after double click: " + text);
        System.out.println("Value of side after double click: " + driver.findElement(By.xpath("//*[@class=\"active\"]")).getText());

        action.contextClick().pause(1000).build().perform();
        //text = driver.findElement(By.className("active")).getText();
        //System.out.println("Value of side after right click: " + text);
        System.out.println("Value of side after right click: " + driver.findElement(By.xpath("//*[@class=\"active\"]")).getText());

        //close driver
        driver.quit();

    }
}
