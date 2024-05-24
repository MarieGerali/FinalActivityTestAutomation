package abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class abstractComponents{

    WebDriver driver;

    public abstractComponents(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
