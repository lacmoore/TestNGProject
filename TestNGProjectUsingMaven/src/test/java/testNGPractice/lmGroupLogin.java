package testNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lmGroupLogin {
	ChromeDriver browserObject;
	 WebDriverWait wait;
	 
	@BeforeTest (groups="testLogin")
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");  //Set system property to use chrome webdriver and provide its location
	    browserObject = new ChromeDriver();  //Create a ChromeDriver Object to control the browser
	    browserObject.get("https://demo.itlearn360.com/");  //Open the specified web page
	    browserObject.manage().window().maximize();  //maximize the browser window
	  }
	
 @Test (groups="testLogin")
 public void verify() throws InterruptedException {
	  
	   Thread.sleep(3000);
	  
	  WebElement loginBtn = browserObject.findElement(By.id("loginlabel"));
	  loginBtn.click();
	  
	wait =  new WebDriverWait(browserObject, Duration.ofSeconds(10));
	 WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login")));
	   	
	// Get reference of Password input box by locate the id method.
     WebElement password=browserObject.findElement(By.id("user_pass"));
	
	// Provide/Enter the correct email to email input box through reference.
     username.sendKeys("Demo12");
	// Provide/Enter the correct password to password input box through reference.
     password.sendKeys("Test123456$");
	
     // Get reference of login button by locate the classname method.
     WebElement button=browserObject.findElement(By.id("wp-submit"));
     
     Thread.sleep(3000);
	// Submit the button.
     button.click();
 }
 
 @Test(priority= 1, dependsOnMethods="verify", groups="testLogin")
 public void searchDemos() throws InterruptedException
 {
	  Thread.sleep(3000);
	  wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
	  WebElement searchBar1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			  By.id("search_course")));
	  searchBar1.sendKeys("HTLM for Beginners");
	  
	  browserObject.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/nav[1]/form/button")).click();

	  Thread.sleep(3000);
	  
	  wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));
	  WebElement searchBar2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			  By.xpath("//*[@id=\"form1\"]")));
	  
	  Thread.sleep(3000);
	 
 }
 
 @Test(priority=2, dependsOnMethods="verify", groups="testLogin")
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

 @AfterTest (groups="testLogin")
 public void afterTest() {
	  
	  browserObject.close();  //close the browser
 }
}
