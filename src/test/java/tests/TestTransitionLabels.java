package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.LoginPage;

public class TestTransitionLabels extends BaseTest {
    private LoginPage loginPage = new LoginPage(driver);
    private GlassPage glassPage = new GlassPage(driver);

    @Test
    void transitionLabels() {
        loginPage.navigateToLoginPage();
        loginPage.loginWithCredentials("sysadmin", LOGIN_PW);
        glassPage.navigateToSelectedIssueTypePage();
        glassPage.clickShowTransitionLabels();
        Assertions.assertTrue(glassPage.allLabelsVisible());
    }
}
