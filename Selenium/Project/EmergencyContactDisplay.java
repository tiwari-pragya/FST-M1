package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class EmergencyContactDisplay {


    @When("^User navigates to MyInfo Page$")
    public void navigateToInfoMenu(){

        LoginScenario.driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        LoginScenario.driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();


    }

    @And("^User locates the left hand menu and clicks on Emergency Contact menu$")
    public void locateMenu(){

        LoginScenario.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"sidenav\"]/li[3]/a")));
        LoginScenario.driver.findElement(By.xpath(" //*[@id=\"sidenav\"]/li[3]/a")).click();

    }

    @Then("^User retrieves information of all the contacts listed and prints the information$")
    public void getInfo(){

        LoginScenario.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emgcontact_list")));
        List<WebElement> rowHeader = LoginScenario.driver.findElements(By.xpath("//*[@id = \"emgcontact_list\"]/thead/tr/th"));
        System.out.println("Header values: ");
        for(WebElement cell : rowHeader) {
                System.out.println(cell.getText());
        }
        List<WebElement> allRows = LoginScenario.driver.findElements(By.xpath("//*[@id = \"emgcontact_list\"]/tbody/tr"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.println(cell.getText());
            }
        }

    }

}
