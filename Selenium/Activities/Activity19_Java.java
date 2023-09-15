package Activities;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open webpage, get title of page and print
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        System.out.println("Title of page is: "+ driver.getTitle());

        //perform activity
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text in alert window: " + alert.getText());
        alert.accept();

        driver.findElement(By.id("confirm")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();


        //quit
        driver.quit();

    }
}
