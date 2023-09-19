package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;

public class AlertTestStep {

    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void goTo(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimpleAlert(){

        driver.findElement(By.id("simple")).click();
    }

    @Then("^Alert opens$")
    public void alertOpens(){

        alert = driver.switchTo().alert();

    }

    @And("^Read the text from it and print it$")
    public void readText(){

        String text = alert.getText();
        System.out.println("Message on alert window: " + text);

    }

    @And("^Close the alert$")
    public void closeAlert(){

        alert.accept();

    }

    @And("^Read the result text$")
    public void readResult(){

        String result = driver.findElement(By.xpath("//p")).getText();
        System.out.println("Message: " + result);

    }

    @And("^Close Browser$")
    public void quit(){

        driver.quit();

    }

    @When("^User clicks the Confirm Alert button$")
    public void clickConfirmAlert(){

        driver.findElement(By.id("confirm")).click();

    }

    @And("^Close the alert with Cancel$")
    public void cancelAlert(){

        alert.dismiss();

    }

    @When("^User clicks the Prompt Alert button$")
    public void clickPromptAlert(){

        driver.findElement(By.id("prompt")).click();

    }

    @And("Write a custom message {string} in it")
    public void insertText(String s){

        alert.sendKeys(s);

    }

}
