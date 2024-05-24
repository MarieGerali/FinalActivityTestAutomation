package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropdownList extends abstractComponents {

    public WebDriver driver;
    WebDriverWait wait;

    public SelectDropdownList(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    @FindBy(css = "#select-demo")
    WebElement dropDown;

    @FindBy(css = "option[value='Thursday']")
    WebElement selectDay;

    @FindBy(css = ".selected-value")
    WebElement resultText;

    public void dropDownClick()
    {
        dropDown.click();
    }

    public void selectDayClick()
    {
        selectDay.click();
    }

    public WebElement selectDropdownMessage()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOf(resultText));
        return result;
    }

    @FindBy(css = "#multi-select")
    WebElement multiSelectDropdown;

    @FindBy(css = "option[value='California']")
    WebElement firstOption;

    @FindBy(css = "option[value='Washington']")
    WebElement eighthOption;

    @FindBy(css = "#printMe")
    WebElement firstSelected;

    @FindBy(css = "#printAll")
    WebElement allSelected;

    @FindBy(css = ".getall-selected")
    WebElement allResultText;

    public void MultiSelectDropdown()
    {
        multiSelectDropdown.click();
    }

    public WebElement[] multiSelectElements()
    {
        WebElement[] elements = new WebElement[2];
        elements[0] = firstOption;
        elements[1] = eighthOption;
        return elements;
    }

    public void firstSelectClick()
    {
        firstSelected.click();
    }

    public void allSelectClick()
    {
        allSelected.click();
    }

    public WebElement results()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allResults = wait.until(ExpectedConditions.visibilityOf(allResultText));
        return allResults;
    }
}
