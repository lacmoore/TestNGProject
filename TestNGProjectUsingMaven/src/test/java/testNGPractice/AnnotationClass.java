package testNGPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationClass {
  
	//Use Annotations to add details/information available to the test cases
	
//	@BeforeSuite
//	 └── @BeforeTest
//	      └── @BeforeClass
//	           ├── @BeforeMethod
//	           │    └── @Test
//	           │         └── @AfterMethod
//	           ├── @BeforeMethod
//	           │    └── @Test
//	           │         └── @AfterMethod
//	           └── @AfterClass
//	      └── @AfterTest
//	└── @AfterSuite

	
//Test Case 1
	@Test
	public void test1() {
	System.out.println("Test Case 1");
	}// Test Case 2
	@Test
	public void test2() {
	System.out.println("Test Case 2");
	}
	@BeforeMethod //	Runs before every @Test method.
	public void beforeMethod() {
	System.out.println("Before Method");
	}
	@AfterMethod //	Runs after every @Test method.
	public void afterMethod() {
	System.out.println("After Method");
	}
	@BeforeClass  //Runs once before the first method in the current class is invoked.
	public void beforeClass() {  
	System.out.println("Before Class");
	}
	@AfterClass  //	Runs once after all methods in the current class have been executed.
	public void afterClass() {
	System.out.println("After Class");
	}
	@BeforeTest  //Runs before each <test> tag in testng.xml.
	public void beforeTest() {
	System.out.println("Before Test");
	}
	@AfterTest //	Runs after each <test> tag in testng.xml.
	public void afterTest() {  //AfterTest is run after each test
	System.out.println("After Test");
	}
	@BeforeSuite  //BeforeSuite Runs once before all tests in the suite (across classes & tests).
	public void beforeSuite() {
	System.out.println("Before Suite");
	}
	@AfterSuite  	//Runs once after all tests in the suite have completed.
	public void afterSuite() {
	System.out.println("After Suite");
	}

}
