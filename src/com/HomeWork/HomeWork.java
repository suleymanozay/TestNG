package com.HomeWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utils.CommonMethods;

public class HomeWork extends CommonMethods{
	
	Properties prop;
	@BeforeMethod
	public void setUp() {
		setUp("Chrome", "https://opensource-demo.orangehrmlive.com/");
		
	}
	
	@Test
	public void login()  {
		String filePath=System.getProperty("user.dir")+"/src/com/HomeWork/OpenSourceDemoLogin.properties";
		
		try{
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties(); 
			prop.load(fis);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String uid=prop.getProperty("Username");
		String pwd=prop.getProperty("Password");
		
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input[name='Submit']")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed(), "Login is failed");
	
	}
	@AfterMethod 
	public void tearDown(){
		driver.quit();
	}

}