package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.bootstrapListBox;
import testComponents.BaseTest;

import java.time.Duration;
import java.util.List;

public class bootstrapListBoxTest extends BaseTest {

    WebDriverWait wait;

    //Testing for search box feature from the boostrap list box test
    //Attempting to search 1 data listed for each column, and only the matching result/s should appear.
    @Test
    public void searchBox() {
        bootstrapListBox searchBox = new bootstrapListBox(driver);
        searchBox.goTo();
        String leftSearch = "Vestibulum at eros";
        String rightSearch = "Porta ac consectetur acs";
        try {
            WebElement searchInputLeft = searchBox.searchInputLeft(leftSearch);
            searchBox.clearInputField(searchInputLeft);

            WebElement searchInputRight = searchBox.searchInputRight(rightSearch);
            searchBox.clearInputField(searchInputRight);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during searchBox test: " + e.getMessage());
        }
    }

    //Testing for moving lists from one column to another
    //The item from the left should move to the right and vice versa.
    @Test
    public void movingListsInColumns() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        bootstrapListBox movingList = new bootstrapListBox(driver);
        try {
            movingList.goTo();
            Thread.sleep(2000);
            movingList.clickLeft5();

            movingList.moveToRight();
            WebElement right5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[5]")));
            Assert.assertTrue(right5.isDisplayed(), "Item did not move to the right list");

            Thread.sleep(1000);

            movingList.clickRight5();
            movingList.moveToLeft();
            WebElement leftOriginal5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[5]")));
            Assert.assertTrue(leftOriginal5.isDisplayed(), "Item did not move back to the left list");

            Thread.sleep(1000);

            movingList.clickLeft4();
            movingList.moveToRight();
            Boolean right4Status = movingList.right4Status();
            Assert.assertTrue(right4Status, "Item 4 did not move to the right list");

            Thread.sleep(1000);

            movingList.clickRight4();
            movingList.moveToLeft();
            WebElement leftOriginal4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[4]")));
            Assert.assertTrue(leftOriginal4.isDisplayed(), "Item 4 did not move back to the left list");

            Thread.sleep(1000);

            movingList.clickLeft3();
            movingList.moveToRight();
            Boolean right3Status = movingList.right3Status();
            Assert.assertTrue(right3Status, "Item 3 did not move to the right list");

            Thread.sleep(1000);

            movingList.clickRight3();
            movingList.moveToLeft();
            WebElement leftOriginal3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[3]")));
            Assert.assertTrue(leftOriginal3.isDisplayed(), "Item 3 did not move back to the left list");

            Thread.sleep(1000);

            movingList.clickLeft2();
            movingList.moveToRight();
            Boolean right2Status = movingList.right2Status();
            Assert.assertTrue(right2Status, "Item 2 did not move to the right list");

            Thread.sleep(1000);

            movingList.clickRight2();
            movingList.moveToLeft();
            WebElement leftOriginal2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[2]")));
            Assert.assertTrue(leftOriginal2.isDisplayed(), "Item 2 did not move back to the left list");

            Thread.sleep(1000);

            movingList.clickLeft1();
            movingList.moveToRight();
            Boolean right1Status = movingList.right1Status();
            Assert.assertTrue(right1Status, "Item 1 did not move to the right list");

            Thread.sleep(1000);

            movingList.clickRight1();
            movingList.moveToLeft();
            WebElement leftOriginal1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[1]")));
            Assert.assertTrue(leftOriginal1.isDisplayed(), "Item 1 did not move back to the left list");

            Thread.sleep(1000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for the feature to select all lists from one column and move them to the other column.
    @Test(priority = 3)
    public void selectAllAndMove() throws InterruptedException {
        bootstrapListBox selectAllAndMove = new bootstrapListBox(driver);
        try {
            selectAllAndMove.goTo();
            selectAllAndMove.selectAll();

            Thread.sleep(2000);

            selectAllAndMove.allRightItems();

            selectAllAndMove.moveToLeft();
            Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li")).isEmpty(), "Right list is not empty after moving items to the left");

            List<WebElement> allLeftItems = selectAllAndMove.allLeftItems();
            Assert.assertFalse(allLeftItems.isEmpty(), "Left list is empty after moving items");

            selectAllAndMove.selectAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Confirmation that the Dual List Box tests passed.
    @AfterTest
    public void After() {
        if (driver != null) {
            System.out.println("Testing of Dual List Box Example passed!");
            driver.quit();
        }
    }
}
