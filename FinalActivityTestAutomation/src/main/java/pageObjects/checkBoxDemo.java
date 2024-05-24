package pageObjects;

import abstractComponents.abstractComponents;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkBoxDemo extends abstractComponents {

    public WebDriver driver;

    public checkBoxDemo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    @FindBy(css = "#isAgeSelected")
    WebElement singleCheckbox;

    @FindBy(id = "txtAge")
    WebElement successMessage;

    @FindBy(id = "check1")
    WebElement checkAllButton;

    public WebElement singleCheckBoxClick()
    {
        WebElement single = singleCheckbox;
        singleCheckbox.click();
        return single;
    }

    public String getSuccessMessage()
    {
        String success = successMessage.getText();
        return success;
    }

    public String checkAllClick()
    {
        checkAllButton.click();
        String transformToUncheckAllBtn = checkAllButton.getAttribute("value");
        return transformToUncheckAllBtn;
    }

    public void verifyCheckboxSelected(String optionName) {
        WebElement checkbox = driver.findElement(By.xpath(getCheckboxXPath(optionName)));
        Assert.assertTrue(checkbox.isSelected(), optionName + " checkbox is not selected");
    }

    public String getCheckboxXPath(String optionName) {
        switch (optionName) {
            case "Option 1":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label/input";
            case "Option 2":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label/input";
            case "Option 3":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[3]/label/input";
            case "Option 4":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[4]/label/input";
            default:
                throw new IllegalArgumentException("Invalid option name: " + optionName);
        }
    }
}

