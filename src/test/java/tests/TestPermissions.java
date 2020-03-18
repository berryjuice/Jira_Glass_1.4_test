package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.PermissionsView;

public class TestPermissions extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);
    private PermissionsView permissionsView = new PermissionsView(driver);

    @Test
    void browseProjectsPermissions(){
        final String permissionType = "Browse Projects";
        final String permissionDataAttribute = "BROWSE_PROJECTS";

        permissionsView.goToProjectPermissionsPage();
        String expectedPermissionValue = permissionsView.getGivenPermissionTypeValue(permissionDataAttribute);

        glassPage.navigateToPermissionsTab();
        Assertions.assertTrue(permissionsView.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }

    @Test
    void editIssuePermissions(){
        final String permissionType = "Create Issues";
        final String permissionDataAttribute = "CREATE_ISSUES";

        permissionsView.goToProjectPermissionsPage();
        String expectedPermissionValue = permissionsView.getGivenPermissionTypeValue(permissionDataAttribute);

        glassPage.navigateToPermissionsTab();
        Assertions.assertTrue(permissionsView.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }

    @Test
    void createIssuePermissions() {
        final String permissionType = "Edit Issues";
        final String permissionDataAttribute = "EDIT_ISSUES";

        permissionsView.goToProjectPermissionsPage();
        String expectedPermissionValue = permissionsView.getGivenPermissionTypeValue(permissionDataAttribute);

        glassPage.navigateToPermissionsTab();
        Assertions.assertTrue(permissionsView.getGivenPermissionValue(permissionType, expectedPermissionValue));
    }
}
