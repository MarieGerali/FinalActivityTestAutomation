package pageObjects;

import abstractComponents.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class bootstrapListBox extends abstractComponents {

    public WebDriver driver;

    public bootstrapListBox(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
    }

    @FindBy(xpath = "//*[@id='listhead']/div[1]/div/input")
    WebElement searchInputLeft;

    @FindBy(xpath = "//*[@id='listhead']/div[2]/div/input")
    WebElement searchInputRight;

    public WebElement searchInputLeft(String leftSearch)
    {
        WebElement left = searchInputLeft;
        left.sendKeys(leftSearch);
        return left;
    }

    public WebElement searchInputRight(String rightSearch)
    {
        WebElement right = searchInputRight;
        right.sendKeys(rightSearch);
        return right;
    }

    public void clearInputField(WebElement element) {
        element.sendKeys(Keys.END);

        int length = element.getAttribute("value").length();

        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(1)")
    WebElement left5;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(1)")
    WebElement right5;

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(1)")
    WebElement left4;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(1)")
    WebElement right4;

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(1)")
    WebElement left3;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(1)")
    WebElement right3;

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(1)")
    WebElement left2;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(1)")
    WebElement right2;

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(1)")
    WebElement left1;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(1)")
    WebElement right1;

    @FindBy(css = ".btn.btn-default.btn-sm.move-right")
    WebElement moveToRight;

    @FindBy(css = ".btn.btn-default.btn-sm.move-left")
    WebElement moveToLeft;

    public void moveToLeft()
    {
        moveToLeft.click();
    }

    public void moveToRight()
    {
        moveToRight.click();
    }

    public void clickLeft5()
    {
        left5.click();
    }

    public void clickRight5()
    {
        right5.click();
    }

    public void clickLeft4()
    {
        left4.click();
    }

    public void clickRight4()
    {
        right4.click();
    }

    public Boolean right4Status()
    {
        Boolean right4Status = right4.isDisplayed();
        return right4Status;
    }

    public void clickLeft3()
    {
        left3.click();
    }

    public void clickRight3()
    {
        right3.click();
    }

    public Boolean right3Status()
    {
        Boolean right3Status = right3.isDisplayed();
        return right3Status;
    }

    public void clickLeft2()
    {
        left2.click();
    }

    public void clickRight2()
    {
        right2.click();
    }

    public Boolean right2Status()
    {
        Boolean right2Status = right2.isDisplayed();
        return right2Status;
    }

    public void clickLeft1()
    {
        left1.click();
    }

    public void clickRight1()
    {
        right1.click();
    }

    public Boolean right1Status()
    {
        Boolean right1Status = right1.isDisplayed();
        return right1Status;
    }



    @Test(priority = 2)
    public void movingListsInColumns() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement left5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[5]")));
        left5.click();
        WebElement moveToRight = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]")));
        moveToRight.click();
        WebElement right5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[5]")));
        Assert.assertTrue(right5.isDisplayed(), "Item did not move to the right list");

        WebElement moveToLeft = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]")));
        right5.click();
        moveToLeft.click();
        WebElement leftOriginal5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[5]")));
        Assert.assertTrue(leftOriginal5.isDisplayed(), "Item did not move back to the left list");

        WebElement left4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[4]")));
        left4.click();
        moveToRight.click();
        WebElement right4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[4]")));
        Assert.assertTrue(right4.isDisplayed(), "Item 4 did not move to the right list");

        right4.click();
        moveToLeft.click();
        WebElement leftOriginal4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[4]")));
        Assert.assertTrue(leftOriginal4.isDisplayed(), "Item 4 did not move back to the left list");

        WebElement left3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[3]")));
        left3.click();
        moveToRight.click();
        WebElement right3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[3]")));
        Assert.assertTrue(right3.isDisplayed(), "Item 3 did not move to the right list");

        right3.click();
        moveToLeft.click();
        WebElement leftOriginal3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[3]")));
        Assert.assertTrue(leftOriginal3.isDisplayed(), "Item 3 did not move back to the left list");

        WebElement left2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[2]")));
        left2.click();
        moveToRight.click();
        WebElement right2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[2]")));
        Assert.assertTrue(right2.isDisplayed(), "Item 2 did not move to the right list");

        right2.click();
        moveToLeft.click();
        WebElement leftOriginal2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[2]")));
        Assert.assertTrue(leftOriginal2.isDisplayed(), "Item 2 did not move back to the left list");

        WebElement left1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[1]")));
        left1.click();
        moveToRight.click();
        WebElement right1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[1]")));
        Assert.assertTrue(right1.isDisplayed(), "Item 1 did not move to the right list");

        right1.click();
        moveToLeft.click();
        WebElement leftOriginal1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[1]")));
        Assert.assertTrue(leftOriginal1.isDisplayed(), "Item 1 did not move back to the left list");
    }

    @FindBy(xpath = "//*[@id='listhead']/div[1]/div/a/i")
    WebElement selectAll;

    @FindBy(css = "div[class='well text-right'] ul[class='list-group']")
    List<WebElement> allLeftItems;

    public void selectAll()
    {
        selectAll.click();
    }

    public void allRightItems()
    {
        List<WebElement> allRightItems = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li"));
        for (WebElement item : allRightItems) {
            Assert.assertFalse(item.isSelected(), "Not all items in the right list are selected");
        }
    }

    public List<WebElement> allLeftItems()
    {
        List<WebElement> leftItems = allLeftItems;
        return leftItems;
    }

    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Dual List Box Example has passed!");
            driver.quit();
        }
    }

}
