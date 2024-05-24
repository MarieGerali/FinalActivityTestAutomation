package pageObjects;

import abstractComponents.abstractComponents;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class WindowPopupModal extends abstractComponents {

    WebDriver driver;

    static String mainWindowHandle;

    public WindowPopupModal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
    }

    @FindBy(css = "a[title='Follow @seleniumeasy on Twitter']")
    WebElement twitterLaunchBtn;

    @FindBy(xpath = "//a[@title='Follow @seleniumeasy']")
    WebElement twitterFBLaunchBtn;

    @FindBy(css = "#followall")
    WebElement followAllBtn;

    public String mainWindowHandle()
    {
        mainWindowHandle = driver.getWindowHandle();
        return mainWindowHandle;
    }

    public void twitterLaunch()
    {
        twitterLaunchBtn.click();
    }

    public void twitterFBLaunch()
    {
        twitterFBLaunchBtn.click();
    }

    public void followAllLaunch()
    {
        followAllBtn.click();
    }

    public void switchToNewWindow() {
        for (String handle : windowHandles()) {
            if (!handle.equals(mainWindowHandle())) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public Set<String> windowHandles()
    {
        Set<String> windowHandles = driver.getWindowHandles();
        return windowHandles;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            System.out.println("Testing for Window Popup Modals have been completed!");
            driver.quit();
        }
    }
}
