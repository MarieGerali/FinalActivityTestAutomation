package pageObjects;

import abstractComponents.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ajaxFormSubmit extends abstractComponents{

    public WebDriver driver;

    public ajaxFormSubmit(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");
    }

    @FindBy(css = "#title")
    WebElement name;

    @FindBy(css = "#description")
    WebElement descBox;

    @FindBy(css = "#btn-submit")
    WebElement save;

    @FindBy(css = "#submit-control")
    WebElement message;

    public void sendData()
    {
        name.sendKeys("Lorem Ipsum");
        descBox.sendKeys("Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit. Nulla euismod sapien orci, " +
                "in facilisis diam vulputate vel. Pellentesque non " +
                "volutpat neque, nec accumsan neque. Aliquam erat " +
                "volutpat. Suspendisse tincidunt sit amet ante " +
                "sed ultrices. Mauris varius massa eget nisl " +
                "pulvinar sollicitudin. In ut faucibus urna. " +
                "Interdum et malesuada fames ac ante ipsum " +
                "primis in faucibus. Nullam at metus eros. " +
                "Etiam imperdiet nibh vitae convallis feugiat. " +
                "Maecenas volutpat mauris et massa consectetur, " +
                "non viverra tortor posuere. Phasellus quis semper " +
                "metus, at sollicitudin lacus. Praesent sed tellus " +
                "risus.");
    }

    public void saveClick()
    {
        save.click();
    }

    public String getMessage()
    {
        String output = message.getText();
        return output;
    }
}



