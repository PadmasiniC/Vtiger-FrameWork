package Vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class contains all the generic methods related to excelsheet
 * @Author Padmasini.c
 * 
 */
public class ExcelFileUtility {
	/*
	 * This method will will read from excel sheet-
	 * @param -sheet,row,cell,value
	 * @return value
	 * @throws EncryptedDocumentException, IOException
	 */
	public String readDataFromExcel(String sheet, int row, int cel) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell c=r.getCell(cel);
		String value=c.getStringCellValue();
		wb.close();
		return value;
	}
		/*
	 * This method will return the total no of row in the sheet
	 * @para sheet
	 * @ return
	 * @throws EncryptedDocumentException, IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		int Data=s.getLastRowNum();
		wb.close();
		return Data;
	}
	
	/*
	 * This method will write data into excel sheet
	 * @ para sheet, row,cel, value
	 *  @throws EncryptedDocumentException, IOException
	 */
	public void WriteDataIntoExcel(String sheet, int row, int cel, String Value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell c=r.createCell(cel); // to write into the cell
		c.setCellValue(sheet);
		
		FileOutputStream fos= new FileOutputStream(IconstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
}
