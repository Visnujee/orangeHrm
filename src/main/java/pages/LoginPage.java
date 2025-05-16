package pages;

import base.BasePage;
import config.ConfigReader;
import constants.ElementLocators;

public class LoginPage extends BasePage {

    public void login() {
        enterText(ElementLocators.USERNAME_INPUT_XPATH, ConfigReader.get("username"));
        enterText(ElementLocators.PASSWORD_INPUT_XPATH, ConfigReader.get("password"));
        clickElement(ElementLocators.LOGIN_BUTTON_XPATH);
        waitForPageToLoad();
    }
}
