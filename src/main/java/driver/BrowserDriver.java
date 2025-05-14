package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserDriver {
    // ThreadLocal ensures each test has its own WebDriver instance
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        // Ensure the driver is initialized once per thread (test)
        if (driver.get() == null) {  // Only initialize once per test run
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get().manage().window().maximize();  // Maximize window
            System.out.println("Driver initialized for " + browser + " on Thread ID: " + Thread.currentThread().getId());
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver has not been initialized for this thread.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();  // Quit the driver and remove the instance
            driver.remove();  // Clear the ThreadLocal reference
            System.out.println("Driver quit for Thread ID: " + Thread.currentThread().getId());
        }
    }
}
