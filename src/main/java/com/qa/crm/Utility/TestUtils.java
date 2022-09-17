package com.qa.crm.Utility;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.qa.crm.Utility.GlobalVariables.*;

public class TestUtils {

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getExcelData(String sheetName){
        try {
            FileInputStream fis=new FileInputStream(TEST_DATA_EXCEL_PATH);
            book = WorkbookFactory.create(fis);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        sheet=book.getSheet(sheetName);
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
                System.out.print("\t"+data[i][j]);
            }
            System.out.println();
        }
        return data;
    }

    public static void main(String[] args){
        getExcelData("Contacts");
    }
}
