package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.jQuerySelectDropdown;
import testComponents.BaseTest;

public class jQuerySelectDropdownTest extends BaseTest {

    WebDriverWait wait;


    //Testing for search box dropdown
    //Upon clicking on the dropdown proceed to search and input a country (Netherlands), then select result in dropdown.
    @Test
    public void searchBoxDropdown() {
        jQuerySelectDropdown jQuery = new jQuerySelectDropdown(driver);
        jQuery.goTo();
        try {
            jQuery.dropDown();
            jQuery.inputSearch();
            WebElement selectedValue = jQuery.selectCountry();
            Thread.sleep(2000);
            Assert.assertEquals(selectedValue.getAttribute("title"), "Netherlands", "Selected country is not Netherlands");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for select multiple values
    //Upon clicking on dropdown, multiple values can then be selected (different states)
    @Test
    public void selectMultipleValues() {
        jQuerySelectDropdown jQuery = new jQuerySelectDropdown(driver);
        try {
            jQuery.goTo();
            jQuery.elementClick();
            String[] states = {"Alaska", "California", "New York", "Washington", "Texas"};
            for (String state : states) {
                WebElement selectedState = jQuery.selectState(state);
                Assert.assertTrue(selectedState.isDisplayed(), state + " is not selected");
            }
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for disabled values dropdown
    //Upon clicking on dropdown, ensure that the disabled values cannot be selected
    // (and only the enabled value/s can be selected).
    @Test
    public void disabledValuesDropdown() {
        jQuerySelectDropdown jQuery = new jQuerySelectDropdown(driver);
        try {
            jQuery.goTo();
            jQuery.dropDownDisabled();
            jQuery.inputDisabled();
            jQuery.selectStateDisabled();
            WebElement selectedOption = jQuery.selectedOptionDisabled();
            String selectedText = selectedOption.getText();
            Thread.sleep(2000);
            Assert.assertTrue(selectedText.contains("Puerto Rico"), "Dropdown did not reflect the selection of 'Puerto Rico'");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for category options dropdown
    //This provides a dropdown that are divided by sections per category (row order)
    @Test
    public void categoryOptionsDropdown() {
        jQuerySelectDropdown jQuery = new jQuerySelectDropdown(driver);
        try {
            jQuery.goTo();
            jQuery.dropDownFiles();
            WebElement selectCategory = jQuery.selectCategory();
            Thread.sleep(2000);
            Assert.assertEquals(selectCategory.getText(), "Java", "Selected category is not Java");
            jQuery.dropDownFiles();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the jQuery Select Dropdown test passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of jQuery Select Dropdown has passed!");
        }
    }
}
