package suiteC;

import org.testng.annotations.Test;

public class TestC1 
{
  
	@Test
	public void testC1() throws InterruptedException 
	{
		System.out.println("Starting C1");
		
		Thread.sleep(5000);
		System.out.println("Ending C1");
	}
}
