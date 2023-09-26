package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class NewEmployeeAddition {


    String employeeId;
    String fname = "Cathy";
    String lname = "Jones";

    String fullname = "Cathy Jones";

    @When("^User clicks on PIM menu$")
    public void navigateToMenu(){

        LoginScenario.driver.findElement(By.id("menu_pim_viewPimModule")).click();
        LoginScenario.driver.findElement(By.id("menu_pim_viewEmployeeList")).click();


    }

    @And("^User clicks on Add Button to add employee$")
    public void goToAdd(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
        LoginScenario.driver.findElement(By.id("btnAdd")).click();

    }

    @And("^User fills in details and click on Save button$")
    public void addEmployee(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        LoginScenario.driver.findElement(By.id("firstName")).sendKeys(fname);
        LoginScenario.driver.findElement(By.id("lastName")).sendKeys(lname);
        employeeId = LoginScenario.driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println("Employee Id: " + employeeId);
        LoginScenario.driver.findElement(By.id("btnSave")).click();
    }

    @Then("^User navigates to Employee List tab on PIM page and verifies new user creation$")
    public void validateEmployee() throws InterruptedException {

        LoginScenario.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empPic")));
        LoginScenario.driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/pim/viewEmployeeList");
        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
        LoginScenario.driver.findElement(By.id("empsearch_employee_name_empName")).click();
        Thread.sleep(800);
        LoginScenario.driver.findElement(By.id("empsearch_employee_name_empName")).clear();
        Thread.sleep(1000);
        LoginScenario.driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(fullname);
        Thread.sleep(800);
        LoginScenario.driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Keys.TAB);
        Thread.sleep(800);
        LoginScenario.driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Keys.TAB);
        LoginScenario.driver.findElement(By.id("empsearch_id")).sendKeys(employeeId);
        Thread.sleep(500);
        LoginScenario.driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(2000);
        List<WebElement> idData = LoginScenario.driver.findElements(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]"));
        Boolean resultPresent = false;
        for(WebElement data : idData){
            if(data.getText().contains(employeeId)){
                resultPresent = true;
                System.out.println("Entered if loop");
                break;
            }
        }
        Assert.assertEquals(resultPresent, true, "Employee not added");
    }


}
