package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final int TIMEOUT = 10; // seconds


    public BasePage(WebDriver driver) {
        this.driver = driver;
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

    protected void waitForElementVisible(String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
