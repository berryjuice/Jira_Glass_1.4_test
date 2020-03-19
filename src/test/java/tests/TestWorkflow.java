package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProjectSHGPage;

import java.net.MalformedURLException;

public class TestWorkflow extends BaseTest {
    private ProjectSHGPage projectSHGPage = new ProjectSHGPage(driver);

    @BeforeAll
    protected static void setUp() throws MalformedURLException {
        BaseTest.setUp();
        new LoginPage(driver).loginWithCredentials("sysadmin", LOGIN_PW);
    }

    @Test
    void transitionStatusStep1() {
        projectSHGPage.navigateToSHGPage();
        String projectTitle = projectSHGPage.getProjectTitle();
        Assertions.assertEquals("Shattered Glass - Project Configuration Documentation", projectTitle);
    }

    @Test
    void transitionStatusStep2() {
        String title = projectSHGPage.selectWorkflow();
        Assertions.assertEquals("Selected Issue Type - Improvement", title);
    }

    @Test
    void transitionStatusStep3() {
        Assertions.assertEquals("IN REVIEW", projectSHGPage.checkWorkflowStatus());
    }

    @Test
    void transitionType() {
        String type = projectSHGPage.checkWorkflowType();
        Assertions.assertEquals("Unique", type);
    }
}
