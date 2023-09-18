package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {

    WebDriver driver;

    @BeforeClass
    public void beforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }

    @AfterClass
    public void afterMethod(){

        driver.quit();
    }

    @Test
    public void getTitle(){

        String pageTitle = driver.getTitle();
        System.out.println("Title of page is: " + pageTitle);
        Assert.assertEquals(pageTitle, "Target Practice", "Title doesn't match");

    }

    @Test
    public void findElement(){

        String btn = driver.findElement(By.xpath("//*[@class=\"ui black button\"]")).getText();
        Assert.assertEquals(btn, "black", "Text doesn't match");

    }

    @Test(enabled=false)
    public void skipTest(){

        System.out.println("Test enabled set to false");
    }

    @Test
    public void displaySkipTest(){

        throw new SkipException("Skipped test");

    }

}
