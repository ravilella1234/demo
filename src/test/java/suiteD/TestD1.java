package suiteD;

import org.testng.annotations.Test;

public class TestD1 
{
  
	@Test
	public void testD1() throws InterruptedException 
	{
		System.out.println("Starting D1");
		
		Thread.sleep(5000);
		System.out.println("Ending D1");
	}
}
