package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadDatafromExcelFile {
	public static void main(String[] args) throws IOException  {

//step-1 Load the location of the fileInputStream
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
		
//step-2 Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
//Step 3: get into sheet
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet("Organization");

//Step 4: get into the row
		Row row = (Row) sh.getRow(1);
				
//Step 5: get into the cell
		Cell cel = ((org.apache.poi.ss.usermodel.Row) row).getCell(2);
				
//Step 6: read the value present in the cell
		String value = cel.getStringCellValue();
		System.out.println(value);	
	}
}
