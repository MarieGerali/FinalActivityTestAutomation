package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.checkBoxDemo;
import testComponents.BaseTest;

public class checkBoxDemoTest extends BaseTest {

    //Testing for single check box, upon clicking on the checkbox (click on this checkbox) -
    // - it should be checked with a tick on it, and the success message should appear.
    @Test
    public void testSingleCheckBox() {
        checkBoxDemo singleCheck = new checkBoxDemo(driver);
        try {
            singleCheck.goTo();
            WebElement singleCheckbox = singleCheck.singleCheckBoxClick();
            Thread.sleep(5000);
            Assert.assertTrue(singleCheckbox.isSelected(), "Single checkbox is not selected");
            String actualMessage = singleCheck.getSuccessMessage();
            Thread.sleep(2000);
            Assert.assertEquals(actualMessage, "Success - Check box is checked",
                    "Expected success message is not displayed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for multiple checkboxes, upon clicking on the "Check all" button -
    // - all 4 checkboxes are automatically ticked as well.
    @Test
    public void testMultipleCheckBoxes() {
        checkBoxDemo multipleCheck = new checkBoxDemo(driver);
        try {
            multipleCheck.goTo();

            String transformToUncheckAllBtn = multipleCheck.checkAllClick();
            Assert.assertEquals(transformToUncheckAllBtn, "Uncheck All", "The button text does not indicate Uncheck All");

            Thread.sleep(1000);

            multipleCheck.verifyCheckboxSelected("Option 1");
            multipleCheck.verifyCheckboxSelected("Option 2");
            multipleCheck.verifyCheckboxSelected("Option 3");
            multipleCheck.verifyCheckboxSelected("Option 4");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Checkbox Demo tests have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing for Checkboxes Demo have passed!");
        }
    }
}
