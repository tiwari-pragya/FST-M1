package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EditEmployee {



    @And("^User click on Edit Button$")
    public void editBtn(){

        LoginScenario.driver.findElement(By.id("btnSave")).click();
        LoginScenario.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @And("^User edits Name, Gender, Nationality and DOB fields$")
    public void editDetails(){

        LoginScenario.driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        LoginScenario.driver.findElement(By.id("personal_txtEmpLastName")).clear();
        LoginScenario.driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("New First");
        LoginScenario.driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("New Last");

        LoginScenario.driver.findElement(By.id("personal_optGender_2")).click();

        Select nationality = new Select(LoginScenario.driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        LoginScenario.driver.findElement(By.id("personal_DOB")).clear();
        LoginScenario.driver.findElement(By.id("personal_DOB")).click();
        LoginScenario.driver.findElement(By.id("personal_DOB")).sendKeys("2023-08-31");

        LoginScenario.driver.findElement(By.id("personal_txtEmpFirstName")).click();
    }

    @Then("^User clicks on Save$")
    public void saveBtn() throws InterruptedException {

        LoginScenario.driver.findElement(By.id("btnSave")).click();
        //LoginScenario.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = \"menu_dashboard_index\"]")));
        System.out.println("Details edited successfully");

    }



}
