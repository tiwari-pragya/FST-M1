package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open homepage and perform actions perform activity 1
        driver.get("https://v1.training-support.net/");
        System.out.println("Title of main page is: "+ driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"about-link\"]")).click();
        System.out.println("Title of new page is: "+ driver.getTitle());
        //driver.close();

        //open login page and perform activity 2
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Title of main page is: "+ driver.getTitle());
        WebElement uname =driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement pass =driver.findElement(By.xpath("//*[@id=\"password\"]"));
        uname.sendKeys("admin");
        pass.sendKeys("password");
        driver.findElement(By.xpath("//*[@class=\"ui button\"]")).click();

        Thread.sleep(2000);

        //quit driver
        driver.quit();
    }

}
