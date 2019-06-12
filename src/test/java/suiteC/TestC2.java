package suiteC;

import org.testng.annotations.Test;

public class TestC2 
{
  
	@Test
	public void testC2() throws InterruptedException 
	{
		System.out.println("Starting C2");
		
		Thread.sleep(5000);
		System.out.println("Ending C2");
	}
}
