package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GlassPage;

public class TestGlass extends BaseTest {
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
        Assertions.assertTrue(glassPage.isWorkflowQuickLinkExist());
    }
    @Test
    void peopleQuickLink() {
        glassPage.navigateToPeopleTab();
        Assertions.assertTrue(glassPage.isWorkflowQuickLinkExist());
    }
    @Test
    void permissionsQuickLink() {
        glassPage.navigateToPermissionsTab();
        Assertions.assertTrue(glassPage.isWorkflowQuickLinkExist());
    }
    @Test
    void notificationsQuickLink() {
        glassPage.navigateToNotificationsTab();
        Assertions.assertTrue(glassPage.isWorkflowQuickLinkExist());
    }

}
