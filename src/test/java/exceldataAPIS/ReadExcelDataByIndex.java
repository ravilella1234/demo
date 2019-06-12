package exceldataAPIS;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataByIndex 
{

	public static void main(String[] args) throws Exception
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(0);
		
		//String value=String.valueOf(cell.getStringCellValue());
		String value=cell.getStringCellValue();
		//double value=cell.getNumericCellValue();
		//Date value=cell.getDateCellValue();
		//String value = String.valueOf(cell.getNumericCellValue());
		
	
		System.out.println("value of exel cell is :" + value);	
		workbook.close();
		fis.close();

	}

}
