package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.ajaxFormSubmit;
import testComponents.BaseTest;

public class ajaxFormSubmitTest extends BaseTest {

    //Testing for input text field, that upon clicking on the button, the page loads until it states that the form has been submitted successfully.
    //Included assertion whether if the expected results have occurred or not.
    @Test
    public void testSingleInputField() throws InterruptedException {
        ajaxFormSubmit ajax = new ajaxFormSubmit(driver);
        try {
            ajax.goTo();
            ajax.sendData();
            ajax.saveClick();
            Thread.sleep(5000);
            String output = ajax.getMessage();
            assert "Form submited Successfully!".equals(output) : "Expected text is not displayed.";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Ajax Form test passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Ajax Form Submit has passed!");
        }
    }
}
