package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.SelectDropdownList;
import testComponents.BaseTest;

import java.time.Duration;

public class SelectDropdownListTest extends BaseTest {

    //Testing for select dropdown list
    //Upon clicking on the dropdown, and selecting a day -
    // - The chosen day from the list should appear in the dropdown box
    @Test(priority = 1)
    public void SelectDropdownList1() {
        SelectDropdownList selectDropdown = new SelectDropdownList(driver);
        selectDropdown.goTo();
        try {
            selectDropdown.dropDownClick();
            selectDropdown.selectDayClick();
            WebElement resultText = selectDropdown.selectDropdownMessage();
            selectDropdown.dropDownClick();

            Thread.sleep(2000);

            String actualText = resultText.getText();
            String expectedText = "Day selected :- Thursday";
            Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for multiple selections
    //Upon navigating the list box, select a state and to achieve multiple selection -
    // - hold shift and select another state from the list box.
    //Results should indicate the first selected state, and all selected states.
    @Test(priority = 2)
    public void testMultipleSelections() {
        SelectDropdownList selectDropdown = new SelectDropdownList(driver);
        selectDropdown.goTo();
        try {
            selectDropdown.MultiSelectDropdown();
            WebElement[] elements = selectDropdown.multiSelectElements();

            Actions actions = new Actions(driver);
            WebElement firstOption = elements[0];
            WebElement eighthOption = elements[1];

            actions.click(firstOption)
                    .keyDown(Keys.CONTROL)
                    .click(eighthOption)
                    .keyUp(Keys.CONTROL)
                    .perform();

            selectDropdown.firstSelectClick();

            Thread.sleep(2000);

            WebElement resultText = selectDropdown.results();
            Assert.assertTrue(resultText.getText().contains("First selected"), "PrintMe validation failed");

            selectDropdown.allSelectClick();
            WebElement allResultText = selectDropdown.results();
            Assert.assertTrue(allResultText.getText().contains("Options selected are"), "PrintAll validation failed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Select Dropdown List tests have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Select Dropdown Lists have passed!");
        }
    }
}
