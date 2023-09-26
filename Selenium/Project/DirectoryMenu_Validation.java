package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DirectoryMenu_Validation {



    @And("^User validates that Directory Menu is visible$")
    public void validateMenuVisibility(){

        Boolean directoryMenu = LoginScenario.driver.findElement(By.xpath("//*[@id = \"menu_directory_viewDirectory\"]")).isDisplayed();
        Assert.assertTrue(directoryMenu, "Directory Menu is present on Page.");

    }

    @Then("^User clicks on Directory Menu$")
    public void menuClick() throws InterruptedException {

        LoginScenario.driver.findElement(By.id("menu_directory_viewDirectory")).click();
        LoginScenario.driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).click();
        LoginScenario.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"head\"]/h1")));
        String text = LoginScenario.driver.findElement(By.xpath("//*[@class=\"head\"]/h1")).getText();
        Assert.assertEquals(text, "Search Directory", "Matching Text not found");
        System.out.println("Navigated to Directory Page successfully.");
    }

}
