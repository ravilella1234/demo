package com.testng.Ecommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static Properties or;
	public static FileInputStream fis;
	public static String projectPath="./";
	public static String screenshotFileName=null;
	
	
	static
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
	}
	
	//Initialize Extent Reports
	public static ExtentReports e = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	public static void init() throws Exception
	{
		p=new Properties();
		fis=new FileInputStream(projectPath+"//data.properties");
		p.load(fis);
		
		or=new Properties();
		fis=new FileInputStream(projectPath+"//OR.properties");
		or.load(fis);
		
		PropertyConfigurator.configure(projectPath+"//log4j.properties");
		
		
		
	}
	
	public static void launch(String browser)
	{
		if(browser.equalsIgnoreCase("CHROME")){
			//System.setProperty("webdriver.chrome.driver", "D:\\Browser_Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Browser_Drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", "D:\\Browser_Drivers\\IEDriverServer.exe");
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", "D:\\Browser_Drivers\\MicrosoftWebDriver.exe");
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")+"//drivers//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	public static void navigate(String url) 
	{
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
	}
	
	public static void selectItem(String locatorKey, int item) 
	{
		Select sel=new Select(getElement(locatorKey));
		sel.selectByIndex(item);
	}
	
	public static void selectItemPage(WebElement locator, int item) 
	{
		Select sel=new Select(locator);
		sel.selectByIndex(item);
	}
	
	
	public static void type(String locatorKey, String value) 
	{
		//driver.findElement(By.name(or.getProperty(locatorKey))).sendKeys(value);
		getElement(locatorKey).sendKeys(value);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		try 
		{
			if(locatorKey.endsWith("_id")) {
				element=driver.findElement(By.id(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_name")) {
				element=driver.findElement(By.name(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_classname")) {
				element=driver.findElement(By.className(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_xpath")) {
				element=driver.findElement(By.xpath(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_css")) {
				element=driver.findElement(By.cssSelector(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_linktext")) {
				element=driver.findElement(By.linkText(or.getProperty(locatorKey)));
			}else if (locatorKey.endsWith("_partiallink")) {
				element=driver.findElement(By.partialLinkText(or.getProperty(locatorKey)));
			}
			else {
				reportFailure("Locator not correct :" + locatorKey);
				Assert.fail("Failed the Test :" + locatorKey);
			}
		} 
		catch (Exception e) 
		{
			reportFailure(e.getMessage());
			e.printStackTrace();
			Assert.fail("Locator not correct :" + e.getMessage());
		}
		return element;
	}
	
	
	public static List<WebElement> getElements(String locatorKey) 
	{
		List<WebElement> elementList=null;
		
			try 
			{
				if(locatorKey.endsWith("_id")) {
					elementList=driver.findElements(By.id(or.getProperty(locatorKey)));
				}else if(locatorKey.endsWith("_name")) {
					elementList=driver.findElements(By.name(or.getProperty(locatorKey)));
				}else if(locatorKey.endsWith("_classname")) {
					elementList=driver.findElements(By.className(or.getProperty(locatorKey)));
				}else if(locatorKey.endsWith("_linktext")) {
					elementList=driver.findElements(By.linkText(or.getProperty(locatorKey)));
				}else if(locatorKey.endsWith("_xpath")) {
					elementList=driver.findElements(By.xpath(or.getProperty(locatorKey)));
				}else if(locatorKey.endsWith("_css")) {
					elementList=driver.findElements(By.cssSelector(or.getProperty(locatorKey)));
				}
				else
				{
					reportFailure("Locator not Correct -" + locatorKey);
					Assert.fail("Locator not Correct -" + locatorKey);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return elementList;	
	}
	

	public static void click(String locatorKey) 
	{
		//driver.findElement(By.xpath(or.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}
	
	
	/********************************* Validations ****************************/
	public static boolean verifyText(String locatorKey, String expectedValue)
	{
			String actualValue = getElement(locatorKey).getText().trim();
			System.out.println(actualValue);
			if(actualValue.equals(expectedValue))
				return true;
			else 
				return false;
	}
	
	
	public static boolean isElementPresent(String locatorKey)
	{
		List<WebElement> elementList=null;
		
		elementList=getElements(locatorKey);
		if(elementList.size()==0)
			return false;
		else
			return true;
	}

	
/********************************* Reporting ****************************/
	
	public static void reportPass(String msg)
	{
		test.log(LogStatus.PASS, msg);
		//takeScreenShot();
	}
	
	
	public static void reportFailure(String msg)
	{
		test.log(LogStatus.FAIL, msg);
		takeScreenShot();
		Assert.fail(msg);
	}
	
	
	
	public static void takeScreenShot() 
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace(":", "_").replace(" ", "_")+".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(scrFile, new File(projectPath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//put screen shot file in extent reports
		test.log(LogStatus.INFO, "Screenshot --> "+ test.addScreenCapture(projectPath+"//failure//"+screenshotFileName));
	}
	
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
	public static  void waitforElement(WebElement locator, int timeInSeconds) 
	{
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));	
	}
	
	
	public static  int ranNumber() 
	{
		Random r=new Random();
		int rnum = r.nextInt(999999);
		
		return rnum;
	}

}
