package actionsAndJavaScriptExecutors;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScriptExceutor 
{

	public static void main(String[] args) throws InterruptedException 
	{		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.get("https://www.facebook.com");
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='ravilella'");	
		
		String v = js.executeScript("return document.title").toString();
		System.out.println(v);
		
		//js.executeScript("document.getElementById('email').value='ravilella'");
		
		//String value = js.executeScript("return document.title").toString();
		//System.out.println(value);
		
		//js.executeScript("document.getElementById('email').value='ravilella'");
		
    	// String val = js.executeScript("return document.title").toString();
		
		//String val = js.executeScript("return document.title").toString();
		
		//System.out.println(val);
		
		
		
		//js.executeScript("document.getElementById('email').value='keerthan'");
		//js.executeScript("document.getElementById('loginbutton').click()");
				
		//String str = js.executeScript("return document.title").toString();
		//System.out.println(str);
		
		//js.executeScript("window.scrollBy(0,100)");
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//js.executeScript("document.getElementById('u_0_j').scrollIntoView()");
		
		js.executeScript("window.history.back()");
		
		Thread.sleep(4000);

		js.executeScript("window.history.forward()");
		
		Thread.sleep(4000);
		
		js.executeScript("window.history.go(0)");
		
		
	}

}
