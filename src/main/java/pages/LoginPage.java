package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    private By profileIcon = By.xpath("//a[@id='header-details-user-fullname']");
    private By logout = By.xpath("//a[@id='log_out']");
    private By logoutWarning = By.xpath("//h1[text()='Logout']");

    // Methods
    private void navigateToLoginPage() {
        navigateToUrl("secure/Dashboard.jspa");
    }

    public void loginWithCredentials(String username, String password) {
        navigateToLoginPage();
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
    }

    public void logout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(profileIcon));
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(logout));
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutWarning));
    }
}


