package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSHGPage extends Page {
    // Constructor
    public ProjectSHGPage(WebDriver driver) {
        super(driver);
    }

    // Fields
    private By projectTitle = By.xpath("//h1[text()='Shattered Glass - Project Configuration Documentation']");
    private By issueTypes = By.xpath("//li[@id='glass-workflow-nav']");
    private By improvement = By.xpath("//span[contains(text), 'Improvement']");
    private By issueTypeTitle = By.xpath("//h2[contains(text), 'Selected issue type - ']");
    private By workflowTransitionsToTestAllInReview = By.xpath("//b[text()='ToTestAll']//ancestor::td//following-sibling::td/span");

    // Methods
    public void navigateToSHGPage() {
        navigateToUrl("secure/Dashboard.jspa");
    }

    public String getProjectTitle() {
        navigateToUrl("/projects/SHG");
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(projectTitle)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean selectWorkflow() {
        driver.findElement(issueTypes).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(improvement)).click();
        return wait.until(ExpectedConditions.presenceOfElementLocated(issueTypeTitle)).isDisplayed();
    }
}
