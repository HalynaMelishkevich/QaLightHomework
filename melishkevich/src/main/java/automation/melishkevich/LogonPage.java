package automation.melishkevich;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogonPage extends Page {
	By inputEmailFieldId = By.id("Email");
	By inputPasswordFieldId = By.id("Password");
	By buttonSubmitLogonId = By.id("submitBtn");
	By qa_buttonConfirmLogonId = By.id("popup_ok");
	By buttonForgotPasswordXpath = By.xpath("//a[@href='/Account/ForgotPassword']");
	By textLogonValidationFailXpath = By.xpath("//div[@class='validation-summary-errors nNote nFailure hideit']");
	By textUserNameXpath = By.xpath(".//*[@id='topNav']//strong");

	public LogonPage(WebDriver driver) {
		super(driver);
		UrlBuilder mipUrl = new UrlBuilder();
		url = mipUrl.builStsUrl() + "Account/LogOn";
		log = LogManager.getLogger(getClass());
	}

	/**
	 * 
	 * @return
	 */
	public boolean openPageLogon() {
		try {
			LogonPage logonPage = new LogonPage(driver);
			openUrl(logonPage.url);
			log.info("Page Logon was opened ");
			return true;
		} catch (Exception e) {
			log.error("Error: catch " + e);
			return false;
		}

	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean inputEmail(String email) {
		return inputTextIntoField(inputEmailFieldId, email);
	}

	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean inputPassword(String password) {
		return inputTextIntoField(inputPasswordFieldId, password);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickLogon() {
		return clickButton(buttonSubmitLogonId);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickConfirmLogonQA() {
		return clickButton(qa_buttonConfirmLogonId);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickForgotPassword() {
		return clickButton(buttonForgotPasswordXpath);
	}

	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean checkValidationTest() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15); // 15 - timeout
																// time in
																// seconds
			wait.until(ExpectedConditions.textToBePresentInElementLocated(textLogonValidationFailXpath,
					"Login was unsuccessful. Please correct the errors and try again."));
			return true;
		} catch (Exception e) {
			log.error("Validation text is not present on page.");
			return false;
		}
		// return isElementPresentOnPage(textLogonValidationFailXpath);
	}

	public boolean checkUserName(String userName) {
		try {
			wait.until(ExpectedConditions.textToBe(textUserNameXpath, userName));
			log.info("User name is correct.");
			return true;
		} catch (Exception ex) {
			log.error("User name is incorrect.");
			return false;
		}
	}

	public void closeLogonPage() {
		closeBrowser();
	}

}
