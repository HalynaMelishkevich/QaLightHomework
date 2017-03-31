package automation.melishkevich;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationPage extends Page {
	By buttonFotApplicationXpath = By.xpath("//div[@class='fot-application-logo']");
	By buttonFptApplicationXpath = By.xpath("//div[@class='fpt-application-logo']");
	By buttonGmbApplicationXpath = By.xpath("//div[@class='gmb-application-logo']");
	By buttonMipApplicationXpath = By.xpath("//div[@class='mip-application-logo']");
	By buttonPmsApplicationXpath = By.xpath("//div[@class='pms-application-logo']");
	By buttonTenApplicationXpath = By.xpath("//div[@class='ten-application-logo']");
	By buttonTmsApplicationXpath = By.xpath("//div[@class='tms-application-logo']");
	By textUserNameXpath = By.xpath(".//*[@id='topNav']//strong");
	By buttonLogoffXpath = By.xpath("//a[@href='/Account/LogOff']");

	public ApplicationPage(WebDriver driver) {
		super(driver);
		UrlBuilder mipUrl = new UrlBuilder();
		url = mipUrl.builStsUrl();
		log = LogManager.getLogger(getClass());
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickLogOff() {
		return clickButton(buttonLogoffXpath);
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName) {
		return isElementTextEquals(textUserNameXpath, userName);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnFotApplicationIcon() {
		return clickButton(buttonFotApplicationXpath);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnFptApplicationIcon() {
		return clickButton(buttonFptApplicationXpath);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnGmbApplicationIcon() {
		return clickButton(buttonGmbApplicationXpath);
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public boolean clickOnMipApplicationIcon() throws InterruptedException {
		//Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(buttonMipApplicationXpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.onload = function(){$('.mip-application-logo').click()}");
		
		return clickButton(buttonMipApplicationXpath);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnPmsApplicationIcon() {
		return clickButton(buttonPmsApplicationXpath);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnTenApplicationIcon() {
		return clickButton(buttonTenApplicationXpath);
	}

	/**
	 * 
	 * @return
	 */
	public boolean clickOnTmsApplicationIcon() {
		return clickButton(buttonTmsApplicationXpath);
	}

	public boolean checkRedirectedMipUrl() {
		WebDriverWait wait = new WebDriverWait(driver,15); //15 - timeout time in seconds
		wait.until(ExpectedConditions.textToBePresentInElementLocated(buttonMipApplicationXpath,"MIP"));
		UrlBuilder url = new UrlBuilder();
		return isUrlEqualTo(url.builMipUrl() + "Home");
	}
	
	public boolean checkRedirectedStsUrl() {
		//UrlBuilder url = new UrlBuilder();
		return isUrlEqualTo(urlBuilder.builStsUrl() + "Account/LogOn");
	}
}
