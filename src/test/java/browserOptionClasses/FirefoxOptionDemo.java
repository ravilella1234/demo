package browserOptionClasses;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;


public class FirefoxOptionDemo {

	public static void main(String[] args) 
	{
				
		FirefoxOptions option=new FirefoxOptions();
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "d://firefoxlogs.txt");
		
		//option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile profile = p.getProfile("profile2");
		
		profile.setPreference("dom.webnotifications.enabled", false);
	
		option.setProfile(profile);
		
		
		WebDriver driver=new FirefoxDriver(option);
		
		driver.get("https://www.icicibank.com");
		
		driver.manage().window().maximize();
	}

}
