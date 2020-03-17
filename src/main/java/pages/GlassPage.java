package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class GlassPage extends Page {
    private By general = By.xpath("//li[@id='glass-general-nav']/a");
    private By issueTypes = By.xpath("//li[@id='glass-workflow-nav']/a");
    private By improvementIssueType = By.xpath("//*[@data-issue-type='Improvement']/a");
    private By permissions = By.xpath("//li[@id='glass-permissions-nav']/a");

    private By componentsTab = By.xpath("//a[@id='aui-uid-1']");
    private By versionsTab = By.xpath("//a[@id='aui-uid-2']");
    private By schemesTab = By.xpath("//a[@id='aui-uid-3']");

    private By basicSummaryLink = By.xpath("//h2[contains(text(), 'Basic Summary')]/a");
    private By componentsLink = By.xpath("//h2[span[contains(text(), 'Components')]]/a");
    private By permissionsLink = By.xpath("//h2[span[contains(text(), 'Permission')]]/a");
    private By workflowLink = By.xpath("//h2[span[contains(text(), 'Workflow')]]/a");

    private By showTransitionLabels = By.xpath("//input[@id='show-transition-labels']");
    private By workflowLabels = By.xpath("//div[@id='workflow-designer1']/svg/text");

    private By workflowQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/workflows')]");
    private By screensQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/screens')]");
    private By basicSummaryQuickLink = By.xpath("//a[contains(@href, '/secure/project/EditProject!default.jspa?pid=10101')]");
    private By schemesQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/summary')]");
    private By componentsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/administer-components')]");
    private By versionsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/administer-versions')]");
    private By peopleQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/roles')]");
    private By permissionsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/permissions')]");
    private By notificationsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/notifications')]");

    public GlassPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGlass() {
        super.navigateToUrl("projects/SHG?selectedItem=com.codecanvas.glass:glass");
    }

    public void navigateToSelectedIssueTypePage() {
        navigateToGlass();
        driver.findElement(issueTypes).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(improvementIssueType)).click();
    }

    public void clickShowTransitionLabels() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(showTransitionLabels));
        wait.until(ExpectedConditions.elementToBeClickable(showTransitionLabels)).click();
    }

    public boolean allLabelsVisible() {
        List<WebElement> labels = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(workflowLabels));
        for (WebElement label : labels) {
            try {
                label.isDisplayed();
            } catch (ElementNotVisibleException | NoSuchElementException e) {
                return false;
            }
        }
        return true;
    }
}
