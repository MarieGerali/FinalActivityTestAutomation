package automationData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import java.io.FileInputStream;
import java.io.IOException;

public class dataProvider {
    DataFormatter formatter = new DataFormatter();
    @Test(dataProvider="inputFormData")
    public void inputFormData(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            String address,
            String city,
            String state,
            String zipCode,
            String website,
            String projectDescription)
    {
        System.out.println(firstName + " " +
                lastName + " " +
                email + " " +
                phoneNumber + " " +
                address + " " +
                city + " " +
                state + " " +
                zipCode + " " +
                website + " " +
                projectDescription);
    }

    @DataProvider(name="inputFormData")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\g12ag\\Downloads\\FinalActivityTestAutomationData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=0; i<rowCount-1; i++)
        {
            row = sheet.getRow(i+1);
            for (int j=0; j<colCount; j++)
            {
                XSSFCell cell=row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
