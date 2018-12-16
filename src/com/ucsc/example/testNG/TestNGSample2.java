package com.ucsc.example.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGSample2 {
  @Test
  public void f1() throws InterruptedException {
	  System.out.println("This is @Test f1() - 1");
	  Thread.sleep(1000);
  }
  @Test
  public void f2() throws InterruptedException {
	  System.out.println("This is @Test f2() - 2");
	  Thread.sleep(1000);
  }
  @Test
  public void f3() throws InterruptedException {
	  System.out.println("This is @Test f3() - 3");
	  Thread.sleep(1000);
  }
  @Test
  public void f4() throws InterruptedException {
	  System.out.println("This is @Test f4() - 4");
	  Thread.sleep(1000);
  }
  @Test
  public void f5() throws InterruptedException {
	  System.out.println("This is @Test f5() - 5");
	  Thread.sleep(1000);
  }
  @Test
  public void f6() throws InterruptedException {
	  System.out.println("This is @Test f6() - 6");
	  Thread.sleep(1000);
  }
  @Test
  public void f7() throws InterruptedException {
	  System.out.println("This is @Test f7() - 7");
	  Thread.sleep(1000);
  }
  @Test
  public void f8() throws InterruptedException{
	  System.out.println("This is @Test f8() - 8");
	  Thread.sleep(1000);
  }
  @Test
  public void f9() throws InterruptedException{
	  System.out.println("This is @Test f9() - 9");
	  Thread.sleep(1000);
  }
  @Test
  public void f10() throws InterruptedException {
	  System.out.println("This is @Test f10() - 10");
	  Thread.sleep(1000);
  }

}
