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
    void transitionStatus() {
        Assertions.assertEquals("IN REVIEW", projectSHGPage.checkWorkflowStatus());
    }

    @Test
    void transitionType() {
        String type = projectSHGPage.checkWorkflowType();
        Assertions.assertEquals("Unique", type);
    }

    @Test
    void validators() {
        String text = projectSHGPage.checkWorkflowValidators();
        Assertions.assertEquals("Only users with Glass View permission permission can execute this transition.", text);
    }

    @Test
    void postFunctions() {
        String[] expectedTexts;
        expectedTexts = new String[]{
                "Set issue status to the linked status of the destination workflow step.",
                "Assign the issue to the lead developer.",
                "Add a comment to an issue if one is entered during a transition.",
                "Update change history for an issue and store the issue in the database.",
                "Re-index an issue to keep indexes in sync with the database.",
                "Fire a Generic Event event that can be processed by the listeners."
        };
        String[] postFunctionsTexts = projectSHGPage.checkWorkflowPostFunctions();
        Assertions.assertArrayEquals(expectedTexts, postFunctionsTexts);
    }

    @Test
    void transitionConditions() {
        String type = projectSHGPage.checkWorkflowConditions();
        Assertions.assertEquals("2", type);
    }

    @Test
    void transitionValidators() {
        String validatorsNumber = projectSHGPage.checkValidatorsNumber();
        Assertions.assertEquals("1", validatorsNumber);
    }

    @Test
    void postFunctionNumbers() {
        String postFunctions = projectSHGPage.checkPostFunctionsNumber();
        projectSHGPage.transitionConditionsAll();
        Assertions.assertEquals("Default\n"+"5\n"+"Custom\n"+"1", postFunctions);
    }

    @Test
    void conditionsAll() {
        String[] expectedTexts;
        expectedTexts = new String[]{
                "Only users in group jira-minions can execute this transition.",
                "This transition will only execute if code has been committed against this issue."
        };
        String[] conditionsTexts = projectSHGPage.transitionConditionsAll();
        Assertions.assertArrayEquals(expectedTexts, conditionsTexts);
    }

    /*
    @Test
    void conditionsAny() {
        String[] expectedTexts;
        expectedTexts = new String[]{
                "Only users in group jira-minions can execute this transition.",
                "This transition will only execute if code has been committed against this issue."
        };
        projectSHGPage.transitionConditionsAny();
        //Assertions.assertArrayEquals(expectedTexts, conditionsTexts);
    }*/
}
