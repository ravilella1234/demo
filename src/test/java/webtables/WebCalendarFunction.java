package webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCalendarFunction {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//CheckIn
		driver.get("https://www.tripadvisor.in/");
		driver.findElement(By.xpath("//*[@id=\"c_onboarding-interstitial\"]/div/div[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Flights')]")).click();
		driver.findElement(By.xpath("//div[@class='unified-picker citrus departure']")).click();
	
		Thread.sleep(8000);
		String date="4-July 2019";
		String splitter[]=date.split("-");
		String checkInday=splitter[0];
		String checkInMonth =splitter[1];
		
		selectDate(checkInMonth,checkInday);
		
		Thread.sleep(6000);
		//CheckOut
		driver.findElement(By.xpath("//div[@class='unified-picker citrus ui_picker_arrow_target return focused']")).click();
		String date1="8-July 2019";
		String splitter1[]=date1.split("-");
		String checkOutday=splitter1[0];
		String checkOutMonth =splitter1[1];
		
		selectDate(checkOutMonth,checkOutday);
		
		
	}
	
	
		public static void selectDate(String month_year,String day) throws InterruptedException
		{
			
			List<WebElement> elements= driver.findElements(By.xpath("//div[@class='rsdc-months']/span/span[1]"));
			System.out.println(elements.size());
			for(int i=0;i<elements.size();i++)
			{
				System.out.println(elements.get(i).getText());
				if(elements.get(i).getText().equals(month_year))
				{
					
					List<WebElement> days=driver.findElements(By.xpath("//div[@class='rsdc-months']/span["+(i+1)+"]/span"));
					//List<WebElement> days=driver.findElements(By.xpath("//div[@class='dsdc-months']/span[i]/span"));
					for(WebElement d: days)
					{
						System.out.println(d.getText());
						if(d.getText().equals(day))
						{
							d.click();
							return;
						}
					}
				}
			}
			
			
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='rsdc-next rsdc-nav ui_icon single-chevron-right']")))).click();
			//Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='rsdc-next rsdc-nav ui_icon single-chevron-right']")))).click();

			
			Thread.sleep(2000);
			selectDate(month_year,day);
		}
}
