package com.testing.exercise;

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
public class TestNGExcercise1 {

	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @DataProvider
	  public Object[][]dt_test001(){
		  return new Object[][] {
			  new Object[] {"5","200","10"},
			  new Object[] {"5","200","10"},
	  };
	  }
	  
	  @Parameters({"browser"})
	  @BeforeMethod()
  //public void beforeMethod(String browser) {
	  public void setUp(String browser) throws Exception {
		  if(browser.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\csc18\\Desktop\\Induni\\DayTwoExcercise\\lib\\chromedriver.exe");
		    driver = new ChromeDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  else {System.out.println("It is not a valida browser");
		  }
	  }
  @Test(dataProvider="dt_test001")
	  //public void f(String input1, String input2, String expected) {
	  public void TestNGExcercise1(String input1, String input2, String expected) throws Exception {
		    driver.get("https://www.calculator.net/");
		    driver.findElement(By.linkText("Math Calculators")).click();
		    driver.findElement(By.linkText("Percentage Calculator")).click();
		    driver.findElement(By.id("cpar1")).click();
		    driver.findElement(By.id("cpar1")).clear();
		    driver.findElement(By.id("cpar1")).sendKeys(input1);
		    driver.findElement(By.id("cpar2")).click();
		    driver.findElement(By.id("cpar2")).clear();
		    driver.findElement(By.id("cpar2")).sendKeys(input2);
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]")).click();
		    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::b[1]")).getText(), expected);
		  }

	  @AfterMethod
  //public void afterMethod() {
	  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		  private boolean isElementPresent(By by) {
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
		  }
  }
