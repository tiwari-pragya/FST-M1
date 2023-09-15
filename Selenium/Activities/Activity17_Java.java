package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Activity17_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();


        //open webpage. get title of page and print
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Title of page is: "+ driver.getTitle());

        //perform activity
        WebElement singleSelect = driver.findElement(By.id("single-select"));
        Select select = new Select(singleSelect);
        select.selectByVisibleText("Option 2");
        System.out.println("Value of Select by Visible Text: " + select.getFirstSelectedOption().getText());
        select.selectByIndex(3);
        System.out.println("Value of Select by Index: " + select.getFirstSelectedOption().getText());
        select.selectByValue("4");
        System.out.println("Value of Select by Value: " + select.getFirstSelectedOption().getText());

        System.out.println("All options of Single Select: ");
        System.out.println(singleSelect.getText());

        //quit driver
        driver.quit();

    }
}
