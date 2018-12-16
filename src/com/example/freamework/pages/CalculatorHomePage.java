package com.example.freamework.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.framework.TestCommands;

public class CalculatorHomePage extends TestCommands{

	private By mathCalculatorLink = By.linkText("Math Calculators");
	private By perCalculatorLink = By.linkText("Percentage Calculator");
	private By percentageTextField = By.id("cpar1");
	private By amountTextField = By.id("cpar2");
	private By calcPercentage = By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]");
	private By verifyPercentage = By.xpath(".//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::b[1]");
	
	
	public void navigateToPercCalcPage(WebDriver driver) {
		/*WebElement mathCalcEle = driver.findElement(mathCalculatorLink);
		mathCalcEle.click();
		WebElement perCalcEle = driver.findElement(perCalculatorLink);
		perCalcEle.click();*/
		
		//Instead of above code, we use created method for find element
		
		click(driver,mathCalculatorLink);
		click(driver,perCalculatorLink);
		
		//return new PercentageCalculatePage();
	}
	
	public void calculatePercentage(WebDriver driver, String percentage, String amount ) {
		/*WebElement percentageinput1 = driver.findElement(percentageTextField);
		WebElement percentageinput2 = driver.findElement(percentageTextField);
		WebElement button = driver.findElement(calcPercentage);
		
		percentageinput1.click();
		percentageinput1.clear();
		percentageinput1.sendKeys(percentage);
		
		
		
		percentageinput2.click();
		percentageinput2.clear();
		percentageinput2.sendKeys(amount);
	
		button.click();*/
		
		click(driver,percentageTextField);
		type(driver,percentageTextField,percentage);
		
		click(driver,amountTextField);
		type(driver,amountTextField,amount);
		
		click(driver,calcPercentage);
	}
	
	public void verfyPercentage(WebDriver driver, String expected) {
		/*WebElement verify = driver.findElement(verifyPercentage);
		assertEquals(verify.getText(),expected);*/
		
		assertText(driver,verifyPercentage,expected);
		
	}
}
