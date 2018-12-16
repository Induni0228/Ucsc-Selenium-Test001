package com.testing.exercise;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class TestNGExcercise2 {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @DataProvider
	  public Object[][]dt_test002(){
		  return new Object[][] {
			  new Object[] {"London","New York","December","Arrival"},
			  new Object[] {"New York","London","November","Departure"},
		  };
	  }
  @Parameters({"browser"})
  @BeforeMethod()
  //public void setUp() {
	 public void setUp(String browser) throws Exception {
	  if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\csc18\\Desktop\\Induni\\DayTwoExcercise\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
	  else {
		  System.out.println("It is not a valid browser");
	  }
  }
  
  @Test(dataProvider="dt_test002")
  //public void TestNGExcercise() {
	  public void TestNGExcercise2(String input1,String input2, String input3, String expected) throws Exception {
		    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		    driver.findElement(By.name("userName")).click();
		    driver.findElement(By.name("userName")).clear();
		    driver.findElement(By.name("userName")).sendKeys("Induni");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("induni@123");
		    driver.findElement(By.name("login")).click();
		    driver.findElement(By.name("fromPort")).click();
		    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText(input1);
		    driver.findElement(By.name("fromPort")).click();
		    driver.findElement(By.name("toPort")).click();
		    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText(input2);
		    driver.findElement(By.name("toPort")).click();
		    driver.findElement(By.name("toMonth")).click();
		    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText(input3);
		    driver.findElement(By.name("toMonth")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
		    driver.findElement(By.name("airline")).click();
		    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
		    driver.findElement(By.name("airline")).click();
		    driver.findElement(By.name("findFlights")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::font[1]")).click();
		    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::font[1]")).getText(), expected);
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

