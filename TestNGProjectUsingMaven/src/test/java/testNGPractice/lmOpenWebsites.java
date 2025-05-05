package testNGPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class lmOpenWebsites {
  @Test
  public void openAmazon() throws InterruptedException {
		// 1. setup the property of chromedriver to open amazon page through chrome web browser.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LaChandaMoore\\eclipse-workspace\\Selenium_Programs\\Drivers\\chromedriver.exe" );
		// 2. Initialize Webdriver object through ChromeDriver class. 
	        ChromeDriver browserObject = new ChromeDriver();
		// 3. Open the http://www.amazon.com/ link using get method.
	        browserObject.get("http://www.amazon.com/");
	        Thread.sleep(1000);
	    	browserObject.close();
}

@Test
public void openGoogle() throws InterruptedException {
	// 1. setup the property of chromedriver to open amazon page through chrome web browser.
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\LaChandaMoore\\eclipse-workspace\\Selenium_Programs\\Drivers\\chromedriver.exe" );
	// 2. Initialize Webdriver object through ChromeDriver class. 
      ChromeDriver browserObject = new ChromeDriver();
	// 3. Open the http://www.google.com/ link using get method.
      browserObject.get("http://www.google.com/");
      Thread.sleep(1000);
  	browserObject.close();
}

@Test
public void openTwitter() throws InterruptedException {
	// 1. setup the property of chromedriver to open amazon page through chrome web browser.
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\LaChandaMoore\\eclipse-workspace\\Selenium_Programs\\Drivers\\chromedriver.exe" );
	// 2. Initialize Webdriver object through ChromeDriver class. 
      ChromeDriver browserObject = new ChromeDriver();
	// 3. Open the http://www.x.com/ link using get method.
      browserObject.get("http://www.x.com/");
      Thread.sleep(1000);
  	browserObject.close();
}
}
