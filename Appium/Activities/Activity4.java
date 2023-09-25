package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.contacts");
        options.setAppActivity(".activities.PeopleActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void contactsTest() {

        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
        WebElement fname= driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"));
        WebElement lname= driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']"));
        WebElement phn = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));

        fname.clear();
        lname.clear();
        phn.clear();
        fname.sendKeys("Aaditya");
        lname.sendKeys("Varma");
        phn.sendKeys("999148292");

        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Aaditya Varma\"]")));
        //Assert if contact added
        Boolean contactPresent = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Aaditya Varma\"]")).isDisplayed();
        Assert.assertEquals(contactPresent, true, "Contact not added");

        System.out.println("Contact Added");

    }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }


}
