package browserOptionClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeOptionsExample 
{

	public static void main(String[] args) 
	{
				
		// Pre-requisites - careful edge version
		// logs
		// page load Strategy
		// Binary - No
		// PROXY - https://developer.microsoft.com/en-us/microsoft-edge/platform/issues/5468949/
		// Profiling - No
		// Notifications - No
		
		WebDriver driver;
		
		//logs
		System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
		
		//System.setProperty("webdriver.edge.driver", "D:\\Browser Drivers\\MicrosoftWebDriver.exe");
		//System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
		EdgeOptions opt=new EdgeOptions();
	
		
		//page load Strategy
		opt.setPageLoadStrategy("NONE");
		//opt.setPageLoadStrategy(PageLoadStrategy.NONE);
				
		
		driver=new EdgeDriver(opt);
		driver.get("https://www.amazon.in");
		
		

	}

}
