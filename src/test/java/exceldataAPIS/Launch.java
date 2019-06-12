package exceldataAPIS;

import org.openqa.selenium.By;

import com.testng.Ecommerce.BaseTest;

public class Launch extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigate("fburl");
		
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		int rCount = e.getRowCount("login");
		
		for(int i=1;i<rCount;i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			
			Thread.sleep(2000);
		}
		
		

	}

}
