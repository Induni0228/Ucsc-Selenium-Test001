package com.ucsc.example.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGSample3 {
	
	//using browser parameter
	@Parameters({"browser","testparam"})
	
  @BeforeMethod
  public void beforeMethod(String browser, String name) {
	  System.out.println("My browser is"+browser+"My name is"+name);
  }
  @Test()
  public void thirdMethod() {
	  System.out.println("This is @Test thirdMethod()");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is @AfterMethod");
  }

}
