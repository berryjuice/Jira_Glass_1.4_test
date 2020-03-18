package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ComponentsView;
import pages.GlassPage;

public class TestComponents extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);
    private ComponentsView componentsView = new ComponentsView(driver);

    @Test
    void viewComponentsName() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(componentsView.isComponentNamePresent("TEST"));
        Assertions.assertTrue(componentsView.isComponentNamePresent("TEST2"));
    }

    @Test
    void viewComponentsAssignee() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(componentsView.areBothAssigneesPresent());
    }
}
