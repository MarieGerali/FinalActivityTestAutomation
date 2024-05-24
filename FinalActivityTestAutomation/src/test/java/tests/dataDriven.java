package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("C:\\Users\\g12ag\\Desktop\\FinalActivityTestAutomationData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for(int i = 0; i < sheets; i++)
        {
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int column = 0;
                int k = 0;
                while(ce.hasNext())
                {
                    Cell value = ce.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Test case"))
                    {
                        column = k;
                    }
                    k++;
                }
                System.out.print(column);

                while(rows.hasNext())
                {
                    Row r = rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
                    {
                        Iterator <Cell> cv = r.cellIterator();
                        while(cv.hasNext())
                        {
                            a.add(cv.next().getStringCellValue());
                        }
                    }
                }
            }
        }
        return a;
    }
}
