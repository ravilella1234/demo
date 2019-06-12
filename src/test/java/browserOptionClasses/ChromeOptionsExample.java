package browserOptionClasses;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		
		//logs
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		ChromeOptions opt=new ChromeOptions();
		
		//binary -- Not required to set the binaries		
		
		//page load strategy
		opt.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		
		//profiling --> chrome://version
		opt.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		
		
		//notifications
		opt.addArguments("--disable-notifications");
		opt.addArguments("--disable-infobars");
		opt.addArguments("--start-maximized");
		
		
		//proxy servers  -- //chrome://version
		//opt.addArguments("--proxy-server=http://192.168.90.84:1234");
		
		
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver(opt);
		driver.get("https://www.icicibank.com");
		
		

	}

}
