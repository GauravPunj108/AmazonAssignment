/*
 * This is the Test class which has the methods to be executed to run the test cases.
 * TestNG annotations are used for this class
 * Author: Gaurav Punj
 */

package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pomPackage.PomClass;

public class TestClass {

	public static WebDriver driver = null;
	PomClass pom;

// BeforeTest annotation for driver set up depending on browsername parameter coming from TestSuite 
	@Parameters("browsername")
	@BeforeTest
	public void driverSetup(String browsername) throws Exception {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		} else {
			throw new Exception("Incorrect Browser Name");
		}
	}

// BeforeMethod annotation for url opening depending on browser selected from TestSuite. This method will be called before
// each @Test Annotation events.
	@Parameters("browsername")
	@BeforeMethod
	public void openUrl(String browsername) throws Exception {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Incorrect Browser Name");
		}

		try {
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.amazon.ca/");
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pom = new PomClass(driver);

	}

	/*
	 * Test steps-
	 * Go to amazon.ca
	 * Click on hamburger menu (top left corner) 
	 * Select Kindle under Digital Content and Devices 
	 * Click Kindle under Kindle E-Reader 
	 * Click Buy Now 
	 * Verify User is asked for email or mobile number 
	 */
	@Test(enabled = true, groups = { "Smoke" })
	public void checkKindlePage() throws InterruptedException {

		try {
			pom.ClickLeftPanelHamburgerMenu();
			Thread.sleep(5000);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pom.ClickDigitalContentKindle();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pom.ClickKindleEReaderKindle();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pom.ClickBuyNowButton();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		boolean m = pom.CheckPutEmailMobileLabel() & pom.CheckEmailInputField();
		System.out.println(m);
		Assert.assertEquals(m, true);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
