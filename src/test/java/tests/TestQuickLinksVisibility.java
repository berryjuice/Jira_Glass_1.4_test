package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GlassPage;
import pages.LoginPage;

public class TestQuickLinksVisibility extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);
    private LoginPage loginPage = new LoginPage(driver);

    @AfterEach
    void afterTestLogout() {
        loginPage.logout();
    }

    @ParameterizedTest
    @ValueSource(strings = {"sysadmin", "projectadmin", "softwareuser"})
    void quickLinksVisible(String user) {
        loginPage.loginWithCredentials(user, "user15");
        glassPage.navigateToGeneralTab();
        boolean expectedResult = !user.equals("softwareuser");
        Assertions.assertEquals(expectedResult, glassPage.isBasicSummaryQuickLinkExist());
    }

}
