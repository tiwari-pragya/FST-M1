package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeeQualification {


    @And("^User locates the left hand menu and clicks on Qualifications menu$")
    public void clickMenu(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"sidenav\"]/li[9]/a")));
        LoginScenario.driver.findElement(By.xpath(" //*[@id=\"sidenav\"]/li[9]/a")).click();

    }

    @And("^User clicks on Add Button to add qualification details$")
    public void clickAdd(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id =\"addWorkExperience\"]")));
        LoginScenario.driver.findElement(By.xpath("//*[@id =\"addWorkExperience\"]")).click();

    }

    @And("^User adds qualification details$")
    public void addQual(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("btnWorkExpSave")));
        LoginScenario.driver.findElement(By.id("experience_employer")).sendKeys("FST_M1_11_09_company");
        LoginScenario.driver.findElement(By.id("experience_jobtitle")).sendKeys("FST_M1_11_09_jobtitle");

    }

    @Then("^User saves information$")
    public void saveInfo(){

        LoginScenario.driver.findElement(By.id("btnWorkExpSave")).click();

    }
}
