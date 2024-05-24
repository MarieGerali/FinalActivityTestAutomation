package pageObjects;

import abstractComponents.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class dataListFilter extends abstractComponents {

    public WebDriver driver;

    public dataListFilter(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");
    }

    @FindBy(css = "#input-search")
    WebElement searchAttendees;

    @FindBy(css = "div.searchable-container div[style='display: block;']")
    List<WebElement> dataList;

    public WebElement getSearchAttendees()
    {
        WebElement getSearchAttendees = searchAttendees;
        return getSearchAttendees;
    }

    public void clearInputField(WebElement element) {
        element.sendKeys(Keys.END);

        int length = element.getAttribute("value").length();

        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public boolean verifyAttendeesDisplayed(String searchTerm) {

        List<WebElement> attendeeElements = driver.findElements(By.xpath("//ul[@id='attendee-list']/li"));

        for (WebElement attendee : attendeeElements) {
            if (!attendee.getText().contains(searchTerm)) {
                return false;
            }
        }
        return true;
    }

    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Data List Filter has passed!");
            driver.close();
        }
    }

}
