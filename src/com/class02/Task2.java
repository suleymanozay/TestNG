package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task2 extends CommonMethods{
	@BeforeMethod
	public void open() {
		setUp("Chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("PIM")).click();
		explicitWait("Add Employee");
		driver.findElement(By.linkText("Add Employee")).click();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test 
	public void verifyLabels() {
		boolean fullNAmeIs=driver.findElement(By.id("firstName")).isDisplayed();
		boolean empIDIs=driver.findElement(By.id("employeeId")).isDisplayed();
		boolean photoIs=driver.findElement(By.id("photofile")).isDisplayed();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(fullNAmeIs, "Full Name is Not Display");
		softAssert.assertTrue(empIDIs, "Employee Id is Not Display");
		softAssert.assertTrue(photoIs, "Photograph  is Not Display");
		
		driver.findElement(By.id("firstName")).sendKeys("aaaaaa");
		driver.findElement(By.id("lastName")).sendKeys("aaaaaaaaa");
		driver.findElement(By.id("photofile")).sendKeys("C:/Users/salamon/Desktop/a.jpg");
		String iD = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		String actulaID=driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		System.out.println(driver.findElement(By.id("profile-pic")).getText());
		Assert.assertEquals(actulaID, iD, "Employee is not added");
		softAssert.assertAll();
	
		
	}
	

	
}
