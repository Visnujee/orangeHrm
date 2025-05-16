package pages;

import base.BasePage;
import config.ConfigReader;
import constants.ElementLocators;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void login() {
        waitForPageToLoad();
        waitForElementVisible(ElementLocators.USERNAME_INPUT_XPATH);
        enterText(ElementLocators.USERNAME_INPUT_XPATH, ConfigReader.get("username"));
        enterText(ElementLocators.PASSWORD_INPUT_XPATH, ConfigReader.get("password"));
        clickElement(ElementLocators.LOGIN_BUTTON_XPATH);
    }
}
