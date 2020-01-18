package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;


public class AssertionDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate(){
		setUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test
	public void titleValidation() {
		String expectedTitle="Human Management System";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are matched");
		}
	@Test
	public void  logoValidation() {
		boolean isDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax Logo is displayed");
//		if(isDisplayed) 
//		{System.out.println("Test pass");
//		}else {
//			System.out.println("Test fails");
//		}
			
		}
	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
		if(isDisplayed) 
		{System.out.println("Test pass");
		}else {
			System.out.println("Test fails");
		}
		
	}
	}

