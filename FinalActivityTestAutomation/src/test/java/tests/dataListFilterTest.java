package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.dataListFilter;
import testComponents.BaseTest;

public class dataListFilterTest extends BaseTest {

    //Testing for data list filter, upon inputting the following terms in the search field, -
    // - only the matching results should appear.
    @Test
    public void dataListFilter() throws InterruptedException {
        dataListFilter dataList = new dataListFilter(driver);
        try {
            dataList.goTo();
            WebElement searchAttendees = dataList.getSearchAttendees();

            String[] searchTerms = {"Glenn Pho shizzle", "Brian Hoyies", "Tree", "Arman"};

            for (String searchTerm : searchTerms) {
                dataList.clearInputField(searchAttendees);
                searchAttendees.sendKeys(searchTerm);

                Thread.sleep(2000);

                Assert.assertTrue(dataList.verifyAttendeesDisplayed(searchTerm));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //Confirmation that the Data List Filter test have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing for Data List Filter passed!");
        }
    }
}
