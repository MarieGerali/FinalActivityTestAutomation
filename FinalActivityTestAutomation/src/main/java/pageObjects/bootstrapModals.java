package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class bootstrapModals extends abstractComponents{

    WebDriver driver;

    WebDriverWait wait;

    public bootstrapModals(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
    }

    @FindBy(xpath = "(//a[@data-toggle='modal'][normalize-space()='Launch modal'])[1]")
    WebElement singleLaunchModalBtn;

    @FindBy(css = "div[id='myModal0'] div[class='modal-body']")
    WebElement singleModal;

    @FindBy(xpath = "//*[@id=\"myModal0\"]/div/div/div[4]/a[1]")
    WebElement singleCloseModalBtn;

    @FindBy(css = "div[id='myModal0'] a[class='btn btn-primary']")
    WebElement singleSaveModalBtn;

    @FindBy(css = "a[href='#myModal']")
    WebElement multiModalLaunchBtn1;

    @FindBy(css = "div[class='modal-body'] a[class='btn btn-primary']")
    WebElement multiModalLaunchBtn2;

    @FindBy(css = "div[id='myModal'] div[class='modal-body']")
    WebElement multiModal1;

    @FindBy(css = "div[id='myModal2'] div[class='modal-body']")
    WebElement multiModal2;

    @FindBy(css = "div[id='myModal'] a[class='btn']")
    WebElement multiModalCloseBtn1;

    @FindBy(css = "div[id='myModal2'] a[class='btn']")
    WebElement multiModalCloseBtn2;

    @FindBy(css = "div[id='myModal'] div[class='modal-footer'] a[class='btn btn-primary']")
    WebElement multiModalSaveBtn1;

    @FindBy(css = "div[id='myModal2'] a[class='btn btn-primary']")
    WebElement multiModalSaveBtn2;


    public void launchSingleModal()
    {
        singleLaunchModalBtn.click();
    }

    public Boolean viewModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOf(singleModal));
        Boolean displayStatus = modal.isDisplayed();
        return displayStatus;
    }

    public void saveSingleModal()
    {
        singleSaveModalBtn.click();
    }

    public void closeSingleModal()
    {
        singleCloseModalBtn.click();
    }

    public Boolean invisibilityofSingleModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Boolean modal = wait.until(ExpectedConditions.invisibilityOf(singleModal));
        return modal;
    }

    public void launchMultiModal1()
    {
        multiModalLaunchBtn1.click();
    }

    public void launchMultiModal2()
    {
        multiModalLaunchBtn2.click();
    }

    public void closeMultiModal1()
    {
        multiModalCloseBtn1.click();
    }

    public void closeMultiModal2()
    {
        multiModalCloseBtn2.click();
    }

    public void saveMultiModal1()
    {
        multiModalSaveBtn1.click();
    }

    public void saveMultiModal2()
    {
        multiModalSaveBtn2.click();
    }

    public Boolean launchModalBtn1Status()
    {
        Boolean btnStatus = multiModalLaunchBtn1.isEnabled();
        return btnStatus;
    }

    public Boolean launchModalBtn2Status()
    {
        Boolean btnStatus = multiModalLaunchBtn2.isEnabled();
        return btnStatus;
    }

    public boolean invisibilityofMultiModal1()
    {
        boolean isFirstModalClosed = wait.until(ExpectedConditions.invisibilityOf(multiModal1));
        return isFirstModalClosed;
    }

    public boolean invisibilityofMultiModal2()
    {
        boolean isSecondModalClosed = wait.until(ExpectedConditions.invisibilityOf(multiModal2));
        return isSecondModalClosed;
    }

    @Test(priority = 2)
    public void multipleModalExampleClose() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement launchModalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a")));
            launchModalBtn.click();

            WebElement secondLaunchModalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a")));
            secondLaunchModalBtn.click();

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")));
            closeButton.click();

            By secondModalLocator = By.cssSelector("#myModal2 > div > div");
            boolean isSecondModalClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(secondModalLocator));
            Assert.assertTrue(isSecondModalClosed, "Second modal did not close after clicking Close button.");

            boolean isLaunchModalBtnClickable = launchModalBtn.isEnabled();
            Assert.assertTrue(isLaunchModalBtnClickable, "Launch Modal Button is not clickable after closing the second modal.");

            WebElement closeButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")));
            closeButton2.click();

            By firstModalLocator = By.cssSelector("#myModal > div > div");
            boolean isFirstModalClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(firstModalLocator));
            Assert.assertTrue(isFirstModalClosed, "First modal did not close after clicking Close button.");

            boolean isLaunchModalBtnClickable2 = secondLaunchModalBtn.isEnabled();
            Assert.assertTrue(isLaunchModalBtnClickable2, "Launch Modal Button is not clickable after closing the first modal.");

        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable or visible.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void multipleModalExampleSaveChanges1() {
        WebElement launchModalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        launchModalBtn.click();

        WebElement secondLaunchModalBtn = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a"));
        secondLaunchModalBtn.click();

        WebElement saveChangesBtn1 = driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[2]"));
        saveChangesBtn1.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));
    }

    @Test(priority = 4)
    public void multipleModalExampleSaveChanges2() {

        WebElement launchModalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        launchModalBtn.click();

        WebElement saveChangesBtn2 = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[2]"));
        saveChangesBtn2.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            System.out.println("Testing for Bootstrap Modals has completed!");
            driver.quit();
        }
    }

}
