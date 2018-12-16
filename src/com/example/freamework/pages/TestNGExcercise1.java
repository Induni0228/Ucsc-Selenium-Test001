package com.example.freamework.pages;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

@Test
public class TestNGExcercise1{

	  private WebDriver driver;
	  //private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @DataProvider
	  public Object[][]dt_test001(){
		  return new Object[][] {
			  new Object[] {"5","200","10"},
			  new Object[] {"5","200","10"},
	  };
	  }
 
	  public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\csc18\\Desktop\\Induni\\DayTwoExcercise\\lib\\chromedriver.exe");
		    driver = new ChromeDriver();
		    //baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	  
  @Test(dataProvider="dt_test001")
	
	  public void TestNGExcercise1(String input1, String input2, String expected) throws Exception {
		    driver.get("https://www.calculator.net/"); 
		    CalculatorHomePage home = new CalculatorHomePage();
		    home.navigateToPercCalcPage(driver);
		    home.calculatePercentage(driver, "5", "300");
		    home.verfyPercentage(driver, expected);
		  }

	  @AfterMethod
  
	  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		 /* private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }*/
  }
