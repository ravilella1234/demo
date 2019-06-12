package browserOptionClasses;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExploreOptionsExample 
{

	public static void main(String[] args) 
	{
		// pre requistes - carefull with IE-11
		// Zoom level must be 100%
		//Protected modes should be either all must be checked or unchecked
		//security - All contents
		//32 bit or 64 bit IE
		
		
		// logs
		// page load Strategy - No
		// Binary - No
		// PROXY
		// Profiling - No
		// Notifications - No
		
		WebDriver driver;
		
		//logs
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
		
		InternetExplorerOptions opt=new InternetExplorerOptions();
		
						
		//proxy servers
		DesiredCapabilities cap=new DesiredCapabilities();
		
		String proxy="80.200.90.81:4444";
		Proxy p =new Proxy();
		p.setAutodetect(false);
		p.setProxyType(p.getProxyType());
		p.setSocksProxy(proxy);
		cap.setCapability(CapabilityType.PROXY, p);
		opt.merge(cap);
		
		
		driver=new InternetExplorerDriver(opt);
		driver.get("https://www.facebook.com");
		//driver.quit();
		
		

	}

}
