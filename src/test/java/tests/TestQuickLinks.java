package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GlassPage;

public class TestQuickLinks extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);

    @Test
    void basicSummaryQuickLink() {
        glassPage.navigateToGeneralTab();
        Assertions.assertTrue(glassPage.isBasicSummaryQuickLinkExist());
    }
    @Test
    void componentsQuickLink() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.isComponentsQuickLinkExist());
    }
    @Test
    void versionsQuickLink() {
        glassPage.navigateToVersionsTab();
        Assertions.assertTrue(glassPage.isVersionsQuickLinkExist());
    }
    @Test
    void schemesQuickLink() {
        glassPage.navigateToSchemesTab();
        Assertions.assertTrue(glassPage.isSchemesQuickLinkExist());
    }
    @Test
    void workflowQuickLink() {
        glassPage.navigateToSelectedIssueTypePage();
        Assertions.assertTrue(glassPage.isWorkflowQuickLinkExist());
    }
    @Test
    void screenQuickLink() {
        glassPage.navigateToSelectedIssueTypePage();
        Assertions.assertTrue(glassPage.isScreenQuickLinkExist());
    }
    @Test
    void peopleQuickLink() {
        glassPage.navigateToPeopleTab();
        Assertions.assertTrue(glassPage.isPeopleQuickLinkExist());
    }
    @Test
    void permissionsQuickLink() {
        glassPage.navigateToPermissionsTab();
        Assertions.assertTrue(glassPage.isPermissionsQuickLinkExist());
    }
    @Test
    void notificationsQuickLink() {
        glassPage.navigateToNotificationsTab();
        Assertions.assertTrue(glassPage.isNotificationsQuickLinkExist());
    }

}
