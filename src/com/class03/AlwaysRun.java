package com.class03;


import org.testng.annotations.Test;
import org.testng.annotations.*;

public class AlwaysRun {
	
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("I am before suite");
		}
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("I am before test");
		}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("I am before method");
		
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("I am after method");
		
	}
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("I am after test");
		}
	@AfterClass (alwaysRun = true)
	public void AfterClass() {
		System.out.println("I am after class");
	}
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("I am after suite");
		}

	@Test
	public void testMethod() {
		System.out.println("I am test");
	}
	@Test
	public void testMethod1() {
		System.out.println("I am test1");
	}
	
}
