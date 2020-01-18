package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * Open app
 * verify logo is displayed
 * enter valid credentials
 * verify user successfully logged in
 */

public class SoftAssertionDemo extends CommonMethods{
	@BeforeMethod
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		//Hard Assert will fail and execution will stop at taht point
		//Assert.assertTrue(logoDisplayed, "Logo is Not displayed");
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is Not displayed");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean welcomeIsDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
		//Assert.assertTrue(welcomeIsDisplayed);
		softAssert.assertTrue(welcomeIsDisplayed, "Welcome element is displayed");
		softAssert.assertAll();
	}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
