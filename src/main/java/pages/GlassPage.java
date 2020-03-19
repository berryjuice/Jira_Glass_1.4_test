package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class GlassPage extends Page {
    private By issueTypes = By.xpath("//li[@id='glass-workflow-nav']/a");
    private By improvementIssueType = By.xpath("//*[@data-issue-type='Improvement']/a");
    private By general = By.xpath("//li[@id='glass-general-nav']/a");
    private By people = By.xpath("//li[@id='glass-people-nav']/a");
    private By permissions = By.xpath("//li[@id='glass-permissions-nav']/a");
    private By notifications = By.xpath("//li[@id='glass-notifications-nav']/a");

    private By componentsTab = By.xpath("//a[text()='Components']");
    private By versionsTab = By.xpath("//a[text()='Versions']");
    private By schemesTab = By.xpath("//a[text()='Schemes']");

    private By showTransitionLabels = By.xpath("//input[@id='show-transition-labels']");
    private By workflowLabels = By.xpath("//*[@id='workflow-designer1']//*[local-name()='svg']//*[local-name()='text']");

    private By workflowQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/workflows')]");
    private By screensQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/screens')]");
    private By basicSummaryQuickLink = By.xpath("//a[contains(@href, '/secure/project/EditProject!default.jspa?pid=10101')]");
    private By schemesQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/summary')]");
    private By componentsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/administer-components')]");
    private By versionsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/administer-versions')]");
    private By peopleQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/roles')]");
    private By permissionsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/permissions')]");
    private By notificationsQuickLink = By.xpath("//a[contains(@href, '/plugins/servlet/project-config/SHG/notifications')]");

    private By gearsIcons = By.xpath("//*[@id='glass-general-schemes-panel']//table//a");

    public GlassPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGlass() {
        navigateToUrl("projects/SHG?selectedItem=com.codecanvas.glass:glass");
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
        return areAllElementsVisible(workflowLabels);
    }

    public boolean gearsIconsVisible() {
        return areAllElementsVisible(gearsIcons);
    }

    private boolean areAllElementsVisible(By ByForElements) {
        List<WebElement> gears = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(gearsIcons));
        for (WebElement gear : gears) {
            try {
                gear.isDisplayed();
            } catch (ElementNotVisibleException | NoSuchElementException e) {
                return false;
            }
        }
        return true;
    }

    public void navigateToGeneralTab() {
        navigateToGlass();
        driver.findElement(general).click();
    }

    public void navigateToComponentsTab() {
        navigateToGeneralTab();
        driver.findElement(componentsTab).click();
    }

    public void navigateToVersionsTab() {
        navigateToGeneralTab();
        driver.findElement(versionsTab).click();
    }

    public void navigateToSchemesTab() {
        navigateToGeneralTab();
        driver.findElement(schemesTab).click();
    }

    public void navigateToPeopleTab() {
        navigateToGlass();
        driver.findElement(people).click();
    }

    public void navigateToPermissionsTab() {
        navigateToGlass();
        driver.findElement(permissions).click();
    }

    public void navigateToNotificationsTab() {
        navigateToGlass();
        driver.findElement(notifications).click();
    }


    public boolean isBasicSummaryQuickLinkExist() {
        try {
            driver.findElement(basicSummaryQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isComponentsQuickLinkExist() {
        try {
            driver.findElement(componentsQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isVersionsQuickLinkExist() {
        try {
            driver.findElement(versionsQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isSchemesQuickLinkExist() {
        try {
            driver.findElement(schemesQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isWorkflowQuickLinkExist() {
        try {
            driver.findElement(workflowQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isScreenQuickLinkExist() {
        try {
            driver.findElement(screensQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isPeopleQuickLinkExist() {
        try {
            driver.findElement(peopleQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isPermissionsQuickLinkExist() {
        try {
            driver.findElement(permissionsQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isNotificationsQuickLinkExist() {
        try {
            driver.findElement(notificationsQuickLink);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


}
