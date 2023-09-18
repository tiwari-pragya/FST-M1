package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void beforeMethod(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }

    @AfterClass (alwaysRun = true)
    public void afterMethod(){

        driver.quit();
    }

    @Test (groups = {"HeaderTests"})
    public void test1(){

        String thirdHeader = driver.findElement(By.xpath("//h3[@id=\"third-header\"]")).getText();
        System.out.println("Text is: "+ thirdHeader);
        Assert.assertEquals(thirdHeader, "Third header", "Text doesn't match");

    }

    @Test (groups = {"HeaderTests"})
    public void test2(){

        String fifthHeader = driver.findElement(By.xpath("//h5[text()=\"Fifth header\"]")).getCssValue("color");
        System.out.println("Colour of fifth header is: "+ fifthHeader);
        Assert.assertEquals(fifthHeader, "rgb(33, 186, 69)", "Colour doesn't match");

    }

    @Test (groups = {"ButtonTests"})
    public void test3(){

        String btnText = driver.findElement(By.xpath("//button[text()= \"Olive\"]")).getText();
        System.out.println("Text of button is: "+ btnText);
        Assert.assertEquals(btnText, "Olive", "Text doesn't match");

    }

    @Test (groups = {"ButtonTests"})
    public void test4(){

        String btnClr = driver.findElement(By.xpath("//button[text()= \"Brown\"]")).getText();
        System.out.println("Color of button is: "+ btnClr);
        Assert.assertEquals(btnClr, "Brown", "Color doesn't match");

    }

}
