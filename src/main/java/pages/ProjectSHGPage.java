package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSHGPage extends Page {
    // Constructor
    public ProjectSHGPage(WebDriver driver) {
        super(driver);
    }

    // Fields
    private By projectTitle = By.xpath("//*[@id='sidebar-page-container']//h1");
    private By issueTypes = By.xpath("//li[@id='glass-workflow-nav']//a[@class='glass-dropdown']//div[@aria-owns='dropdown-issuetypes']");
    private By workflowTransitionsToTestAllInReview = By.xpath("//div[@role='group']//a[@role='menuitem']//span[text()=' Improvement']");
    private By issueTypeTitle = By.xpath("//h2[@id='glass-workflow-panel-title']");
    private By transitionName = By.xpath("//tr[@class='transition-row']//td[@class='transition-name']//span//b[text()='ToTestAll']");
    private By fromStatus = By.xpath("//b[text()='ToTestAll']//ancestor::td//following-sibling::td/span");
    private By type = By.xpath("//b[text()='ToTestAll']//ancestor::td//following-sibling::td/span//ancestor::td//following-sibling::td");
    private By conditions = By.xpath("//a[@id='aui-uid-23']");
    private By validators = By.xpath("//a[@id='aui-uid-24']");
    private By postFunctions = By.xpath("//a[@id='aui-uid-25']");
    private By permissionText = By.xpath("//div[@id='glass-transitions-validators-panel-6']//div//div//ol//li");
    private By postFunctionsText1 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li");
    private By postFunctionsText2 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li[2]");
    private By postFunctionsText3 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li[3]");
    private By postFunctionsText4 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li[4]");
    private By postFunctionsText5 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li[5]");
    private By postFunctionsText6 = By.xpath("//div[@id=\"glass-transitions-postfunctions-panel-6\"]//div//div//ol//li[6]");
    private By conditionNumber = By.xpath("//b[text()='ToTestAll']//ancestor::tr//td[5]");

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

    public String checkWorkflowType() {
        selectWorkflow();
        return driver.findElement(type).getText();

    }

    public String checkWorkflowValidators() {
        selectWorkflow();
        driver.findElement(transitionName).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(validators)).click();
        } catch (ElementNotInteractableException e) {}
        return driver.findElement(permissionText).getText();
    }

    public String[] checkWorkflowPostFunctions() {
        selectWorkflow();
        driver.findElement(transitionName).click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(postFunctions)).click();
        } catch (ElementNotInteractableException e) {}
        String[] postFunctionsTexts = new String[6];
        postFunctionsTexts[0] = driver.findElement(postFunctionsText1).getText();
        postFunctionsTexts[1] = driver.findElement(postFunctionsText2).getText();
        postFunctionsTexts[2] = driver.findElement(postFunctionsText3).getText();
        postFunctionsTexts[3] = driver.findElement(postFunctionsText4).getText();
        postFunctionsTexts[4] = driver.findElement(postFunctionsText5).getText();
        postFunctionsTexts[5] = driver.findElement(postFunctionsText6).getText();
        return postFunctionsTexts;
    }

    public String checkWorkflowConditions() {
        selectWorkflow();
        return driver.findElement(conditionNumber).getText();

    }
}
