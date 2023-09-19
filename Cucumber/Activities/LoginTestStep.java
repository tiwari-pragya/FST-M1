package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginTestStep {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login Page$")
    public void navigateToLogin(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/login-form");

    }

    @When("^User enters username and password$")
    public void enterCred(){

        WebElement uname =driver.findElement(By.id("username"));
        WebElement pass =driver.findElement(By.id("password"));
        uname.sendKeys("admin");
        pass.sendKeys("password");
        driver.findElement(By.xpath("//*[@class=\"ui button\"]")).click();

    }

    @Then("^User reads the page title and confirmation message$")
    public void validatePage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Message on screen is: " + message);
        //Assert.assertEquals(message, "Welcome Back, admin", "Incorrect message printed");

        if(message.contains("admin")) {
            Assert.assertEquals(message, "Welcome Back, admin", "Incorrect message printed");
        } else {
            Assert.assertEquals(message, "Invalid Credentials", "Incorrect message printed");
        }
    }

    @Then("^User closes the browser$")
    public void closeBrowser() {

        driver.quit();

    }

    @When("User enters {string} and {string}")
    public void userEntersAnd(String uname, String pass) {

        driver.findElement(By.id("username")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@class=\"ui button\"]")).click();

    }
}
