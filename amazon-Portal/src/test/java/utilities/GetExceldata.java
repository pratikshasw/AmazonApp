package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExceldata {
	public static String value;
	static String getData(int row, int cell) throws EncryptedDocumentException, IOException
	{
		String path = "C:\\Users\\Pratiksha\\Desktop\\VELOCITY\\Selenium\\Sceenshots\\Exception.xlsx";
        FileInputStream file =  new FileInputStream(path);
        Workbook w = WorkbookFactory.create(file);
        Sheet sheet = w.getSheet("Sanku");
        int lastRowNumber = sheet.getLastRowNum();
        System.out.println(lastRowNumber);
        Row row1 = sheet.getRow(1);
        int lastCell = row1.getLastCellNum();
        System.out.println(lastCell);
        for(int i =1;i<=lastRowNumber;i++)
        {
        	for(int j=0;j<lastCell;j++)
        	{
        		String value = sheet.getRow(i).getCell(j).getStringCellValue();
        		System.out.print(value+"     ");
        	}
        	System.out.println();
        }
		return value;
		
	}

}
