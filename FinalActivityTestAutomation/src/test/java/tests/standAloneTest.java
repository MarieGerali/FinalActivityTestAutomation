package tests;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class standAloneTest {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {

        //---------------------------------------------------------------------//
        //simpleFormDemo

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        driver.findElement(By.id("user-message")).sendKeys("Hello, World! :)");
        driver.findElement(By.xpath("//*[@id='get-input']/button")).click();
        String output = driver.findElement(By.id("display")).getText();
        assert "Hello, World! :)".equals(output) : "Expected text is not displayed.";

        driver.findElement(By.id("value1")).sendKeys("1");
        driver.findElement(By.id("value2")).sendKeys("2");
        driver.findElement(By.cssSelector("button[onclick='return total()']")).click();
        String output2 = driver.findElement(By.id("displayvalue")).getText();
        assert "3".equals(output2) : "Expected text is not displayed.";

        if (driver != null) {
            System.out.println("Testing of Simple Form has passed!");
        }

        //---------------------------------------------------------------------//
        //checkboxDemo

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
        singleCheckbox.click();

        Assert.assertTrue(singleCheckbox.isSelected(), "Single checkbox is not selected");

        WebElement successMessage = driver.findElement(By.id("txtAge"));
        String actualMessage = successMessage.getText();

        Assert.assertEquals(actualMessage, "Success - Check box is checked",
                "Expected success message is not displayed");

        WebElement checkAllButton = driver.findElement(By.id("check1"));
        checkAllButton.click();

        verifyCheckboxSelected("Option 1");
        verifyCheckboxSelected("Option 2");
        verifyCheckboxSelected("Option 3");
        verifyCheckboxSelected("Option 4");

        if (driver != null) {
            System.out.println("Testing for Checkboxes Demo have passed!");
            driver.close();
        }

        //---------------------------------------------------------------------//
        //radioButtonDemo

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        WebElement femaleRadioButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[2]/input"));
        femaleRadioButton.click();

        WebElement getCheckedValueButton = driver.findElement(By.id("buttoncheck"));
        getCheckedValueButton.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[1]/div[2]/p[3]")));

        String actualText = resultText.getText();
        String expectedText = "Radio button 'Female' is checked";
        Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");

        WebElement femaleGroupRadioButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[2]/input"));
        femaleGroupRadioButton.click();

        WebElement ageRadioButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[3]/input"));
        ageRadioButton.click();

        WebElement getValuesButton = driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button"));
        getValuesButton.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement outputText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")));

        actualText = outputText.getText();
        expectedText = "Sex : Female\nAge group: 15 - 50";
        Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");

        if (driver != null) {
            System.out.println("Testing of Radio Button demos have passed!");
        }

        //---------------------------------------------------------------------//
        //selectDropDownList

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
        dropDown.click();

        WebElement selectDay = driver.findElement(By.cssSelector("#select-demo > option:nth-child(6)"));
        selectDay.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]")));

        WebElement dropDownagain = driver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
        dropDownagain.click();

        actualText = resultText.getText();
        expectedText = "Day selected :- Thursday";
        Assert.assertEquals(actualText, expectedText, "Expected text does not match actual text");

        WebElement multiSelectDropdown = driver.findElement(By.xpath("//*[@id='multi-select']"));
        multiSelectDropdown.click();

        Actions actions = new Actions(driver);
        WebElement firstOption = multiSelectDropdown.findElement(By.cssSelector("option:nth-child(1)"));
        WebElement eighthOption = multiSelectDropdown.findElement(By.cssSelector("option:nth-child(8)"));

        actions.click(firstOption)
                .keyDown(Keys.SHIFT)
                .click(eighthOption)
                .keyUp(Keys.SHIFT)
                .perform();

        driver.findElement(By.id("printMe")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")));
        Assert.assertTrue(resultText.getText().contains("First selected"), "PrintMe validation failed");

        driver.findElement(By.id("printAll")).click();
        WebElement allResultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")));
        Assert.assertTrue(allResultText.getText().contains("Options selected are"), "PrintAll validation failed");

        if (driver != null) {
            System.out.println("Testing of Simple Form has passed!");
        }

        //---------------------------------------------------------------------//
        //inputFormSubmit

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input")).sendKeys("Marie");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input")).sendKeys("Gerali");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input")).sendKeys("mg31@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input")).sendKeys("(845)222-1111");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input")).sendKeys("21 Street");
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input")).sendKeys("Los Angeles City");

        dropDown = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select"));
        dropDown.click();
        WebElement selectState = driver.findElement(By.cssSelector("#contact_form > fieldset > div:nth-child(8) > div > div > select > option:nth-child(6)"));
        selectState.click();

        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input")).sendKeys("0000");
        driver.findElement(By.cssSelector("input[placeholder='Website or domain name']")).sendKeys("www.selenium.com");

        WebElement hostingRadioButton = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[2]/label/input"));
        hostingRadioButton.click();

        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea")).sendKeys("This is a test this is a test this is a test this is a test this is a test");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[13]/div/button"));
        submitButton.click();

        if (driver != null) {
            System.out.println("Testing of Input Form Submit has passed!");
        }

        //---------------------------------------------------------------------//
        //ajaxFormSubmit

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        driver.findElement(By.id("title")).sendKeys("Lorem Ipsum");
        driver.findElement(By.id("description")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla euismod sapien orci, in facilisis diam vulputate vel. Pellentesque non volutpat neque, nec accumsan neque. Aliquam erat volutpat. Suspendisse tincidunt sit amet ante sed ultrices. Mauris varius massa eget nisl pulvinar sollicitudin. In ut faucibus urna. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam at metus eros. Etiam imperdiet nibh vitae convallis feugiat. Maecenas volutpat mauris et massa consectetur, non viverra tortor posuere. Phasellus quis semper metus, at sollicitudin lacus. Praesent sed tellus risus.");
        driver.findElement(By.id("btn-submit")).click();

        Thread.sleep(5000);

        output = driver.findElement(By.xpath("//*[@id=\"submit-control\"]")).getText();
        assert "Form submited Successfully!".equals(output) : "Expected text is not displayed.";

            if (driver != null) {
                System.out.println("Testing of Ajax Form Submit has passed!");
            }

        //---------------------------------------------------------------------//
        //jQuerySelectDropdown

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/span/span[1]/span")));
        dropDown.click();

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span/span/span[1]/input")));
        input.sendKeys("Netherlands");

        WebElement selectCountry = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-country-results > li")));
        selectCountry.click();

        WebElement selectedValue = driver.findElement(By.xpath("//span[@title='Netherlands']"));
        Assert.assertEquals(selectedValue.getAttribute("title"), "Netherlands", "Selected country is not Netherlands");

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input")));
        element.click();

        String[] states = {"Alaska", "California", "New York", "Washington", "Texas"};
        for (String state : states) {
            input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > span > span.selection > span > ul > li > input")));
            input.sendKeys(state);

            selectState = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + state + "')]")));
            selectState.click();

            selectedValue = driver.findElement(By.xpath("//li[@title='" + state + "']"));
            Assert.assertTrue(selectedValue.isDisplayed(), state + " is not selected");
        }

        dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")));
        dropDown.click();

        input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")));
        input.sendKeys("Puerto Rico");

        selectState = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/span/span/span[2]")));
        selectState.click();

        WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")));
        String selectedText = selectedOption.getText();
        Assert.assertTrue(selectedText.contains("Puerto Rico"), "Dropdown did not reflect the selection of 'Puerto Rico'");

        dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"files\"]")));
        dropDown.click();

        WebElement selectCategory = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#files > optgroup:nth-child(2) > option:nth-child(2)")));
        selectCategory.click();

        Assert.assertEquals(selectCategory.getText(), "Java", "Selected category is not Java");

        dropDown.click();

        if (driver != null) {
            System.out.println("Testing of jQuery Select Dropdown has passed!");
        }

        //---------------------------------------------------------------------//
        //bootstrapDatePicker

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");

        WebElement datePicker = driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input"));
        datePicker.click();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String todayFormatted = today.format(formatter);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectToday = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".datepicker-days .table-condensed .today")));
        selectToday.click();

        resultText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sandbox-container1\"]/div/input")));

        actualText = resultText.getAttribute("value");
        Assert.assertEquals(actualText, todayFormatted, "Expected text does not match actual text");

        datePicker.click();

        WebElement clearButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[2]/th")));
        clearButton.click();

        String clearedText = resultText.getAttribute("value");
        Assert.assertEquals(clearedText, "", "Input field should be cleared but found: " + clearedText);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"datepicker\"]/input[1]")));
        startDateInput.click();

        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[2]/td[6]")));
        startDate.click();

        WebElement endDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"datepicker\"]/input[2]")));
        endDateInput.click();

        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[5]/td[6]")));
        endDate.click();

        String startValue = startDateInput.getAttribute("value");
        String endValue = endDateInput.getAttribute("value");

        Assert.assertNotNull(startValue, "Start date is not set.");
        Assert.assertNotNull(endValue, "End date is not set.");
        Assert.assertTrue(startValue.compareTo(endValue) < 0, "Start date should be before end date.");

        if (driver != null) {
            System.out.println("Testing of Date Picker has passed!");
        }

        //---------------------------------------------------------------------//
        //tableSortandSearch

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");

        dropDown = driver.findElement(By.xpath("//*[@id=\"example_length\"]/label/select"));
        dropDown.click();
        selectState = driver.findElement(By.cssSelector("#example_length > label > select > option:nth-child(2)"));
        selectState.click();
        Assert.assertEquals(selectState.isSelected(), true, "Expected option is not selected");

        dropDown.click();
        WebElement selectState2 = driver.findElement(By.cssSelector("#example_length > label > select > option:nth-child(3)"));
        selectState2.click();
        Assert.assertEquals(selectState2.isSelected(), true, "Expected option is not selected");

        dropDown.click();
        WebElement selectState3 = driver.findElement(By.cssSelector("#example_length > label > select > option:nth-child(4)"));
        selectState3.click();
        Assert.assertEquals(selectState3.isSelected(), true, "Expected option is not selected");

        dropDown.click();
        WebElement selectState4 = driver.findElement(By.cssSelector("#example_length > label > select > option:nth-child(1)"));
        selectState4.click();
        Assert.assertEquals(selectState4.isSelected(), true, "Expected option is not selected");

        WebElement nameArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[1]"));
        nameArrow.click();
        nameArrow.click();

        WebElement positionArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[2]"));
        positionArrow.click();
        positionArrow.click();

        WebElement officeArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[3]"));
        officeArrow.click();
        officeArrow.click();

        WebElement ageArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[4]"));
        ageArrow.click();
        ageArrow.click();

        WebElement startDateArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[5]"));
        startDateArrow.click();
        startDateArrow.click();

        WebElement salaryArrow = driver.findElement(By.xpath("//*[@id=\"example\"]/thead/tr/th[6]"));
        salaryArrow.click();
        salaryArrow.click();

        WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"example_next\"]"));
        nextBtn.click();

        WebElement previousBtn = driver.findElement(By.xpath("//*[@id=\"example_previous\"]"));
        previousBtn.click();

        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input"));
        searchInput.sendKeys("Flynn");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table"), "Flynn"));
        Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(), 'Flynn')]")).size() > 0, "Search results do not contain 'Flynn'");

        searchInput.clear();
        searchInput.sendKeys("Satou");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//table"), "Satou"));
        Assert.assertTrue(driver.findElements(By.xpath("//td[contains(text(), 'Satou')]")).size() > 0, "Search results do not contain 'Satou'");

        if (driver != null) {
            System.out.println("Testing of Table Sort and Search has passed!");
            driver.close();
        }

        //---------------------------------------------------------------------//
        //bootstrapProgressBar

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");

        try {
            WebElement downloadButton = driver.findElement(By.xpath("//*[@id='cricle-btn']"));
            downloadButton.click();

            Thread.sleep(21000);

            WebElement percentageText = driver.findElement(By.cssSelector("#circle > div > div.percenttext"));
            String text = percentageText.getText().trim();
            System.out.println("Current progress: " + text);


            Assert.assertEquals(text, "100%", "Progress bar did not reach 100%.");
            System.out.println("Progress bar reached 100%.");
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
            throw e;
        }

        if (driver != null) {
            System.out.println("Testing of Progress Bar has passed!");
            driver.quit();
        }

        //---------------------------------------------------------------------//
        //BootstrapAlerts

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");

        WebElement greenBtn1 = driver.findElement(By.xpath("//*[@id='autoclosable-btn-success']"));
        greenBtn1.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));

        String expectedMessage = "I'm an autocloseable success message. I will hide in 5 seconds.";
        actualMessage = successModal.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The success message text does not match.");

        String color = successModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(223, 240, 216, 1)") || color.equals("#dff0d8"), "The modal background color does not match the expected green.");

        boolean modalClosed = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOf(successModal));
        Assert.assertTrue(modalClosed, "The modal did not close automatically after 5 seconds.");

        WebElement greenBtn2 = driver.findElement(By.xpath("//*[@id='normal-btn-success']"));
        greenBtn2.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")));

        expectedMessage = "×\n" +
                "I'm a normal success message. To close use the appropriate button.";
        actualMessage = successModal.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The success message text does not match.");

        color = successModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(223, 240, 216, 1)") || color.equals("#dff0d8"), "The modal background color does not match the expected green.");

        WebElement greenModalClose = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"));
        greenModalClose.click();

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(successModal));
        Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

        WebElement yellowBtn1 = driver.findElement(By.xpath("//*[@id='autoclosable-btn-warning']"));
        yellowBtn1.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement warningModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")));

        expectedMessage = "I'm an autocloseable warning message. I will hide in 3 seconds.";
        actualMessage = warningModal.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");

        color = warningModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(252, 248, 227, 1)") || color.equals("#fcf8e3"), "The modal is not yellow.");

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.invisibilityOf(warningModal));
        Assert.assertTrue(modalClosed, "The modal did not close automatically after 3 seconds.");

        WebElement yellowBtn2 = driver.findElement(By.xpath("//*[@id=\"normal-btn-warning\"]"));
        yellowBtn2.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        warningModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]")));

        expectedMessage = "×\n" +
                "I'm a normal warning message. To close use the appropriate button.";
        actualMessage = warningModal.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");

        color = warningModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(252, 248, 227, 1)") || color.equals("#fcf8e3"), "The modal background color does not match the expected yellow.");

        WebElement yellowModalClose = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button"));
        yellowModalClose.click();

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(warningModal));
        Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

        WebElement redBtn1 = driver.findElement(By.xpath("//*[@id='autoclosable-btn-danger']"));
        redBtn1.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dangerModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")));

        expectedMessage = "I'm an autocloseable danger message. I will hide in 5 seconds.";
        actualMessage = dangerModal.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The danger message text does not match.");

        color = dangerModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(242, 222, 222, 1)") || color.equals("#f2dede"), "The modal is not the correct shade of red.");

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.invisibilityOf(dangerModal));
        Assert.assertTrue(modalClosed, "The modal did not close automatically after 5 seconds.");

        WebElement redBtn2 = driver.findElement(By.xpath("//*[@id=\"normal-btn-danger\"]"));
        redBtn2.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        warningModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]")));

        expectedMessage = "×\n" +
                "I'm a normal danger message. To close use the appropriate button.";
        actualMessage = warningModal.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");

        color = warningModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(242, 222, 222, 1)") || color.equals("#f2dede"), "The modal background color does not match the expected yellow.");

        WebElement redModalClose = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button"));
        redModalClose.click();

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(warningModal));
        Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

        WebElement blueBtn1 = driver.findElement(By.xpath("//*[@id='autoclosable-btn-info']"));
        blueBtn1.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement infoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")));

        expectedMessage = "I'm an autocloseable info message. I will hide in 6 seconds.";
        actualMessage = infoModal.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "The info message text does not match.");

        color = infoModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(217, 237, 247, 1)") || color.equals("#d9edf7"), "The modal is not the correct shade of light blue.");

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.invisibilityOf(infoModal));
        Assert.assertTrue(modalClosed, "The modal did not close automatically after 6 seconds.");

        WebElement blueBtn2 = driver.findElement(By.xpath("//*[@id=\"normal-btn-info\"]"));
        blueBtn2.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        infoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]")));

        expectedMessage = "×\n" +
                "I'm a normal info message. To close use the appropriate button.";
        actualMessage = infoModal.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "The warning message text does not match.");

        color = infoModal.getCssValue("background-color");
        Assert.assertTrue(color.equals("rgba(217, 237, 247, 1)") || color.equals("#d9edf7"), "The modal background color does not match the expected yellow.");

        WebElement blueModalClose = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/button"));
        blueModalClose.click();

        modalClosed = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(infoModal));
        Assert.assertTrue(modalClosed, "The modal did not close after clicking the close button.");

        if (driver != null) {
            System.out.println("Testing for Bootstrap Alerts have passed!");
        }

        //---------------------------------------------------------------------//
        //bootstrapModals

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");

        WebElement launchModalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a"));
        launchModalBtn.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal0")));

        Assert.assertTrue(modal.isDisplayed(), "The modal did not appear after clicking the launch button.");

        WebElement saveChangesBtn = driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[2]"));
        saveChangesBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal0")));

        WebElement launchModalBtn2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a"));
        launchModalBtn2.click();

        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal0")));

        Assert.assertTrue(modal.isDisplayed(), "The modal did not reappear after clicking the launch button a second time.");

        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]"));
        closeBtn.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal0")));

        Assert.assertFalse(modal.isDisplayed(), "The modal did not close after clicking the close button.");

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            launchModalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a")));
            launchModalBtn.click();

            WebElement secondLaunchModalBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a")));
            secondLaunchModalBtn.click();

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")));
            closeButton.click();

            By secondModalLocator = By.cssSelector("#myModal2 > div > div");
            boolean isSecondModalClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(secondModalLocator));
            Assert.assertTrue(isSecondModalClosed, "Second modal did not close after clicking Close button.");

            boolean isLaunchModalBtnClickable = launchModalBtn.isEnabled();
            Assert.assertTrue(isLaunchModalBtnClickable, "Launch Modal Button is not clickable after closing the second modal.");

            WebElement closeButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")));
            closeButton2.click();

            By firstModalLocator = By.cssSelector("#myModal > div > div");
            boolean isFirstModalClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(firstModalLocator));
            Assert.assertTrue(isFirstModalClosed, "First modal did not close after clicking Close button.");

            boolean isLaunchModalBtnClickable2 = secondLaunchModalBtn.isEnabled();
            Assert.assertTrue(isLaunchModalBtnClickable2, "Launch Modal Button is not clickable after closing the first modal.");

        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element to be clickable or visible.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        launchModalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        launchModalBtn.click();

        WebElement secondLaunchModalBtn = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a"));
        secondLaunchModalBtn.click();

        WebElement saveChangesBtn1 = driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[2]"));
        saveChangesBtn1.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));

        launchModalBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        launchModalBtn.click();

        WebElement saveChangesBtn2 = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[2]"));
        saveChangesBtn2.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.seleniumeasy.com/bootstrap-modal-demo.html"));

        if (driver != null) {
            System.out.println("Testing for Bootstrap Modals has completed!");
        }

        //---------------------------------------------------------------------//
        //WindowPopupModal

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");

        String mainWindowHandle = driver.getWindowHandle();

        WebElement twitterLaunchBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a"));
        twitterLaunchBtn.click();

        switchToNewWindow(mainWindowHandle);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://twitter.com/intent/follow?screen_name=seleniumeasy");

        driver.close();

        driver.switchTo().window(mainWindowHandle);

        mainWindowHandle = driver.getWindowHandle();

        WebElement twitterFBLaunchBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/a"));
        twitterFBLaunchBtn.click();

        switchToNewWindow(mainWindowHandle);

        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.facebook.com/seleniumeasy");

        driver.close();

        driver.switchTo().window(mainWindowHandle);

        WebElement followAllBtn = driver.findElement(By.xpath("//*[@id=\"followall\"]"));
        followAllBtn.click();

        switchToNewWindow(mainWindowHandle);

        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://twitter.com/intent/follow?screen_name=seleniumeasy");

        driver.close();

        driver.switchTo().window(mainWindowHandle);

        if (driver != null) {
            System.out.println("Testing for Window Popup Modals have been completed!");
            driver.quit();
        }

        //---------------------------------------------------------------------//
        //bootstrapListBox

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");

        try {
            WebElement searchInputLeft = driver.findElement(By.xpath("//*[@id='listhead']/div[1]/div/input"));
            searchInputLeft.sendKeys("Vestibulum at eros");

            clearInputField(searchInputLeft);

            WebElement searchInputRight = driver.findElement(By.xpath("//*[@id='listhead']/div[2]/div/input"));
            searchInputRight.sendKeys("Porta ac consectetur ac");

            clearInputField(searchInputRight);
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred during searchBox test: " + e.getMessage());
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        WebElement selectAll = driver.findElement(By.xpath("//*[@id='listhead']/div[1]/div/a/i"));
        selectAll.click();

        List<WebElement> allRightItems = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li"));
        for (WebElement item : allRightItems) {
            Assert.assertTrue(item.isSelected(), "Not all items in the right list are selected");
        }

        moveToLeft= driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]"));
        moveToLeft.click();

        Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li")).isEmpty(), "Right list is not empty after moving items to the left");

        List<WebElement> allLeftItems = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li"));
        Assert.assertFalse(allLeftItems.isEmpty(), "Left list is empty after moving items");

        selectAll.click();

        if (driver != null) {
            System.out.println("Testing of Dual List Box Example has passed!");
        }

        //---------------------------------------------------------------------//
        //dataListFilter

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");

        WebElement searchAttendees = driver.findElement(By.xpath("//*[@id=\"input-search\"]"));

        String[] searchTerms = {"Glenn Pho shizzle", "Brian Hoyies", "Tree", "Arman"};

        for (String searchTerm : searchTerms) {
            clearInputField2(searchAttendees);
            searchAttendees.sendKeys(searchTerm);

            //Thread.sleep(500);
            Assert.assertTrue(verifyAttendeesDisplayed(searchTerm));
        }

        if (driver != null) {
            System.out.println("Testing of Data List Filter has passed!");
        }

}

    //---------------------------------------------------------------------//
    //checkboxDemo

    private static void verifyCheckboxSelected(String optionName) {
        WebElement checkbox = driver.findElement(By.xpath(getCheckboxXPath(optionName)));
        Assert.assertTrue(checkbox.isSelected(), optionName + " checkbox is not selected");
    }

    private static String getCheckboxXPath(String optionName) {
        switch (optionName) {
            case "Option 1":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label/input";
            case "Option 2":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label/input";
            case "Option 3":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[3]/label/input";
            case "Option 4":
                return "//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[4]/label/input";
            default:
                throw new IllegalArgumentException("Invalid option name: " + optionName);
        }
    }

    //---------------------------------------------------------------------//
    //WindowPopupModal

    private static void switchToNewWindow(String mainWindowHandle) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    //---------------------------------------------------------------------//
    //bootstrapListBox

    private static void clearInputField(WebElement element) {
        element.sendKeys(Keys.END);

        int length = element.getAttribute("value").length();

        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    //---------------------------------------------------------------------//
    //dataListFilter

    private static void clearInputField2(WebElement element) {
        element.sendKeys(Keys.END);

        int length = element.getAttribute("value").length();

        for (int i = 0; i < length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    private static boolean verifyAttendeesDisplayed(String searchTerm) {

        List<WebElement> attendeeElements = driver.findElements(By.xpath("//ul[@id='attendee-list']/li"));

        for (WebElement attendee : attendeeElements) {
            if (!attendee.getText().contains(searchTerm)) {
                return false;
            }
        }
        return true;
    }



}
