package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open webpage
        driver.get("https://v1.training-support.net/selenium/login-form");

        //get title of page and print
        System.out.println("Title of main page is: "+ driver.getTitle());

        //locate username, password, button
        WebElement uname =driver.findElement(By.id("username"));
        WebElement pass =driver.findElement(By.id("password"));
        uname.sendKeys("admin");
        pass.sendKeys("password");
        driver.findElement(By.className("button")).click();

        Thread.sleep(1000);

        //quit driver
        driver.quit();
    }

}
