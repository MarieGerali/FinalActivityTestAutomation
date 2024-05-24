package pageObjects;

import abstractComponents.abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bootstrapProgressBar extends abstractComponents {

    WebDriver driver;

    public bootstrapProgressBar(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
    }

    @FindBy(css = "#cricle-btn")
    WebElement downloadButton;

    @FindBy(css = ".percenttext")
    WebElement percentageText;


    public void clickDownloadBtn() throws InterruptedException {
        downloadButton.click();
    }

    public String checkProgress()
    {
        String text = percentageText.getText().trim();
        return text;
    }
}
