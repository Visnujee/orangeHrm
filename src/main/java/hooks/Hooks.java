package hooks;

import config.ConfigReader;
import driver.BrowserDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Fetch the browser value from TestNG's parameter
        String browser = System.getProperty("browser", "chrome");  // Default to chrome if not set
        System.out.println("Running tests on browser: " + browser);

        BrowserDriver.initDriver(browser);  // Initialize the WebDriver (Chrome or Edge)
        driver = BrowserDriver.getDriver();
        driver.get(ConfigReader.get("url"));  // Navigate to the URL from the config file
    }

    @After
    public void tearDown() {
        BrowserDriver.quitDriver();  // Quit the driver after the test
    }
}
