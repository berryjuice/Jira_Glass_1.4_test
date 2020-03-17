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

public class SelectedIssueTypePage extends Page {

    public SelectedIssueTypePage(WebDriver driver) {
        super(driver);
    }


    public void navigateToGlass() {
        super.navigateToUrl("projects/SHG?selectedItem=com.codecanvas.glass:glass");

    }


}
