package testNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class lmBookDemo_Dependencies {
	
	ChromeDriver browserObject;
	
  @Test
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");  //Set system property to use chrome webdriver and provide its location
	    browserObject = new ChromeDriver();  //Create a ChromeDriver Object to control the browser
	    browserObject.get("https://demo.itlearn360555555.com/");  //Open the specified web page
	}
	
	
	@Test (dependsOnMethods = "setUp")
	public void verify() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) browserObject;  //Treat the browserObject as a JavascriptExecutor so we can run JavaScript using Type Cast
	    js.executeScript("window.scrollBy(0,500)");  //scroll the browser window down
	    
	    Thread.sleep(3000);
	    
	    WebElement bookDemoBtn = browserObject.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/section/ul/li[2]/ul/li[4]/a"));  //Get the BookDemo Button
	    bookDemoBtn.click();  //Click the button
	    
	    Thread.sleep(3000);
	    
	   //On the Contact Page
	    WebElement nameLabel = browserObject.findElement(By.xpath("//*[@id=\"nf-label-field-24\"]"));  //Find the Name Label
	    js.executeScript("arguments[0].scrollIntoView(true);", nameLabel);  //scroll the browser to the Name Input Field

		// Initialize WebDriverWait with a timeout of 10 seconds
	    WebDriverWait wait = new WebDriverWait(browserObject, Duration.ofSeconds(10));

	    // Find the element which may not be initially interactable
	    WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("nf-field-24-textbox")));
	    
	  //  WebElement nameField = browserObject.findElement(By.name("nf-field-24-textbox"));  //Get the name input
	    WebElement emailField = browserObject.findElement(By.name("email")); //Get the email input
	    WebElement phoneField = browserObject.findElement(By.name("phone")); //Get the phone input 
	    WebElement messageField = browserObject.findElement(By.name("nf-field-26"));  //Get the message input 
	    //WebElement submitBtn = browserObject.findElement(By.id("nf-field-27"));  //Get the submit button
	    
	    //Fill in the form
	    nameField.sendKeys("Jane Doe");
	    emailField.sendKeys("janedoe@email.com");
	    phoneField.sendKeys("1-888-563-5846");
	    messageField.sendKeys("This is a message for you");
	    
	    Thread.sleep(3000);
	    
	 // Find the element which may not be initially interactable
	    WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nf-field-27")));
	    js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);  //scroll the browser to the Submit Button
	    

	    Thread.sleep(3000);
	   
	    //Submit the form
	    submitBtn.click();
	}
  
  
  @Test (dependsOnMethods="verify")
  public void logoutProcess() {
  	 browserObject.close();
  }
  
}
