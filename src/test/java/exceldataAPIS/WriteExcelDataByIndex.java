package exceldataAPIS;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByIndex 
{

	
	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row=null;
		XSSFCell cell=null;
		XSSFFont font=workbook.createFont();
		XSSFCellStyle style=workbook.createCellStyle();
		
		row=sheet.getRow(4);
		cell=row.getCell(4);
		
		font.setFontName("Algerian");
		font.setFontHeight(10.0);
		font.setBold(true);
		
		style.setFont(font);
		
		cell.setCellStyle(style);
		cell.setCellValue("Stop");
		
		
		fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
