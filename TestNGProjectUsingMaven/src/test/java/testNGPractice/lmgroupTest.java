package testNGPractice;

import org.testng.annotations.Test;

public class lmgroupTest {
  
  @Test (groups="login")
  public void opeWebsite() {
	  System.out.println("openWebsite");
  }
  
  @Test (groups="login")
  public void enterData() {
	  System.out.println("enterData");
  }
  
  @Test (groups="login")
  public void pressLogin() {
	  System.out.println("pressLogin");
  }
  
  @Test (groups="explore")
  public void explorePage() {
	  System.out.println("explorePage");
  }
  
}
