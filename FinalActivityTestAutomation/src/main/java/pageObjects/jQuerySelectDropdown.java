package pageObjects;

import abstractComponents.abstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class jQuerySelectDropdown extends abstractComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    public jQuerySelectDropdown(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
    }

    @FindBy(css = "input[placeholder='Select state(s)']")
    WebElement element;

    public void elementClick() throws InterruptedException {
        element.click();
        Thread.sleep(1000);
    }

    public WebElement selectState(String state) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > span > span.selection > span > ul > li > input")));
        input.sendKeys(state);

        Thread.sleep(1000);

        WebElement selectState = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + state + "')]")));
        selectState.click();

        Thread.sleep(1000);

        WebElement selectedValue = driver.findElement(By.xpath("//li[@title='" + state + "']"));
        return selectedValue;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span")
    WebElement dropDown;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement inputSearch;

    @FindBy(css = "#select2-country-results > li")
    WebElement selectCountry;

    @FindBy(xpath = "//span[@title='Netherlands']")
    WebElement selectedValue;

    public void dropDown() throws InterruptedException {
        dropDown.click();
        Thread.sleep(1000);
    }

    public void inputSearch() throws InterruptedException {
        inputSearch.sendKeys("Netherlands");
        Thread.sleep(1000);
    }

    public WebElement selectCountry() throws InterruptedException {
        Thread.sleep(1000);
        selectCountry.click();
        WebElement value = selectedValue;
        return value;
    }

    @FindBy(css = "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")
    WebElement dropDownDisabled;

    @FindBy(css = "body > span > span > span.select2-search.select2-search--dropdown > input")
    WebElement inputDisabled;

    @FindBy(xpath = "/html/body/span/span/span[2]")
    WebElement selectStateDisabled;

    @FindBy(css = "body > div.container-fluid.text-center > " +
            "div > div.col-md-6.text-left > div:nth-child(4) > div >" +
            " div.panel-body > span > span.selection > span")
    WebElement selectedOptionDisabled;

    public void dropDownDisabled() throws InterruptedException {
        dropDownDisabled.click();
        Thread.sleep(1000);
    }

    public void inputDisabled() throws InterruptedException {
        inputDisabled.sendKeys("Puerto Rico");
        Thread.sleep(1000);
    }

    public void selectStateDisabled() throws InterruptedException {
        selectStateDisabled.click();
        Thread.sleep(1000);
    }

    public WebElement selectedOptionDisabled() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectedOption = wait.until(ExpectedConditions.visibilityOf(selectedOptionDisabled));
        return selectedOption;
    }

    @FindBy(css = "#files")
    WebElement dropDownFiles;

    @FindBy(css = "#files > optgroup:nth-child(2) > option:nth-child(2)")
    WebElement selectCategoryFile;

    public void dropDownFiles() throws InterruptedException {
        dropDownFiles.click();
        Thread.sleep(1000);
    }

    public WebElement selectCategory() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectCategory = wait.until(ExpectedConditions.elementToBeClickable(selectCategoryFile));
        selectCategory.click();
        Thread.sleep(1000);
        return selectCategory;
    }
}
