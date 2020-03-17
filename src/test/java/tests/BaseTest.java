package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected static final String BROWSER = System.getenv("browser") != null ? System.getenv("browser") : "chrome";
    protected static final String GRID_URL = System.getenv("grid_url") != null ? System.getenv("grid_url") : "https://selenium:{PASSWORD}@seleniumhub.codecool.codecanvas.hu/wd/hub";
    protected static final String VALID_PW = System.getenv("default_pw");
    protected static WebDriver driver;

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        String fullGridUrl = GRID_URL.replace("{PASSWORD}", VALID_PW);
        switch (BROWSER) {
            case "chrome":
                driver = new RemoteWebDriver(new URL(fullGridUrl), new ChromeOptions());
                break;
            case "firefox":
                driver = new RemoteWebDriver(new URL(fullGridUrl), new FirefoxOptions());
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterAll
    protected static void tearDown() {
        if (driver != null) {driver.quit();}
    }
}
