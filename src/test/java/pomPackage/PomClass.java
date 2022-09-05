/*
 * In this class, Page Object model is created i.e. all the webelements to be used for the assignment will be stored here
 * along with their tentative usage in testing i.e. methods. 
 * Author: Gaurav Punj
 */

package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPackage.TestClass;

// class to extend TestClass which has the webDriver instance named driver.
public class PomClass extends TestClass {

	// hamburger menu is on homepage top left which opens the various sections
	@FindBy(id = "nav-hamburger-menu")
	public WebElement LeftPanelHamburgerMenu;

	// Kindle is one of the options from the sections opened under digital contents and devices
	@FindBy(xpath = "//div[contains(text(),'Kindle')]")
	public WebElement DigitalContentKindle;

	//Under Kindle E-Readers, there is a section named Kindle
	@FindBy(linkText = "Kindle")
	public WebElement KindleEReaderKindle;

	//Buy Now button on right panel for kindle webpage
	@FindBy(id = "buy-now-button")
	public WebElement BuyNowButton;

	//Once buy now button is clicked webpage should open with label for email address/mobile phone number
	@FindBy(xpath = "//label[contains(text(),'E-mail address or mobile phone number')]")
	public WebElement PutEmailMobileLabel;

	// input field for putting email or mobile number
	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement EmailInputField;

	//constructor with WebDriver parameter from TestClass.
	public PomClass(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Click event for the hamburgerMenu
	public void ClickLeftPanelHamburgerMenu() {
		LeftPanelHamburgerMenu.click();
	}

	//Click event for Kindle under digital contents and devices
	public void ClickDigitalContentKindle() {
		DigitalContentKindle.click();
	}

	//click event for kindle under Kindle E Readers
	public void ClickKindleEReaderKindle() {
		KindleEReaderKindle.click();
	}

	// Buy Now Button click
	public void ClickBuyNowButton() {
		BuyNowButton.click();
	}

	// Check Event for email or mobile number label
	public boolean CheckPutEmailMobileLabel() {
		return PutEmailMobileLabel.isDisplayed();
	}

	// Check Event for email or mobile number input field. 
	public boolean CheckEmailInputField() {
		return EmailInputField.isDisplayed();
	}

}
