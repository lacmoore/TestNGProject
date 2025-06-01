package testNGPractice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//////////////////////////This one is not working for me///////////////////////////
///
///
public class GroupLogin_Assertion {
	ChromeDriver browserObject;  //create browser object
	WebDriverWait wait;  //create webdriverwait object
	
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver.exe"); //Set system property to use chrome webdriver and provide its location
		browserObject = new ChromeDriver(); //set Object to control the browser
		browserObject.get("http://demo.itlearn360.com/"); //Open the specified web page
		wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));  //set wait object
		
	}
	
	@Test(priority=1,groups="login")  //Set the test priority and add it to the login group
	public void verify()
	{
		WebElement loginImage= browserObject.findElement(By.id("loginlabel"));  //find the login label
		loginImage.click();  //click the label
		
		wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));  //set wait object
		String username="Demo12";  //create username string and pass value
		String password ="Test123456$";  //create password string and pass value
		WebElement user= browserObject.findElement(By.name("log"));  //get the user login element
		wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));  //set wait object
		user.sendKeys(username);  //pass the username
		
		
		WebElement pass= browserObject.findElement(By.id("user_pass"));  //get the password element
		wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));  //set wait object
		pass.sendKeys(password);  //pass in the password
		
		if(username.equals("Demo1")&& password.equals("Test123456$"))  //check if username and password equal the correct values
		{
			Assert.assertTrue(true);  //assert  True = True
		}
		else
		{
			Assert.assertTrue(false);  //if not assert True = false;  Code will stop here test case will fail
		}
		
		
		WebElement sub= browserObject.findElement(By.name("wp-submit"));
		sub.click();
	}
	
	@Test(priority=2,groups="dash")
	public void checkdash()
	{
		String expectedValue="Dashboar";
		String actualValue = browserObject.findElement(By.xpath("//*[@id=\"login-list\"]/li[1]/a")).getText();
		
		Assert.assertEquals(actualValue,expectedValue );
	}
	
	@Test(priority=3)
	public void searchCourse()
	{
		browserObject.findElement(By.name("search_course")).sendKeys("Html for beginners");
		browserObject.findElement(By.xpath("//*[@id=\"primary_menu\"]/nav[1]/form/button"));
	}
}
