package stepdefinitions;

import driver.BrowserDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    LoginPage lg =new LoginPage();


    @When("User enter valid credentials")
    public void user_enter_valid_credentials() {
        lg.login();
    }

    @Then("User should land on dashboard")
    public void user_should_land_on_dashboard() {
        assert BrowserDriver.getDriver().getTitle().contains("OrangeHRM");
    }
}
