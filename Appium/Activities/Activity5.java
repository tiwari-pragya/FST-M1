package Activities;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class Activity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public void smsTest() {

        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("recipient_text_view")));
        WebElement phnNo= driver.findElement(AppiumBy.id("recipient_text_view"));
        phnNo.clear();
        phnNo.sendKeys("7543945211");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("compose_message_text")));

        WebElement messageField= driver.findElement(AppiumBy.id("compose_message_text"));
        messageField.sendKeys("Hello from Appium");

        driver.findElement(AppiumBy.id("send_message_button_container")).click();

        //Assert if message sent
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("You said, Hello from Appium, Now, SMS")));
        Boolean msgSent = driver.findElement(AppiumBy.accessibilityId("You said, Hello from Appium, Now, SMS")).isDisplayed();
        Assert.assertEquals(msgSent, true, "Message not sent");

        System.out.println("Message sent successfully");

    }



    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
