package pages;

import base.BasePage;
import config.ConfigReader;
import constants.ElementLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
    }

    public void login() {
        waitForPageToLoad();
        waitForElementVisible(ElementLocators.USERNAME_INPUT_XPATH); // Wait for the username field to be visible
        enterText(ElementLocators.USERNAME_INPUT_XPATH, ConfigReader.get("username"));
        enterText(ElementLocators.PASSWORD_INPUT_XPATH, ConfigReader.get("password"));
        clickElement(ElementLocators.LOGIN_BUTTON_XPATH);
    }
}
