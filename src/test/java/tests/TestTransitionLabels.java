package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.Page;

public class TestTransitionLabels extends BaseTest {
    private GlassPage glassPage = new GlassPage(driver);

    @Test
    void transitionLabels() {
        glassPage.navigateToSelectedIssueTypePage();
        glassPage.clickShowTransitionLabels();
        Assertions.assertTrue(glassPage.allLabelsVisible());
    }
}
