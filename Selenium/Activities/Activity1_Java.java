package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open webpage
        driver.get("https://v1.training-support.net/");

        //get title of page and print
        System.out.println("Title of main page is: "+ driver.getTitle());

        //locate About Us button and click
        driver.findElement(By.id("about-link")).click();

        //wait for few second
        Thread.sleep(1000);

        //get title of new page and print
        System.out.println("Title of new page is: "+ driver.getTitle());

        //quit driver
        driver.quit();
    }
}
