package pageObjects;

import abstractComponents.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class simpleFormDemo extends abstractComponents {

    public WebDriver driver;

    public simpleFormDemo(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }


    @FindBy(id = "user-message")
    WebElement userMessage;

    @FindBy(css = "button[onclick='showInput();']")
    WebElement getInput;

    @FindBy(css = "#display")
    WebElement output;

    @FindBy(id = "value1")
    WebElement value1;

    @FindBy(id = "value2")
    WebElement value2;

    @FindBy(css = "button[onclick='return total()']")
    WebElement returnTotal;

    @FindBy(css = "#displayvalue")
    WebElement output2;

    public void setUserMessage(String message)
    {
        userMessage.sendKeys(message);
    }

    public void getInputClick()
    {
        getInput.click();
    }

    public String getOutput()
    {
        String outputMessage = output.getText();
        return outputMessage;
    }

    public void setValue1(String value)
    {
        value1.sendKeys(value);
    }

    public void setValue2(String value)
    {
        value2.sendKeys(value);
    }

    public void returnTotalClick()
    {
        returnTotal.click();
    }

    public String getOutput2()
    {
        String outputMessage = output2.getText();
        return outputMessage;
    }

    @Test
    public void testSingleInputField() {
        driver.findElement(By.id("user-message")).sendKeys("Hello, World! :)");
        driver.findElement(By.xpath("//*[@id='get-input']/button")).click();
        String output = driver.findElement(By.id("display")).getText();
        assert "Hello, World! :)".equals(output) : "Expected text is not displayed.";

        driver.findElement(By.id("value1")).sendKeys("1");
        driver.findElement(By.id("value2")).sendKeys("2");
        driver.findElement(By.cssSelector("button[onclick='return total()']")).click();
        String output2 = driver.findElement(By.id("displayvalue")).getText();
        assert "3".equals(output2) : "Expected text is not displayed.";

    }

    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Simple Form has passed!");
            driver.close();
        }
    }
}
