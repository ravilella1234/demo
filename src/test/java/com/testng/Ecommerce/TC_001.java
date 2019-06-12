package com.testng.Ecommerce;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TC_001 extends BaseTest
{
	
 
  @BeforeMethod(groups= {"regression"})
  @Parameters("browser")
  public void startProcess(String browserType) throws Exception 
  {
	  init();
	  launch(browserType);
	  navigate("amazonurl");
  }
  
  
  @Test(groups= {"regression"})
  public void amazon()
  {
	  test=e.startTest("TC_001");
		
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		selectItem("amazondropdown_id",10);
		test.log(LogStatus.INFO, "Selected the indexed item 10 by using locator :- " + or.getProperty("amazondropdown_id"));
		
		//Assert.fail();
		
		
		type("amazonsearchtext_id","harry Potter");
		test.log(LogStatus.INFO, "Entered the text - harry Potter by using locator :- " + or.getProperty("amazonsearchtext_id"));
		
		click("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Search Button by using locator :- " + or.getProperty("amazonsearchbutton_xpath"));
	  
  }

  
  @AfterMethod(groups= {"regression"})
  public void endProcess() 
  {
	  e.endTest(test);
	  e.flush();
	  
	  closeBrowser();
  }

}
