package testNGPractice;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class lmDataProviders {
	
	ChromeDriver browserObject;  //create a chromedriver object called browserObject
	 WebDriverWait wait; //create a WebDriverWait Object called wait
	 
  @Test(priority = 1, dataProvider = "dp")  //data provider will provide data to the method
  public void verify(String user, String pword) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");  //Set system property to use chrome webdriver and provide its location
	    browserObject = new ChromeDriver();  //Create a ChromeDriver Object to control the browser
	    browserObject.get("https://demo.itlearn360.com/");  //Open the specified web page
	    browserObject.manage().window().maximize();  //maximize the browser window
	    
	    Thread.sleep(3000);
		  
		  WebElement loginBtn = browserObject.findElement(By.id("loginlabel")); //find the login button
		  loginBtn.click();  //click the button
		  
		wait =  new WebDriverWait(browserObject, Duration.ofSeconds(10));
		 WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login")));  //wait until the element is on the page then get it
		   	
		// Get reference of Password input box by locate the id method.
	     WebElement password=browserObject.findElement(By.id("user_pass"));
		
		// Provide/Enter the correct email to email input box through reference.
	     username.sendKeys(user);
		// Provide/Enter the correct password to password input box through reference.
	     password.sendKeys(pword);
		
	     // Get reference of login button by locate the classname method.
	     WebElement button=browserObject.findElement(By.id("wp-submit"));
	     
	     Thread.sleep(3000);
		// Submit the button.
	     button.click();
  }
  
  @Test(priority=2, dependsOnMethods="verify")  //will not run if verify fails
  public void logout() throws InterruptedException
  {
 	  Thread.sleep(3000);
 	  wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
 	  WebElement logoutImg = wait.until(ExpectedConditions.visibilityOfElementLocated(
 	      By.xpath("/html/body/div[1]/header/div/div/div[2]/div/nav[2]/ul/li[2]/a/i")));
 	  logoutImg.click();
 	  
 	  wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
 	  WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
 	      By.xpath("/html/body/div[1]/header/div/div/div[3]/div/ul/li[3]/a")));
 	  logoutBtn.click();
 	  
 	  
  }

  @DataProvider
  public Object[][] dp() {  //data provider will send multiple values for multiple test runs
    return new Object[][] {
      new Object[] { "Demo12", "Test123456$" },
      new Object[] { "Demoidid", "Test123456$kdkd" },
    };
  }
}
