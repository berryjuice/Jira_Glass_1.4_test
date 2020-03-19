package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    static final int TIMEOUT = System.getenv("timeout") != null ? Integer.parseInt(System.getenv("timeout")) : 10;
    static final String BASE_URL = System.getenv("base_url") != null ? System.getenv("base_url") : "https://jira2.codecool.codecanvas.hu/";
    WebDriver driver;
    WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TIMEOUT);
    }

    void navigateToUrl(String urlPart) {
        driver.get(BASE_URL + urlPart);
    }
}
