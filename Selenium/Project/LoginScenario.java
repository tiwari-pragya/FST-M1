package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScenario {

    public static WebDriver driver;
    public static WebDriverWait wait;
    WebElement username;
    WebElement password;

    @Given("^User Opens browser to the login page of OrangeHRM site$")
    public void openBrowser(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
    }

    @When("^User locates Username and Password Field$")
    public void locateFields(){

        username = driver.findElement(By.id("txtUsername"));
        password = driver.findElement(By.id("txtPassword"));
    }

    @And("^User enters login credential$")
    public void enterCredential(){

        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
    }

    @And("^User enters login credential as \".*\" and \".*\"$")
    public void enterCredentials(String uname , String pass){

        username.sendKeys(uname);
        password.sendKeys(pass);
    }


    @And("^User clicks on Login$")
    public void clickLoginButton(){

        driver.findElement(By.id("btnLogin")).click();
    }


    @Then("^User validates that homepage has opened$")
    public void validateHomepage(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = \"menu_dashboard_index\"]")));
        Boolean dashboardSelected = driver.findElement(By.xpath("//*[@id = \"menu_dashboard_index\"]")).isDisplayed();
        Assert.assertTrue(dashboardSelected, "User not on homepage.");
        System.out.println("User Logged in Successfully");
    }

    @And("^User closes the browser$")
    public void closeBrowser(){


        driver.quit();
    }

}
