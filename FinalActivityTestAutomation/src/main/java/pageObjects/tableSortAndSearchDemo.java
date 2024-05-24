package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class tableSortAndSearchDemo extends abstractComponents {

    WebDriver driver;

    WebDriverWait wait;

    public tableSortAndSearchDemo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }

    @FindBy(css = "select[name='example_length']")
    WebElement dropDown;

    @FindBy(css = "option[value='25']")
    WebElement selectState25;

    @FindBy(css = "option[value='50']")
    WebElement selectState50;

    @FindBy(css = "option[value='100']")
    WebElement selectState100;

    @FindBy(css = "option[value='10']")
    WebElement selectState10;

    public void dropDownClick() {
        dropDown.click();
    }

    public WebElement selectState25Click() {
        selectState25.click();
        WebElement isSelected = selectState25;
        return isSelected;
    }

    public WebElement selectState50Click() {
        selectState50.click();
        WebElement isSelected = selectState50;
        return isSelected;
    }

    public WebElement selectState100Click() {
        selectState100.click();
        WebElement isSelected = selectState100;
        return isSelected;
    }

    public WebElement selectState10Click() {
        selectState10.click();
        WebElement isSelected = selectState10;
        return isSelected;
    }

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[1]")
    private WebElement nameArrow;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[2]")
    private WebElement positionArrow;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[3]")
    private WebElement officeArrow;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[4]")
    private WebElement ageArrow;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[5]")
    private WebElement startDateArrow;

    @FindBy(xpath = "//*[@id='example']/thead/tr/th[6]")
    private WebElement salaryArrow;

    public WebElement getNameArrow() {
        return nameArrow;
    }

    public WebElement getPositionArrow() {
        return positionArrow;
    }

    public WebElement getOfficeArrow() {
        return officeArrow;
    }

    public WebElement getAgeArrow() {
        return ageArrow;
    }

    public WebElement getStartDateArrow() {
        return startDateArrow;
    }

    public WebElement getSalaryArrow() {
        return salaryArrow;
    }

    public void nameArrowClick() {
        nameArrow.click();
    }

    public void positionArrowClick() {
        positionArrow.click();
    }

    public void officeArrowClick() {
        officeArrow.click();
    }

    public void ageArrowClick() {
        ageArrow.click();
    }

    public void startDateArrowClick() {
        startDateArrow.click();
    }

    public void salaryArrowClick() {
        salaryArrow.click();
    }


    @FindBy(css = "#example_next")
    private WebElement nextBtn;

    @FindBy(css = "#example_previous")
    private WebElement previousBtn;

    public WebElement getNextBtn() {
        return nextBtn;
    }

    public WebElement getPreviousBtn() {
        return previousBtn;
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public void previousBtnClick() {
        previousBtn.click();
    }

    @FindBy(css = "input[type='search']")
    WebElement searchInput;

    public void searchInput(String query) {
        searchInput.sendKeys(query);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table"), query));
        Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(), '" + query + "')]")).size() > 0, "Search results do not contain 'Flynn'");
    }

    public void searchClear() {
        searchInput.clear();
    }
}




