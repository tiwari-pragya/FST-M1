package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_Java {

    public static void main(String[] args) throws InterruptedException {

        //setup system property for logs, firefoxdriver and create object of webdriver
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        //open webpage
        driver.get("https://v1.training-support.net/selenium/target-practice");

        //get title of page and print to console
        System.out.println("Title of page is: "+ driver.getTitle());

        //locate element using xpath
        String thirdHeader = driver.findElement(By.xpath("//h3[@id=\"third-header\"]")).getText();
        System.out.println("Text of third header is: "+ thirdHeader);
        String fifthHeader = driver.findElement(By.xpath("//h5[text()=\"Fifth header\"]")).getCssValue("color");
        System.out.println("Colour of fifth header is: "+ fifthHeader);

        //String className = driver.findElement(By.xpath("//button[text()=\"Violet\"]")).getAttribute("class");
        String className = driver.findElement(By.className("violet")).getAttribute("class");
        System.out.println("Classname is: "+ className);
        //String btnText = driver.findElement(By.xpath("//button[text()=\"Grey\"]")).getText();
        String btnText = driver.findElement(By.className("grey")).getText();
        System.out.println("Text is: "+ btnText);

        //quit driver
        driver.quit();
    }
}
