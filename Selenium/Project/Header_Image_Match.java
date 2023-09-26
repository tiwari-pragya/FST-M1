package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Header_Image_Match {


    String title;

    String imageurl;

    @When("^User get the title of the page$")
    public void getTitle(){

        title = LoginScenario.driver.getTitle();
        System.out.println("Title of page: " + title);

    }

    @Then("^User validates it matches with 'OrangeHRM'$")
    public void verifyTitle(){

        Assert.assertEquals(title, "OrangeHRM", "Title not matched");


    }

    @When("^User fetches url of header image$")
    public void getURL(){

        imageurl = LoginScenario.driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).getAttribute("src");


    }

    @Then("^User prints url to console$")
    public void printURL(){

        System.out.println("Image URL: " + imageurl);


    }
}
