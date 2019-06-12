package exceldataAPIS;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MapwithDataProvider 
{
	@Test(dataProvider="testdata")
	public void test(Map mapdata)
	{
		System.out.println("----------------  Test Started --------------------");
		System.out.println(mapdata.get("UserName"));
		System.out.println(mapdata.get("Password"));
		System.out.println(mapdata.get("DOB"));
		System.out.println("----------------  Test Ended --------------------");
	}
	
	@DataProvider(name="testdata")
	public Object[][] dataProviderMethod() throws Exception
	{
		String filePath="C:\\Users\\DELL\\Desktop\\data.xlsx";
		File  file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("login");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		//define map & objectarray
		Object[][] obj=new Object[rowcount][1];
			
		
		for(int i=0;i<rowcount;i++)
		{
			HashMap<Object, Object> datamap=new HashMap<Object, Object>();
			for(int j=0;j<colcount;j++)
			{
				//read the cell data & store in Map
				datamap.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i+1).getCell(j).toString());
				
			}
			obj[i][0]=datamap;
		}
		
		return obj;
		
	}

}
