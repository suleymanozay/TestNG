package com.class01;

public class important {
//	/*
//	/*
//	 * // The following is the TestNG annotation sequence execution
//	/*
//	 * Pre-condition annotations
//	 * 
//	 * @BeforeSuite
//	 * @BeforeTest
//	 * 
//	 * @BeforeClass
//	 * 
//	 * @BeforeMethod
//	 * 
//	 * @Test 
//	 * 
//	 * Post-condition annotations
//	 * 
//	 * @AfterMethod
//	 * 
//	 * @AfterClass
//	 * 
//	 * @AfterTest
//	 * 
//	 * @AfterSuite
//	 */
//	WebDriver driver;
//	@BeforeSuite
//	public void beforeSuite() {
//		System.out.println("@BeforeSuite----- will execute before any other annotated method");
//	}
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("@BeforeTest----- executes after @BeforeSuite and before @BeforeClass");
//	}
//	@BeforeClass
//	public void beforeClass() {
//		System.out.println("@BeforeClass----- executes after @BeforeTest and before @BeforeMethod");
//	}
//	@BeforeMethod
//	// @BeforeMethod executes before @Test
//	public void beforeMethodSetUp() {
//		System.out.println("@BeforeMethod----- executes before @Test and after @BeforeClass");
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Blood of my blood\\eclipse-workspace\\TestNGFramework\\src\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.google.com/");
//	}
//	@Test
//	public void test() {
//		System.out.println("@Test----- this is your actual Test Case and will execute after @BeforeMethod and before @AfterMethod");
//		String title = driver.getTitle();
//		System.out.println(title);
//	}
//	@AfterMethod
//	// @AfterMethod executed after @Test
//	public void afterMethodTearDown() {
//		System.out.println("@AfterMethod----- executes after @Test and before @AfterClass");
//		driver.quit();
//	}
//	@AfterClass
//	public void afterClass() {
//		System.out.println("@AfterClass----- executes after @AfterMethod and before @AfterTest");
//	}
//	@AfterTest
//	public void afterTest() {
//		System.out.println("@AfterTest----- executes after @AfterClass and before @AfterSuite");
//	}
//	@AfterSuite
//	public void afterSuite() {
//		System.out.println("@AfterSuite-----");
//	 */
//
}