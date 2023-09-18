package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://v1.training-support.net/selenium/login-form");

    }

    @AfterClass
    public void afterMethod(){

        driver.quit();
    }

    @Test
    @Parameters ({"username", "password"})
    public void test(String username, String password){

        WebElement uname =driver.findElement(By.id("username"));
        WebElement pass =driver.findElement(By.id("password"));
        uname.sendKeys(username);
        pass.sendKeys(password);
        driver.findElement(By.xpath("//*[@class=\"ui button\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message is: " + message);
        Assert.assertEquals(message, "Welcome Back, admin", "Message doesn't match");

    }

}
