package pageObjects;

import abstractComponents.abstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inputFormSubmit extends abstractComponents {
    public WebDriver driver;

    public inputFormSubmit(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
    }

    @FindBy(css = "input[placeholder='First Name']")
    WebElement firstName;

    @FindBy(css = "input[placeholder='Last Name']")
    WebElement lastName;

    @FindBy(css = "input[placeholder='E-Mail Address']")
    WebElement emailAddress;

    @FindBy(css = "input[placeholder='(845)555-1212']")
    WebElement phoneNumber;

    @FindBy(css = "input[placeholder='Address']")
    WebElement address;

    @FindBy(css = "input[placeholder='city']")
    WebElement city;

    @FindBy(css = "select[name='state']")
    WebElement state;

    @FindBy(css = "#contact_form > fieldset > div:nth-child(8) > div > div > select > option:nth-child(6)")
    WebElement stateOption;

    @FindBy(css = "input[placeholder='Zip Code']")
    WebElement zipCode;

    @FindBy(css = "input[placeholder='Website or domain name']")
    WebElement website;

    @FindBy(css = "input[value='no']")
    WebElement hostingRadioButton;

    @FindBy(css = "textarea[placeholder='Project Description']")
    WebElement projDesc;

    @FindBy(css = "button[class='btn btn-default']")
    WebElement submit;

    public void sendData(String fName, String lName, String email, String phoneNum, String Address, String City, String zip, String Website, String projDescrip) throws InterruptedException {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailAddress.sendKeys(email);
        phoneNumber.sendKeys(phoneNum);
        address.sendKeys(Address);
        Thread.sleep(1000);
        city.sendKeys(City);
        zipCode.sendKeys(zip);
        website.sendKeys(Website);
        projDesc.sendKeys(projDescrip);
    }

    public void dropDown() {
        state.click();
    }

    public void dropDownSelect() {
        stateOption.click();
    }

    public void submit() {
        submit.click();
    }

    public void radioButtonSelect() {
        hostingRadioButton.click();
    }

    public WebElement getSubmitButton() {
        return submit;
    }
}