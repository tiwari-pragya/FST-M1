package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Activity11_Java {

    public static void main(String[] args){

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage, get title of page and print to console
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("Title of page is: "+ driver.getTitle());

        // check if checkbox is selected and print result
        Boolean isSelected = driver.findElement(By.xpath("//*[@name=\"toggled\"]")).isSelected();
        System.out.println("Checkbox selected: " + isSelected);
        Assert.assertEquals(isSelected, false, "Checkbox is selected");


        //select the checkbox and print if it is selected
        driver.findElement(By.xpath("//*[@name=\"toggled\"]")).click();
        isSelected = driver.findElement(By.xpath("//*[@name=\"toggled\"]")).isSelected();
        System.out.println("Checkbox selected: " + isSelected);
        Assert.assertEquals(isSelected, true, "Checkbox is not selected");

        //quit driver
        driver.quit();

    }
}
