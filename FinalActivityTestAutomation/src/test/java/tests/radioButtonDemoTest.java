package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.radioButtonDemo;
import testComponents.BaseTest;


public class radioButtonDemoTest extends BaseTest {

    //Testing for radio button function
    //The listed radio buttons are under the Gender category. Upon selecting, the text results indicating the
    // - chosen option should be displayed and should match.
    @Test
    public void RadioButtonDemo1() {
        radioButtonDemo radioButton = new radioButtonDemo(driver);
        try {
            radioButton.goTo();
            radioButton.singleRadioButton();
            radioButton.singleCheckValue();
            WebElement resultText = radioButton.setSingleResultText();

            Thread.sleep(2000);

            String actualText = resultText.getText();
            String expectedText = "Radio button 'Female' is checked";
            Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for radio button function
    //The listed radio buttons are under the Gender and Age Group category. Upon selecting, the text results indicating the
    // - chosen options should be displayed and should match.
    @Test(priority = 2)
    public void RadioButtonDemo2() {
        radioButtonDemo radioButton = new radioButtonDemo(driver);
        try {
            radioButton.goTo();
            radioButton.groupRadioButton();
            radioButton.setAgeRadioButton();
            radioButton.getGroupValuesButton();
            WebElement outputText = radioButton.setGroupResultText();

            Thread.sleep(2000);

            String actualText = outputText.getText();
            String expectedText = "Sex : Female\nAge group: 15 - 50";
            Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Radio Button demo tests have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Radio Button demos have passed!");
        }
    }
}
