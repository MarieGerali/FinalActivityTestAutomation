package tests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.inputFormSubmit;
import testComponents.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class inputFormSubmitTest extends BaseTest {

    DataFormatter formatter = new DataFormatter();

    //Input Forms in here which includes text fields, dropdowns, radio buttons, and submit button.
    @Test(dataProvider = "inputFormData")
    public void inputFormsSubmit(String firstName,
                                 String lastName,
                                 String email,
                                 String phoneNumber,
                                 String address,
                                 String city,
                                 String zipCode,
                                 String website,
                                 String projDescription) {
        inputFormSubmit formSubmit = new inputFormSubmit(driver);
        formSubmit.goTo();
        try {
            formSubmit.sendData(firstName, lastName, email, phoneNumber, address, city, zipCode, website, projDescription);
            formSubmit.dropDown();
            formSubmit.dropDownSelect();
            formSubmit.radioButtonSelect();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(formSubmit.getSubmitButton()));

            Assert.assertTrue(formSubmit.getSubmitButton().isEnabled(), "Submit button is not clickable");

            formSubmit.submit();

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Data stored in Excel sheet will serve as the data provider which consists of the information to be -
    // - added in every single text field from the form, FileInputStream name can also change depending on the location of the Excel file.
    @DataProvider(name = "inputFormData")
    public Object[][] getUserData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\g12ag\\Downloads\\FinalActivityTestAutomationData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCount - 1][colCount];
        for (int i = 0; i < rowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            System.out.println("Testing of Input Form Submit has passed!");
        }
    }
}