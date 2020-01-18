package com.class01;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods{
	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate(){
		setUp("chrome", Constants.HRMS_URL);
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test(groups = "regression")
	public void validLogin() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@id='branding']/a/img[1]")).isDisplayed();
		if(isDisplayed) 
		{System.out.println("Test pass");
		}else {
			System.out.println("Test fails");
		}
}
	@Test
	public void emptyPassword(){
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//span[text()='Password cannot be empty']")).isDisplayed();
		if(isDisplayed) 
		{System.out.println("Test pass");
		}else {
			System.out.println("Test fails");
		}
	}
	
	
	
}	
