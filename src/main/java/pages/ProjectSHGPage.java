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
    private By issueTypes = By.xpath("//li[@id='glass-workflow-nav']//a[@class='glass-dropdown']//div[@aria-owns='dropdown-issuetypes']");
    private By workflowTransitionsToTestAllInReview = By.xpath("//div[@role='group']//a[@role='menuitem']//span[text()=' Improvement']");
    private By issueTypeTitle = By.xpath("//h2[@id='glass-workflow-panel-title']");
    private By transitionName = By.xpath("//tr[@class='transition-row']//td[@class='transition-name']//span//b[text()='ToTestAll']");
    private By fromStatus = By.xpath("//b[text()='ToTestAll']//ancestor::td//following-sibling::td/span");

    // Methods
    public void navigateToSHGPage() {
        navigateToUrl("projects/SHG");
    }

    public String getProjectTitle() {
        navigateToSHGPage();
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(projectTitle)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String selectWorkflow() {
        navigateToSHGPage();
        driver.findElement(issueTypes).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(workflowTransitionsToTestAllInReview)).click();
        return driver.findElement(issueTypeTitle).getText();
    }

    public String checkWorkflowStatus() {
        selectWorkflow();
        return driver.findElement(fromStatus).getText();

    }
}
