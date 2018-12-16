package com.ucsc.example.xpath;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test003 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  /*
	   * System.setProperty("webdriver.chrome.driver", "C:\\Users\\csc18\\Desktop\\MyProjects\\Batch10\\libs\\chromedriver.exe");
	driver = new ChromeDriver();C:\Users\csc18\Desktop\Induni\DayTwoExcercise\lib
	   */
    driver = new ChromeDriver();
    System.setProperty("webdriver.chrome.driver","C:\\Users\\csc18\\Desktop\\Induni\\DayTwoExcercise\\lib\\chromedriver.exe");
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test003() throws Exception {
    driver.get("http://newtours.demoaut.com/");
    driver.findElement(By.name("userName")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("Induni0228");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("induni0228");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.name("fromPort")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.name("toPort")).click();
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
    driver.findElement(By.name("toPort")).click();
    driver.findElement(By.name("findFlights")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::font[1]")).getText(), "London to New York");
  }

  @AfterClass(alwaysRun = true)
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
