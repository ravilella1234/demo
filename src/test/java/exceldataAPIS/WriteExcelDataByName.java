package exceldataAPIS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByName 
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("login");
		XSSFRow row=null;
		XSSFCell cell=null;
		
		int colNum=-1;
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Result"));
			{
				colNum=i;
			}
		}
		row=sheet.getRow(2);
		cell=row.getCell(colNum);
		
		cell.setCellValue("Aborted");
		
		fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
