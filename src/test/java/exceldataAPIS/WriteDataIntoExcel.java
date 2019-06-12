package exceldataAPIS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel 
{
	public static final String EXCELFILELOCATION="C:\\Users\\DELL\\Desktop\\data.xlsx";		
			
			
	public static void main(String[] args) throws Exception 
	{
		File file=new File(EXCELFILELOCATION);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("people");
		int rowCount = sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFCell cell = sheet.getRow(i).getCell(1);
			String celltext="";
			
			//get the celltype value
			if(cell.getCellTypeEnum()==CellType.STRING)
			{
				celltext=cell.getStringCellValue();
			}
			else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			{
				celltext=String.valueOf(cell.getNumericCellValue());
				
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
			{
				celltext="";
			}
			
			//check the age & set the cell value into excel
			if(Double.parseDouble(celltext)>=18)
			{
				sheet.getRow(i).getCell(2).setCellValue("Major");
			}
			else
			{
				sheet.getRow(i).getCell(2).setCellValue("Minor");
			}
		}
		
		fis.close();
		
		FileOutputStream fos=new FileOutputStream(EXCELFILELOCATION);
		workbook.write(fos);
		fos.close();
			
	}

}
