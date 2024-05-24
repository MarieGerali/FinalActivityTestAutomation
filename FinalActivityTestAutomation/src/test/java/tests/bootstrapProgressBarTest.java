package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.bootstrapProgressBar;
import testComponents.BaseTest;

public class bootstrapProgressBarTest extends BaseTest {

    //Testing for progress bar completion, upon clicking on "Download" button, -
    //The progress bar UI and its percentage should increase until it reaches 100%
    @Test
    public void testProgressBarCompletion() {
        bootstrapProgressBar progressBar = new bootstrapProgressBar(driver);
        progressBar.goTo();
        try {
            progressBar.clickDownloadBtn();
            Thread.sleep(21000);
            String text = progressBar.checkProgress();
            System.out.println("Current progress: " + text);
            Assert.assertEquals(text, "100%", "Progress bar did not reach 100%.");
            System.out.println("Progress bar reached 100%.");
            System.out.println("Testing of Progress Bar has passed!");
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
            throw e;
        }
    }

    //Confirmation that the Bootstrap Progress Bar test has passed.
    @AfterTest
    public void afterTest() {
        if (driver != null) {
            System.out.println("Testing for Bootstrap Progress Bar is completed!");
            driver.quit();
        }
    }
}
