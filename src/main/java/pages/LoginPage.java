package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Fields
    private By usernameInputField = By.xpath("//input[@id='login-form-username']");
    private By passwordInputField = By.xpath("//input[@id='login-form-password']");
    private By loginButton = By.xpath("//input[@id='login']");
    private By invalidLoginMessage = By.xpath("//p[contains(text(), 'Sorry, your username and password are incorrect - please try again.')]");

    // Methods
    public void navigateToLoginPage() {
        navigateToUrl("/secure/Dashboard.jspa");
    }

    public void loginWithCredentials(String username, String password) {
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}


