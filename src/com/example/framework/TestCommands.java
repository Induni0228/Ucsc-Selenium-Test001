package com.example.framework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TestCommands {

	//WebDriver driver = null;
	
	//initiate the webdriver and xpath. Here the click command is what we develop the method
	public void click(WebDriver driver, By locator) {
		
		//xpath needs to be added as a variable since it changes from page to page
		//WebElement element = driver.findElement(By.xpath(locator));
		WebElement element = FindElementLocator(driver, locator);//getting the method created for find element. Need to change the String locator to By locator
		element.click(); //click command coming from selenium
		logReport("Clicked on element:" + locator);
	}
	
	private void logReport(String logMessage) {
		Reporter.log("<p>"+logMessage +"</p>");
		
	}
	
	public void type(WebDriver driver, By locator, String text) {
		//WebElement element = driver.findElement(By.xpath(locator));
		WebElement element = FindElementLocator(driver,locator);
		element.clear();//clear all added text to field
		element.sendKeys(text);
		logReport("Typed text:" + text+"on element:"+locator);
	}
	
	//public void SelectByVisibleText(WebDriver driver, String locator) {}
	
	public void open(WebDriver driver, String url) {
		driver.get(url);
		logReport("The Url opened:"+ url );
	}
	
	public void assertText(WebDriver driver, By locator, String expected) {
		//WebElement element = driver.findElement(By.xpath(locator));
		WebElement element = FindElementLocator(driver, locator);
		String actual  =  element.getText();
		assertEquals(actual,expected);
		logReport("The expected value : "+expected+"on the element : "+locator);
				
	}
	
	private int getTimeOut() {
		PropertyFileReader propReader = new PropertyFileReader("config.pro");
		String propValue = propReader.getPropertyValue("");
	}
	
	public WebElement FindElementLocator(WebDriver driver, By locator){
		
		int timeout = getTimeOut();
				
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return ele;
		}
		catch(Exception e) {
			System.err.println("*************************************");
			System.err.println("could not find element"+e.getMessage());
			throw e;
		}
		
	}
	
}
	
