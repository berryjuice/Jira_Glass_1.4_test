package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public GlassPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGlass() {
       super.navigateToUrl("projects/SHG?selectedItem=com.codecanvas.glass:glass");
    }


}
