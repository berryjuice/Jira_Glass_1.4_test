package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProjectSHGPage;

public class TestWorkflow extends BaseTest {
    private LoginPage loginPage = new LoginPage(driver);
    private ProjectSHGPage projectSHGPage = new ProjectSHGPage(driver);

    @Test
    void transitionStatusStep1() {
        projectSHGPage.navigateToSHGPage();
        String projectTitle = projectSHGPage.getProjectTitle();
        Assertions.assertEquals("Shattered Glass - Project Configuration Documentation", projectTitle);
    }

    @Test
    void transitionStatusStep2() {
        Assertions.assertTrue(projectSHGPage.selectWorkflow());
    }

    @Test
    void transitionStatusStep3() {

    }
}
