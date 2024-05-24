package pageObjects;

import java.time.Duration;
import abstractComponents.abstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapAlerts extends abstractComponents{

    WebDriver driver;

    WebDriverWait wait;
    public BootstrapAlerts(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
        driver.manage().window().maximize();
    }

    @FindBy(css = "#autoclosable-btn-success")
    WebElement greenBtn1;
    @FindBy(css = "#autoclosable-btn-warning")
    WebElement yellowBtn1;
    @FindBy(css = "#autoclosable-btn-danger")
    WebElement redBtn1;
    @FindBy(css = "#autoclosable-btn-info")
    WebElement blueBtn1;

    @FindBy(css = "#normal-btn-success")
    WebElement greenBtn2;
    @FindBy(css = "#normal-btn-warning")
    WebElement yellowBtn2;
    @FindBy(css = "#normal-btn-danger")
    WebElement redBtn2;
    @FindBy(css = "#normal-btn-info")
    WebElement blueBtn2;

    @FindBy(css = ".alert.alert-success.alert-autocloseable-success")
    WebElement autoSuccessModal;
    @FindBy(css = ".alert.alert-warning.alert-autocloseable-warning")
    WebElement autoWarningModal;
    @FindBy(css = ".alert.alert-danger.alert-autocloseable-danger")
    WebElement autoDangerModal;
    @FindBy(css = ".alert.alert-info.alert-autocloseable-info")
    WebElement autoInfoModal;

    @FindBy(css = ".alert.alert-success.alert-normal-success")
    WebElement normalSuccessModal;
    @FindBy(css = ".alert.alert-warning.alert-normal-warning")
    WebElement normalWarningModal;
    @FindBy(css = ".alert.alert-danger.alert-normal-danger")
    WebElement normalDangerModal;
    @FindBy(css = ".alert.alert-info.alert-normal-info")
    WebElement normalInfoModal;

    @FindBy(css = "div[class='alert alert-success alert-normal-success'] button[type='button']")
    WebElement greenModalClose;
    @FindBy(css = "div[class='alert alert-warning alert-normal-warning'] button[type='button']")
    WebElement yellowModalClose;
    @FindBy(css = "div[class='alert alert-danger alert-normal-danger'] button[type='button']")
    WebElement redModalClose;
    @FindBy(css = "div[class='alert alert-info alert-normal-info'] button[type='button']")
    WebElement blueModalClose;

    public void autocloseSuccess() throws InterruptedException {
        greenBtn1.click();
        Thread.sleep(2000);
    }

    public void normalSuccess() throws InterruptedException {
        greenBtn2.click();
        Thread.sleep(2000);
    }

    public void autocloseWarning() throws InterruptedException {
        yellowBtn1.click();
        Thread.sleep(2000);
    }

    public void normalWarning() throws InterruptedException {
        yellowBtn2.click();
        Thread.sleep(2000);
    }

    public void autocloseDanger() throws InterruptedException {
        redBtn1.click();
        Thread.sleep(2000);
    }

    public void normalDanger() throws InterruptedException {
        redBtn2.click();
        Thread.sleep(2000);
    }

    public void autocloseInfo() throws InterruptedException {
        blueBtn1.click();
        Thread.sleep(2000);
    }

    public void normalInfo()
    {
        blueBtn2.click();
    }


    public String autocloseSuccessModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoSuccessModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String normalSuccessModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalSuccessModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String autocloseWarningModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoWarningModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String normalWarningModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalWarningModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String autocloseDangerModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoDangerModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String normalDangerModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalDangerModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String autocloseInfoModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoInfoModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String normalInfoModal()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalInfoModal));
        String successMessage = successModal.getText();
        return successMessage;
    }

    public String autocloseSuccessModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoSuccessModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String normalSuccessModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalSuccessModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String autocloseWarningModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoWarningModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String normalWarningModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalWarningModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String autocloseDangerModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoDangerModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String normalDangerModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalDangerModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String autocloseInfoModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoInfoModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public String normalInfoModalColor()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalInfoModal));
        String color = successModal.getCssValue("background-color");
        return color;
    }

    public Boolean autocloseSuccessModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoSuccessModal));
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean normalSuccessModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalSuccessModal));
        greenModalClose.click();
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean autocloseWarningModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoWarningModal));
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean normalWarningModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalWarningModal));
        yellowModalClose.click();
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean autocloseDangerModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoDangerModal));
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean normalDangerModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalDangerModal));
        redModalClose.click();
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean autocloseInfoModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(autoInfoModal));
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }

    public Boolean normalInfoModalClose()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOf(normalInfoModal));
        blueModalClose.click();
        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        return modalClosed;
    }
}
