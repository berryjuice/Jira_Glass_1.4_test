package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ComponentsView;
import pages.GlassPage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class TestComponents extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);
    private ComponentsView componentsView = new ComponentsView(driver);

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        BaseTest.setUp();
        new LoginPage(driver).loginWithCredentials("sysadmin", LOGIN_PW);
    }

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
