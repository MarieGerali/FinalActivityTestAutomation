package tests;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.bootstrapModals;
import testComponents.BaseTest;

public class bootstrapModalsTest extends BaseTest {


    //Testing for single modal example, upon clicking the launch button the modal appears.
    //Two scenarios upon clicking launch - one for clicking on "save changes" (page should refresh) -
    // - and another one for clicking on "close button".
    @Test
    public void singleModalExample() {
        bootstrapModals singleModal = new bootstrapModals(driver);
        try {
            singleModal.goTo();
            singleModal.launchSingleModal();
            Boolean displayStatus = singleModal.viewModal();

            Thread.sleep(2000);

            Assert.assertTrue(displayStatus, "The modal did not appear after clicking the launch button.");

            singleModal.saveSingleModal();
            singleModal.invisibilityofSingleModal();
            singleModal.launchSingleModal();
            displayStatus = singleModal.viewModal();

            Thread.sleep(1000);

            Assert.assertTrue(displayStatus, "The modal did not reappear after clicking the launch button a second time.");

            singleModal.closeSingleModal();
            displayStatus = singleModal.invisibilityofSingleModal();

            Thread.sleep(2000);

            Assert.assertTrue(displayStatus, "The modal did not close after clicking the close button.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //Testing for multimodal example, upon clicking the launch button the modal appears and within that modal -
    // - there is another launch button where a second modal pops up.
    //This test scenario is for closing the modals.
    @Test
    public void multipleModalExampleClose() {
        bootstrapModals multiModal = new bootstrapModals(driver);
        multiModal.goTo();
        try {
            multiModal.launchMultiModal1();
            multiModal.launchMultiModal2();
            multiModal.closeMultiModal2();

            Thread.sleep(2000);

            boolean isSecondModalClosed = multiModal.invisibilityofMultiModal2();
            Assert.assertTrue(isSecondModalClosed, "Second modal did not close after clicking Close button.");

            boolean isLaunchModalBtn2Clickable = multiModal.launchModalBtn2Status();
            Assert.assertTrue(isLaunchModalBtn2Clickable, "Launch Modal Button is not clickable after closing the second modal.");

            multiModal.closeMultiModal1();

            boolean isFirstModalClosed = multiModal.invisibilityofMultiModal1();
            Assert.assertTrue(isFirstModalClosed, "First modal did not close after clicking Close button.");

            boolean isLaunchModalBtn1Clickable = multiModal.launchModalBtn1Status();
            Assert.assertTrue(isLaunchModalBtn1Clickable, "Launch Modal Button is not clickable after closing the first modal.");

            Thread.sleep(2000);


        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable or visible.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Testing for multimodal example, upon clicking the launch button the modal appears and within that modal -
    // - there is another launch button where a second modal pops up.
    //This test scenario is for immediately clicking on "save changes" from the first modal, and page should refresh.
    @Test
    public void multipleModalExampleSaveChanges1() throws InterruptedException {
        bootstrapModals multiModal = new bootstrapModals(driver);
        try {
            multiModal.goTo();
            multiModal.launchMultiModal1();

            Thread.sleep(1000);

            multiModal.launchMultiModal2();

            Thread.sleep(1000);

            multiModal.saveMultiModal2();
            Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for multimodal example, upon clicking the launch button the modal appears and within that modal -
    // - there is another launch button where a second modal pops up.
    //This test scenario is for launching the second modal and then clicking on its "save changes", the page should refresh.
    @Test
    public void multipleModalExampleSaveChanges2() throws InterruptedException {
        bootstrapModals multiModal = new bootstrapModals(driver);
        try {
            multiModal.goTo();
            multiModal.launchMultiModal1();

            Thread.sleep(1000);

            multiModal.saveMultiModal1();
            Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Bootstrap Modal tests have passed.
    @AfterTest
    public void afterTest() {
        if (driver != null) {
            System.out.println("Testing for Bootstrap Modals is completed!");
            driver.quit();
        }
    }
}
