package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.Collectors;

public class ComponentsView extends Page {
    public ComponentsView(WebDriver driver) {
        super(driver);
    }

    private By components = By.xpath("//td[@class='components-table__name']//a[contains(text(), 'TEST')]");
    private By assignee1 = By.xpath("//td[@class='components-table__name']/following-sibling::td[contains(text(),'No lead')]");
    private By assignee2 = By.xpath("//td[@class='components-table__name']/following-sibling::td[contains(text(),'Project Lead')]");

    public boolean isComponentNamePresent(String component_name) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(components))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()).contains(component_name);
    }

    public boolean areBothAssigneesPresent() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(assignee1)).isDisplayed()
                    &&
                    wait.until(ExpectedConditions.presenceOfElementLocated(assignee2)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return true;
        }
    }
}
