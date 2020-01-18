package com.class03;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.utils.CommonMethods;
import com.utils.Constants;

public class HwAdd5Employee extends CommonMethods{
	
	@BeforeClass(alwaysRun = true)
	public void Open() {
		setUp("Chrome", Constants.HRMS_URL);
	}
	@BeforeMethod(alwaysRun = true)
	public void open()  {
		driver.navigate().refresh();
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		explicitWait("PIM");
		driver.findElement(By.linkText("PIM")).click();
		explicitWait("Add Employee");
		driver.findElement(By.linkText("Add Employee")).click();
	}
	@AfterMethod(alwaysRun = true)
	public void logOut() {
		driver.findElement(By.id("welcome")).click();
		explicitWait("Logout");
		driver.findElement(By.linkText("Logout")).click();
	}
	@Test(dataProvider = "getInfo", groups = "regression") 
	public void addEmployee(String firstName,String lastName ) throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(firstName+lastName);
		driver.findElement(By.id("user_password")).sendKeys(firstName.substring(3)+firstName+"@"+lastName.substring(2)+"123");
		driver.findElement(By.id("re_password")).sendKeys(firstName.substring(3)+firstName+"@"+lastName.substring(2)+"123");
		driver.findElement(By.id("btnSave")).click();
		screenShot("C:/Users/salamon/eclipse-workspace/TestNGBasic/screenShot/"+firstName+".png");
		String exceptedNF=(firstName+" "+lastName);
		String actualNF=driver.findElement(By.id("profile-pic")).getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualNF, exceptedNF, "Employee is not added");
		softAssert.assertAll();
	}
	@DataProvider
   public Object[][] getInfo(){
	Object [][] employee= {
			{"Ahmet","Mehmet"},
			{"Aslan","Kaplan"},
			{"Ayse","Fatma"},
			{"Hasan","Huseyin"},
			{"Oldu","Bitti"}
	};
	return employee;
}
@AfterClass(alwaysRun = true)
public void tearDown(){
	driver.quit();
}
	}
