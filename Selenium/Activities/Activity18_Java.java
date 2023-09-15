package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity18_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open webpage. get title of page and print
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of page is: "+ driver.getTitle());

        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        Select select = new Select(multiSelect);

        //perform activity
        select.selectByVisibleText("Javascript");
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        select.selectByValue("node");
        select.deselectByIndex(5);

        System.out.println(driver.findElement(By.id("multi-value")).getText());

        //quit
        driver.quit();

    }
}
