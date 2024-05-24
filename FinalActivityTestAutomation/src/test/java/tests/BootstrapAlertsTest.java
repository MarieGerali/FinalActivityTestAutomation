package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.BootstrapAlerts;
import testComponents.BaseTest;

public class BootstrapAlertsTest extends BaseTest {


    //Testing for an auto closable success message, that upon clicking the button, an alert message appears and then -
    // - disappears / closes automatically after 5 seconds.
    //The color of the modal should be green with the correct rgb/hex code.
    @Test
    public void autoclosableSuccessMessage()
    {
        BootstrapAlerts autoclosableSuccess = new BootstrapAlerts(driver);
        try {
            autoclosableSuccess.goTo();
            autoclosableSuccess.autocloseSuccess();
            String expectedMessage = "I'm an autocloseable success message. I will hide in 5 seconds.";
            String actualMessage = autoclosableSuccess.autocloseSuccessModal();
            Assert.assertEquals(actualMessage, expectedMessage, "The success message text does not match.");
            String color = autoclosableSuccess.autocloseSuccessModalColor();
            Assert.assertTrue(color.equals("rgba(223, 240, 216, 1)") ||
                    color.equals("#dff0d8"), "The modal background color does not match the expected green.");
            Boolean modalClosed = autoclosableSuccess.autocloseSuccessModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close automatically after 5 seconds.");

            Thread.sleep(2000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for a normal success message, that upon clicking on the button and an alert message appears, user has the -
    // - ability to close the modal by clicking on the "x" button.
    //The color of the modal should be green with the correct rgb/hex code.
    @Test
    public void NormalSuccessMessage()
    {
        BootstrapAlerts normalSuccess = new BootstrapAlerts(driver);
        try {
            normalSuccess.goTo();
            normalSuccess.normalSuccess();
            String expectedMessage = "×\n" +
                    "I'm a normal success message. To close use the appropriate button.";
            String actualMessage = normalSuccess.normalSuccessModal();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, "The success message text does not match.");
            String color = normalSuccess.normalSuccessModalColor();
            Assert.assertTrue(color.equals("rgba(223, 240, 216, 1)") || color.equals("#dff0d8"), "The modal background color does not match the expected green.");
            Boolean modalClosed = normalSuccess.normalSuccessModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for an auto closable warning message, that upon clicking the button, an alert message appears and then -
    // - disappears / closes automatically after 3 seconds.
    //The color of the modal should be yellow with the correct rgb/hex code.
    @Test
    public void autoclosableWarningMessage()
    {
        BootstrapAlerts autoclosableWarning = new BootstrapAlerts(driver);
        try {
            autoclosableWarning.goTo();
            autoclosableWarning.autocloseWarning();
            String expectedMessage = "I'm an autocloseable warning message. I will hide in 3 seconds.";
            String actualMessage = autoclosableWarning.autocloseWarningModal();
            Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");
            String color = autoclosableWarning.autocloseWarningModalColor();
            Assert.assertTrue(color.equals("rgba(252, 248, 227, 1)") || color.equals("#fcf8e3"), "The modal is not yellow.");
            Boolean modalClosed = autoclosableWarning.autocloseWarningModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close automatically after 3 seconds.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for a normal warning message, that upon clicking on the button and an alert message appears, user has the -
    // - ability to close the modal by clicking on the "x" button.
    //The color of the modal should be yellow with the correct rgb/hex code.
    @Test
    public void NormalWarningMessage()
    {
        BootstrapAlerts NormalWarningSuccess = new BootstrapAlerts(driver);
        try {
            NormalWarningSuccess.goTo();
            NormalWarningSuccess.normalWarning();
            String expectedMessage = "×\n" +
                    "I'm a normal warning message. To close use the appropriate button.";
            String actualMessage = NormalWarningSuccess.normalWarningModal();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");
            String color = NormalWarningSuccess.normalWarningModalColor();
            Assert.assertTrue(color.equals("rgba(252, 248, 227, 1)") || color.equals("#fcf8e3"), "The modal background color does not match the expected yellow.");
            Boolean modalClosed = NormalWarningSuccess.normalWarningModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //Testing for an auto closable danger message, that upon clicking the button, an alert message appears and then -
    // - disappears / closes automatically after 5 seconds.
    //The color of the modal should be red with the correct rgb/hex code.
    @Test
    public void autoclosableDangerMessage()
    {
        BootstrapAlerts autoclosableDanger = new BootstrapAlerts(driver);
        try {
            autoclosableDanger.goTo();
            autoclosableDanger.autocloseDanger();
            String expectedMessage = "I'm an autocloseable danger message. I will hide in 5 seconds.";
            String actualMessage = autoclosableDanger.autocloseDangerModal();
            Assert.assertEquals(actualMessage, expectedMessage, "The danger message text does not match.");
            String color = autoclosableDanger.autocloseDangerModalColor();
            Assert.assertTrue(color.equals("rgba(242, 222, 222, 1)") || color.equals("#f2dede"), "The modal is not the correct shade of red.");
            Boolean modalClosed = autoclosableDanger.autocloseDangerModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close automatically after 5 seconds.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for a normal danger message, that upon clicking on the button and an alert message appears, user has the -
    // - ability to close the modal by clicking on the "x" button.
    //The color of the modal should be red with the correct rgb/hex code.
    @Test
    public void NormalDangerMessage()
    {
        BootstrapAlerts NormalDanger = new BootstrapAlerts(driver);
        try {
            NormalDanger.goTo();
            NormalDanger.normalDanger();
            String expectedMessage = "×\n" +
                    "I'm a normal danger message. To close use the appropriate button.";
            String actualMessage = NormalDanger.normalDangerModal();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, "The danger message text does not match.");
            String color = NormalDanger.normalDangerModalColor();
            Assert.assertTrue(color.equals("rgba(242, 222, 222, 1)") || color.equals("#f2dede"), "The modal background color does not match the expected red.");
            Boolean modalClosed = NormalDanger.normalDangerModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for an auto closable info message, that upon clicking the button, an alert message appears and then -
    // - disappears / closes automatically after 6 seconds.
    //The color of the modal should be light blue with the correct rgb/hex code.
    @Test
    public void autoclosableInfoMessage()
    {
        BootstrapAlerts autoclosableInfo = new BootstrapAlerts(driver);
        try {
            autoclosableInfo.goTo();
            autoclosableInfo.autocloseInfo();
            String expectedMessage = "I'm an autocloseable info message. I will hide in 6 seconds.";
            String actualMessage = autoclosableInfo.autocloseInfoModal();
            Assert.assertEquals(actualMessage, expectedMessage, "The info message text does not match.");
            String color = autoclosableInfo.autocloseInfoModalColor();
            Assert.assertTrue(color.equals("rgba(217, 237, 247, 1)") || color.equals("#d9edf7"), "The modal is not the correct shade of light blue.");
            Boolean modalClosed = autoclosableInfo.autocloseInfoModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close automatically after 6 seconds.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for a normal info message, that upon clicking on the button and an alert message appears, user has the -
    // - ability to close the modal by clicking on the "x" button.
    //The color of the modal should be light blue with the correct rgb/hex code.
    @Test
    public void NormalInfoMessage()
    {
        BootstrapAlerts NormalInfo = new BootstrapAlerts(driver);
        try {
            NormalInfo.goTo();
            NormalInfo.normalInfo();
            String expectedMessage = "×\n" +
                    "I'm a normal info message. To close use the appropriate button.";
            String actualMessage = NormalInfo.normalInfoModal();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, "The info message text does not match.");
            String color = NormalInfo.normalInfoModalColor();
            Assert.assertTrue(color.equals("rgba(217, 237, 247, 1)") || color.equals("#d9edf7"), "The modal background color does not match the expected light blue.");
            Boolean modalClosed = NormalInfo.normalInfoModalClose();
            Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Bootstrap Alerts test passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Bootstrap Alerts have passed!");
        }
    }
}


