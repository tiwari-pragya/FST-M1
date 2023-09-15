package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity13_Java {

    public static void main(String[] args) {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //open webpage, get title of page and print to console
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of page is: " + driver.getTitle());

        //perform activity
        List<WebElement> rows = driver.findElements(By.xpath("//*[@class=\"ui celled striped table\"]/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//*[@class=\"ui celled striped table\"]/tbody/tr[3]/td"));
        System.out.println("Total no. of rows: " + rows.size());
        System.out.println("Total no. of columns: " + columns.size());

        for (WebElement column : columns) {
            System.out.println("Value of 3rd row: " + column.getText());
        }

        String colValue = driver.findElement(By.xpath("//*[@class=\"ui celled striped table\"]/tbody/tr[2]/td[2]")).getText();
        System.out.println("Value of 2nd row & 2nd column: " + colValue);

        //quit driver
        driver.quit();
    }
}
