package webtables;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTables {

WebDriver d;
	
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	    d=new InternetExplorerDriver();
		d.manage().window().maximize();
		//d.get("http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1");
		d.get("https://www.w3schools.com/html/html_tables.asp");
		//https://money.rediff.com/indices?src=moneyhome_bseIndices_more
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@Test
	public void dynamicTable()throws Exception
	{
		
		//Checks for Table row Count
		List<WebElement> tr_collection=d.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	
		
		int row_num,col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            //System.out.println("NUMBER OF COLUMNS="+row_num+" "+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
               
            	System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
                col_num++;
            }
            row_num++;
        }
       // Thread.sleep(4000);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		//d.quit();
	}

}


