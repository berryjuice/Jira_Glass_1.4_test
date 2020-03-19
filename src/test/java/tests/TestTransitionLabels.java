package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class TestTransitionLabels extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        BaseTest.setUp();
        new LoginPage(driver).loginWithCredentials("sysadmin", LOGIN_PW);
    }

    @Test
    void transitionLabels() {
        glassPage.navigateToSelectedIssueTypePage();
        glassPage.clickShowTransitionLabels();
        Assertions.assertTrue(glassPage.allLabelsVisible());
    }
}
