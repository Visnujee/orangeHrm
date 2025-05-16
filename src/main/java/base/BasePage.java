package base;

import driver.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final int TIMEOUT = 10;

    protected void enterText(String xpath, String text) {
        WebElement element = BrowserDriver.getDriver().findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(String xpath) {
        BrowserDriver.getDriver().findElement(By.xpath(xpath)).click();
    }

    protected String getElementText(String xpath) {
        return BrowserDriver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    protected void waitForElementVisible(String xpath) {
        new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(BrowserDriver.getDriver(), Duration.ofSeconds(TIMEOUT)).until(
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }
}
