package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.tableSortAndSearchDemo;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class tableSortAndSearchDemoTest extends BaseTest {

    //Testing for entries dropdown
    //The dropdown should provide options to show 10, 25, 50, to 100 entries on the table.
    @Test
    public void EntriesDropdown() {
        tableSortAndSearchDemo sortAndSearch = new tableSortAndSearchDemo(driver);
        try {
            sortAndSearch.goTo();

            sortAndSearch.dropDownClick();
            WebElement state25 = sortAndSearch.selectState25Click();
            Assert.assertEquals(state25.isSelected(), true, "Expected option is not selected");

            Thread.sleep(1000);

            sortAndSearch.dropDownClick();
            WebElement state50 = sortAndSearch.selectState50Click();
            Assert.assertEquals(state50.isSelected(), true, "Expected option is not selected");

            Thread.sleep(1000);

            sortAndSearch.dropDownClick();
            WebElement state100 = sortAndSearch.selectState100Click();
            Assert.assertEquals(state100.isSelected(), true, "Expected option is not selected");

            Thread.sleep(1000);

            sortAndSearch.dropDownClick();
            WebElement state10 = sortAndSearch.selectState10Click();
            Assert.assertEquals(state10.isSelected(), true, "Expected option is not selected");

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for arrow click
    //Upon clicking on the arrow icons per column, the orders of the entries from the table should be rearranged.
    @Test
    public void ArrowClick() {
        tableSortAndSearchDemo arrowClick = new tableSortAndSearchDemo(driver);
        try {
            arrowClick.goTo();

            WebElement nameArrow = arrowClick.getNameArrow();
            Assert.assertTrue(nameArrow.isDisplayed() && nameArrow.isEnabled(), "Name arrow is not clickable");
            arrowClick.nameArrowClick();
            arrowClick.nameArrowClick();

            Thread.sleep(1000);

            WebElement positionArrow = arrowClick.getPositionArrow();
            Assert.assertTrue(positionArrow.isDisplayed() && positionArrow.isEnabled(), "Position arrow is not clickable");
            arrowClick.positionArrowClick();
            arrowClick.positionArrowClick();

            Thread.sleep(1000);

            WebElement officeArrow = arrowClick.getOfficeArrow();
            Assert.assertTrue(officeArrow.isDisplayed() && officeArrow.isEnabled(), "Office arrow is not clickable");
            arrowClick.officeArrowClick();
            arrowClick.officeArrowClick();

            Thread.sleep(1000);

            WebElement ageArrow = arrowClick.getAgeArrow();
            Assert.assertTrue(ageArrow.isDisplayed() && ageArrow.isEnabled(), "Age arrow is not clickable");
            arrowClick.ageArrowClick();
            arrowClick.ageArrowClick();

            Thread.sleep(1000);

            WebElement startDateArrow = arrowClick.getStartDateArrow();
            Assert.assertTrue(startDateArrow.isDisplayed() && startDateArrow.isEnabled(), "Start date arrow is not clickable");
            arrowClick.startDateArrowClick();
            arrowClick.startDateArrowClick();

            Thread.sleep(1000);

            WebElement salaryArrow = arrowClick.getSalaryArrow();
            Assert.assertTrue(salaryArrow.isDisplayed() && salaryArrow.isEnabled(), "Salary arrow is not clickable");
            arrowClick.salaryArrowClick();
            arrowClick.salaryArrowClick();

            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //Testing for Pagination
    //Upon clicking on "Previous", "Next", or "1, 2, 3, 4" buttons -
    // - The following entries from the table on either the next/previous or first/middle/last pages should appear.
    @Test
    public void Pagination() {
        tableSortAndSearchDemo pagination = new tableSortAndSearchDemo(driver);
        try {
            pagination.goTo();
            Thread.sleep(1000);

            WebElement nextBtn = pagination.getNextBtn();
            Assert.assertTrue(nextBtn.isDisplayed() && nextBtn.isEnabled(), "Next button is not clickable");
            pagination.nextBtnClick();
            Thread.sleep(1000);

            WebElement previousBtn = pagination.getPreviousBtn();
            Assert.assertTrue(previousBtn.isDisplayed() && previousBtn.isEnabled(), "Previous button is not clickable");
            pagination.previousBtnClick();
            Thread.sleep(1000);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for Search feature
    //Upon searching specific information from the field, only the matching result/s should appear from the table.
    @Test(dataProvider = "inputSearch")
    public void Search(String Name) {
        tableSortAndSearchDemo search = new tableSortAndSearchDemo(driver);
        try {
            search.goTo();
            search.searchInput(Name);
            search.searchClear();
            search.searchInput(Name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "inputSearch")
    public Object[][] inputSearch() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\automationData\\inputSearch.json");

        Object[][] testData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i).get("Name");
        }
        return testData;
    }

    //Confirmation that the Table Sort and Search Demo Tests have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Table Sort and Search Demos have passed!");
        }
    }
}
