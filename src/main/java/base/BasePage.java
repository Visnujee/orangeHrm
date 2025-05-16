package base;

import driver.BrowserDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;  // Accessible in all page classes

    private final int TIMEOUT = 10;

    public BasePage() {
        this.driver = BrowserDriver.getDriver();  // Get from ThreadLocal
    }

    protected void enterText(String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    protected String getElementText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    protected boolean isElementDisplayed(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void waitForElementVisible(String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    protected void scrollToElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
