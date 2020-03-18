package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PermissionsView extends Page {
    private By permissionTableHeaders = By.xpath("//*[@id='glass-permissions-panel']//thead//th");

    public PermissionsView(WebDriver driver) {
        super(driver);
    }

    public void goToProjectPermissionsPage(){
        navigateToUrl("plugins/servlet/project-config/SHG/permissions");
    }

    public String getGivenPermissionTypeValue(String permissionType){
        By resultRowXPath = By.xpath("//*[@id=\"project-config-panel-permissions\"]//tr[@data-permission-key=\"" + permissionType + "\"]//dd");
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(resultRowXPath)).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean getGivenPermissionValue(String permissionType, String permissionValue) {
        int resultHeaderIndex;
        WebElement permissionTypeElement = driver.findElement(By.xpath("//tbody//tr[descendant-or-self::b[text()=\"" + permissionType+ "\"]]"));
        WebElement resultHeader = driver.findElement(By.xpath("//*[@id=\"glass-permissions-panel\"]//thead//th[descendant-or-self::b[contains(text(),\"" + permissionValue + "\")]]"));

        resultHeaderIndex = driver.findElements(permissionTableHeaders).indexOf(resultHeader);
        List<WebElement> permissionValueElements = permissionTypeElement.findElements(By.tagName("td"));
        return null != permissionValueElements.get(resultHeaderIndex).findElement(By.className("glass-true-icon"));
    }
}
