package testNGPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class lmPriority {
ChromeDriver browserObject;
	
	@Test(priority=0)
	public void firstTest(){
		Assert.fail();
	}
	
	@Test (priority = 1)
	public void secondTest() {
		Assert.assertTrue(true);
	}
	
	@Test (priority =2)
	public void thirdTest() {
		throw new SkipException("Skipping third test...");
	}
	
	
	@Test (priority = 3)
	public void fourtTest() {
		Assert.assertTrue(false);
	}
	
	@Test @Ignore 
	public void fifthTest() {
		throw new SkipException("Skipping fifth test...");
	}
}
