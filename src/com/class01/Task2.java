package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
	@BeforeTest
	public void beforeTest() {
		System.out.println("1.");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("7.");
	}
	
	@BeforeClass
	public void beforeClass(){
		System.out.println("2.");
		}
	@AfterClass
	public void afterClass(){
		System.out.println("6.");
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("3.");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("5.");
	}
	@Test
	public void test() {
		System.out.println("4.");
	}
}
