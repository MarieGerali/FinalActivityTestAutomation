package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class bootstrapDatePicker extends abstractComponents{

    private WebDriver driver;

    WebDriverWait wait;

    public bootstrapDatePicker(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
    }

    @FindBy(css = "input[placeholder='dd/mm/yyyy']")
    WebElement datePicker;

    @FindBy(css = "div[class='datepicker-days'] th[class='today']")
    WebElement selectedToday;

    @FindBy(css = "div[class='datepicker-days'] th[class='clear']")
    WebElement clearButton;

    public void datePickerClick()
    {
        datePicker.click();
    }

    public String getDateToday()
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String todayFormatted = today.format(formatter);
        return todayFormatted;
    }

    public void selectTodayClick() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectToday = wait.until(ExpectedConditions.visibilityOf(selectedToday));
        selectToday.click();
        Thread.sleep(1000);
    }

    public WebElement resultVisibilty() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOf(datePicker));
        return resultText;
    }

    public void clearBtnClick() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clear = wait.until(ExpectedConditions.visibilityOf(clearButton));
        clear.click();
        Thread.sleep(1000);
    }

    @FindBy(css = "input[placeholder='Start date']")
    WebElement startDateInput;

    @FindBy(css = "input[placeholder='End date']")
    WebElement endDateInput;

    @FindBy(css = "tbody tr:nth-child(3) td:nth-child(2)")
    WebElement startDate;

    @FindBy(css = "tbody tr:nth-child(3) td:nth-child(6)")
    WebElement endDate;

    public WebElement setStartDateInput()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement start = wait.until(ExpectedConditions.elementToBeClickable(startDateInput));
        startDateInput.click();
        return start;
    }

    public WebElement setEndDateInput()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement end = wait.until(ExpectedConditions.elementToBeClickable(endDateInput));
        endDateInput.click();
        return end;
    }

    public void startDateClick()
    {
        startDate.click();
    }

    public void endDateClick()
    {
        endDate.click();
    }
}