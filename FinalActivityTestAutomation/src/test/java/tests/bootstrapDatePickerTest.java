package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.bootstrapDatePicker;
import testComponents.BaseTest;

public class bootstrapDatePickerTest extends BaseTest {

    //Testing for Date Example, the scenarios consists of clicking on the date picker, there is an option to get the current date on this day.
    // For the second scenario, there is also an option to clear the date picker which erases the current date displayed.
    //Assertions are also added for both scenarios if the text (date) matches, and that the input field should be cleared.
    @Test
    public void DateExample() throws InterruptedException {
        bootstrapDatePicker datePickerTest = new bootstrapDatePicker(driver);
        try {
            datePickerTest.goTo();
            datePickerTest.datePickerClick();

            String todayFormatted = datePickerTest.getDateToday();

            Thread.sleep(2000);

            datePickerTest.selectTodayClick();

            Thread.sleep(2000);

            WebElement resultText = datePickerTest.resultVisibilty();

            String actualText = resultText.getAttribute("value");
            Assert.assertEquals(actualText, todayFormatted, "Expected text does not match actual text");

            datePickerTest.datePickerClick();

            Thread.sleep(2000);

            datePickerTest.clearBtnClick();

            Thread.sleep(2000);

            String clearedText = resultText.getAttribute("value");
            Assert.assertEquals(clearedText, "", "Input field should be cleared but found: " + clearedText);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //Testing for Date Range, this allows user to choose a starting date and the end date (which can be applied for schedules, events, etc.)
    //Assertions are added for the date range. Expected results should be the start and end date being set, and -
    //The start date should be an earlier date before the end date (it should not be the other way around).
    @Test
    public void DateRangeExample() {
        bootstrapDatePicker dateRangeTest = new bootstrapDatePicker(driver);
        try {
            dateRangeTest.goTo();
            WebElement startDateInput = dateRangeTest.setStartDateInput();
            dateRangeTest.startDateClick();

            Thread.sleep(2000);


            WebElement endDateInput = dateRangeTest.setEndDateInput();
            dateRangeTest.endDateClick();

            Thread.sleep(2000);

            String startValue = startDateInput.getAttribute("value");
            String endValue = endDateInput.getAttribute("value");

            Assert.assertNotNull(startValue, "Start date is not set.");
            Assert.assertNotNull(endValue, "End date is not set.");
            Assert.assertTrue(startValue.compareTo(endValue) < 0, "Start date should be before end date.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Date Picker tests passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Date Pickers have passed!");
        }
    }
}
