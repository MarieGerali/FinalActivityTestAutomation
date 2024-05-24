package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class radioButtonDemo extends abstractComponents {

    public WebDriver driver;

    WebDriverWait wait;

    public radioButtonDemo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    @FindBy(css = "input[value='Female'][name='optradio']")
    WebElement singleFemaleRadioButton;

    @FindBy(css = "#buttoncheck")
    WebElement getCheckedValueButton;

    @FindBy(css = ".radiobutton")
    WebElement singleResultText;

    public void singleRadioButton()
    {
        singleFemaleRadioButton.click();
    }

    public void singleCheckValue()
    {
        getCheckedValueButton.click();
    }

    public WebElement setSingleResultText()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOf(singleResultText));
        return resultText;
    }

    @FindBy(css = "input[value='Female'][name='gender']")
    WebElement groupFemaleRadioButton;

    @FindBy(css = "input[value='15 - 50']")
    WebElement ageRadioButton;

    @FindBy(css = "button[onclick='getValues();']")
    WebElement getGroupValuesButton;

    @FindBy(css = ".groupradiobutton")
    WebElement groupResultText;

    public void groupRadioButton()
    {
        groupFemaleRadioButton.click();
    }

    public void setAgeRadioButton()
    {
        ageRadioButton.click();
    }

    public void getGroupValuesButton()
    {
        getGroupValuesButton.click();
    }

    public WebElement setGroupResultText()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOf(groupResultText));
        return resultText;
    }
}