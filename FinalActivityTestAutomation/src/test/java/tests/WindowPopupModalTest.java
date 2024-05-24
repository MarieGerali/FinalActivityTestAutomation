package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.WindowPopupModal;
import testComponents.BaseTest;


public class WindowPopupModalTest extends BaseTest {

    //Testing for single modal, that upon clicking on the launch buttons, a modal will pop up as a separate window.
    //Added assertion to validate if the correct url from the separate window appears.
    @Test
    public void singleWindowPopup() {
        WindowPopupModal singleWindow = new WindowPopupModal(driver);
        try {
            singleWindow.goTo();
            singleWindow.mainWindowHandle();
            singleWindow.twitterLaunch();
            singleWindow.switchToNewWindow();

            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://x.com/intent/follow?screen_name=seleniumeasy&mx=2");

            driver.switchTo().window(singleWindow.mainWindowHandle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for multiple modal example, that upon clicking on the button -
    // - multiple windows will pop up separately
    //Added assertion to validate if the correct urls (Twitter and Facebook) from the separate window appears.
    @Test
    public void multipleWindowModal() {
        WindowPopupModal multipleWindow = new WindowPopupModal(driver);
        try {
            multipleWindow.goTo();
            multipleWindow.mainWindowHandle();
            multipleWindow.twitterFBLaunch();
            multipleWindow.switchToNewWindow();

            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.facebook.com/seleniumeasy");

            driver.switchTo().window(multipleWindow.mainWindowHandle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for multiple modal example, that upon clicking on the button -
    // - multiple windows will pop up separately
    //Added assertion to validate if the correct urls (Facebook, Twitter, and Google/Google+) from the separate windows appear.
    @Test
    public void followAllWindowModal() {
        WindowPopupModal multipleWindow = new WindowPopupModal(driver);
        try {
            multipleWindow.goTo();
            multipleWindow.mainWindowHandle();
            multipleWindow.followAllLaunch();

            multipleWindow.switchToNewWindow();

            Thread.sleep(2000);

            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://x.com/intent/follow?screen_name=seleniumeasy&mx=2");

            driver.switchTo().window(multipleWindow.mainWindowHandle());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Window Popup Modal tests passed.
    @AfterTest
    public void afterTest() {
        if (driver != null) {
            System.out.println("Testing for Bootstrap Modals is completed!");
            driver.quit();
        }
    }
}
