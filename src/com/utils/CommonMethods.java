package com.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonMethods {
	public static WebDriver driver;

	
	public static void setUp(String browser, String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else {
			System.err.println("Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	
	}
	/**
	 * This method will accept the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
			} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	/**
	 * This method will dismiss the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	/**
	 * This method will get a text from the alert
	 * @return tet of the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
			} 
		catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
		}
	/**
	 * This method with switch to the frame
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId){
		try {
			driver.switchTo().frame(nameOrId);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method with switch to the frame
	 * @param element
	 */
	public static void switchToFrame(WebElement element){
		try {
			driver.switchTo().frame(element);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method with switch to the frame
	 * @param index
	 */
	public static void switchToFrame(int index){
		try {
			driver.switchTo().frame(index);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method will click on the element usig JSExecutor
	 * @param element
	 */
	public static  void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", element);
	}
	/**
	 * This method will scroll until specified element
	 * @param element
	 */
	public static  void scrollIntoElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	/**
	 * This method will scroll page down
	 * @param pixel
	 */
	public static  void scrollDown(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	/**
	 * This method will scroll page up
	 * @param pixel
	 */
	public static  void scrollUP(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	/**
	 * This Method is specific element to appear on the 
	 * it will wait until expected
	 * @param String locator (locator of linkText)
	 * @return
	 */
	public static  WebElement explicitWait (String locator) {
		By element=By.linkText(locator);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement visibilElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element)); 
		return visibilElement;
	}
	/**
	 * This Method will take a screen shot
	 * @param  file name
	 * @return
	 * @throws InterruptedException 
	 */
	public static File screenShot(String fileName) throws InterruptedException {
		Thread.sleep(1500);
		TakesScreenshot ts=(TakesScreenshot)driver;		
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			 FileUtils.copyFile(screen, new File("screenShot/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Can not take screenshot");
			e.printStackTrace();
			return null;
		}
		return screen;
	}
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
	public static void takeScreenshot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenShot/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
	}
	/**
	 * This method will Capture screenshot of an alert 
	 * @param path
	 * @return
	 * @throws HeadlessException
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static BufferedImage alertScreenShot(String path) throws HeadlessException, AWTException, IOException, InterruptedException {
		Thread.sleep(1000);
		BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    ImageIO.write(image, "jpg", new File(path));
	    return image;

	}

}
