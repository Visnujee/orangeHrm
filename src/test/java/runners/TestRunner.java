package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // Path to feature files
        glue = {"stepdefinitions", "hooks"},     // Step definitions and hooks
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@chrome or @edge"  // Run tests for both Chrome and Edge
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
