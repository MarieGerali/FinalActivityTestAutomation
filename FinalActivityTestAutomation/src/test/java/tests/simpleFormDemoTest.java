package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.simpleFormDemo;
import testComponents.BaseTest;

public class simpleFormDemoTest extends BaseTest {

    //Testing for single input field
    //Input a text in the text field and click on "Show Message" button
    //Results should indicate that the text is displayed upon clicking the button.
    @Test
    public void testSingleInputField() {
        simpleFormDemo simpleForm = new simpleFormDemo(driver);
        try {
            simpleForm.goTo();
            simpleForm.setUserMessage("Hello, World! :)");
            simpleForm.getInputClick();
            String output = simpleForm.getOutput();
            Thread.sleep(2000);
            assert "Hello, World! :)".equals(output) : "Expected text is not displayed.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for two input fields
    //Input a value on both fields, and upon clicking on the "Get Total" button -
    // - the total value should be displayed.
    @Test
    public void testTwoInputField() {
        simpleFormDemo twoForms = new simpleFormDemo(driver);
        try {
            twoForms.goTo();
            twoForms.setValue1("1");
            twoForms.setValue2("2");
            twoForms.returnTotalClick();
            String output2 = twoForms.getOutput2();
            Thread.sleep(2000);
            assert "3".equals(output2) : "Expected text is not displayed.";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //Confirmation that the Simple Form tests have passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Simple Form has passed!");
        }
    }
}
