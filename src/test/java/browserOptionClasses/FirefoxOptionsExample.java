package browserOptionClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class FirefoxOptionsExample 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//logs
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	
		
		FirefoxOptions option=new FirefoxOptions();
		
		//binary
		option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		
		//page load strategy
		option.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		
		
		//profiling --> firefox.exe -p
		ProfilesIni allprof=new ProfilesIni();
		FirefoxProfile prof = allprof.getProfile("mysampleprofile");
		
		
		//notifications
		prof.setPreference("dom.webnotifications.enabled", false);
		
		
		//prof.setAcceptUntrustedCertificates(true);
		//prof.setAssumeUntrustedCertificateIssuer(false);
		
		
		//proxy servers
		prof.setPreference("network.proxy.type", 1);
		prof.setPreference("network.proxy.socks", "192.168.90.54");
		prof.setPreference("network.proxy.socks_port", 1744);
		
		
		option.setProfile(prof);
		
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
		driver=new FirefoxDriver(option);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Hi ...!");
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		//driver.get("http://www.amazon.in/");
		//driver.get("https://72.21.215.90");
		System.out.println("Hello ....!");
		
		
		
		/*//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		
		//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get("https://www.snapdeal.com");
		
		
		//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.flipkart.com");*/
		
		

	}

}
