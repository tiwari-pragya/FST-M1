package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Activity7_Java {

    public static void main(String[] args){

        //setup system property for logs, firefox driver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //initialize action class
        Actions action = new Actions(driver);

        //open webpage and print title
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Title of page is: " + driver.getTitle());

        //perform activity action
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        action.dragAndDrop(ball, dropzone1).build().perform();
        String colour = dropzone1.getCssValue("background-color");
        System.out.println(colour);
        Assert.assertEquals(colour, "rgb(33, 186, 69)", "colour Mismatch for dropzone1");

        action.dragAndDrop(dropzone1, dropzone2).build().perform();
        colour = dropzone2.getCssValue("background-color");
        Assert.assertEquals(colour, "rgb(33, 186, 69)", "colour Mismatch for dropzone2");

        System.out.println("Action performed successfully");

        //close driver
        driver.quit();
    }
}
