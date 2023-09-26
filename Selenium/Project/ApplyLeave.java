package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;
import java.util.List;

public class ApplyLeave {

    @When("^User navigates to dashboard page and clicks on apply leave option$")
    public void navigateToPage(){

        LoginScenario.driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/leave/applyLeave");
    }

    @And("^User enters leave details and clicks on Apply$")
    public void addDetails() throws InterruptedException {

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtLeaveType")));
        WebElement dropdown = LoginScenario.driver.findElement(By.id("applyleave_txtLeaveType"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("DayOff");

        Thread.sleep(2000);

        LoginScenario.driver.findElement(By.id("applyleave_txtFromDate")).clear();
        LoginScenario.driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2023-11-01");
        LoginScenario.driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(Keys.TAB);
        //LoginScenario.driver.findElement(By.id("//*[@id=\"applyleave_txtFromDate\"]/following::img")).click();
        LoginScenario.driver.findElement(By.id("applyleave_txtToDate")).clear();
        LoginScenario.driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2023-11-01");
        LoginScenario.driver.findElement(By.id("applyleave_txtToDate")).sendKeys(Keys.TAB);
        //LoginScenario.driver.findElement(By.id("//*[@id=\"applyleave_txtToDate\"]/following::img")).click();
        Thread.sleep(2000);
        LoginScenario.driver.findElement(By.id("applyBtn")).click();
    }

    @Then("^User navigates to My Leave page to check the status of the leave application$")
    public void checkStatus() throws InterruptedException {

        Thread.sleep(2000);
        LoginScenario.driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("calFromDate")));

        LoginScenario.driver.findElement(By.id("calFromDate")).clear();
        LoginScenario.driver.findElement(By.id("calFromDate")).sendKeys("2023-11-01");
        LoginScenario.driver.findElement(By.id("calFromDate")).sendKeys(Keys.TAB);
        LoginScenario.driver.findElement(By.id("calToDate")).clear();
        LoginScenario.driver.findElement(By.id("calToDate")).sendKeys("2023-11-01");
        LoginScenario.driver.findElement(By.id("calToDate")).sendKeys(Keys.TAB);
        Thread.sleep(2000);
        LoginScenario.driver.findElement(By.id("btnSearch")).click();

        Thread.sleep(2000);
        String data = LoginScenario.driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[6]")).getText();
        System.out.println("Status of leave: " + data);
        Assert.assertEquals(data, "Pending Approval(1.00)", "Status Mismatch");
    }

}
