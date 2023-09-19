package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinition"},
        tags = "@SmokeTest",
        //plugin = {"pretty"},
        plugin = {"html: test-reports"},
        monochrome = true
)
public class Activity6_TestRunner {
}
