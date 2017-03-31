package automation.melishkevich;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test2 {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/halka/Downloads/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(capabilities);
	}
	/* In this test:
	 * 1. Opens STS page
	 * 2. Input valid credentials and Submit
	 * 3. Check that user is redirected to Application page
	 * 4. Checks user's Name and Surname
	 * 5. Click on MIP
	 * 6. Check that user is redirected to MIP Home page
	 * 7. Step-by-step open tools and check redirections
	 * */
	@Test
	public void test2() throws InterruptedException, IOException {
		LogonPage logonPage = new LogonPage(driver);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Assert.assertTrue((logonPage.openPageLogon()) & (logonPage.inputEmail(ConfigData.getCfgValue("EMAIL")))
				& (logonPage.inputPassword(ConfigData.getCfgValue("PASSWORD"))) & (logonPage.clickLogon())
				& (logonPage.clickConfirmLogonQA()));
		Assert.assertTrue("Acception criteria is not met.", logonPage.checkUserName(ConfigData.getCfgValue("USERNAME")));
		ApplicationPage applicationPage = new ApplicationPage(driver);
		Assert.assertTrue(applicationPage.clickOnMipApplicationIcon());
		Assert.assertTrue(applicationPage.checkRedirectedMipUrl());
		MipHomePage mipHomePage = new MipHomePage(driver);
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectURETool()) & (mipHomePage.checkRedirectedUREUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectRVCTool()) & (mipHomePage.checkRedirectedRVCUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectMYMTool()) & (mipHomePage.checkRedirectedMYMUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectRAPTool()) & (mipHomePage.checkRedirectedRAPUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectTMTTool()) & (mipHomePage.checkRedirectedTMTUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectRATool()) & (mipHomePage.checkRedirectedRAUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectCSTTool()) & (mipHomePage.checkRedirectedCSTUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectHITTool()) & (mipHomePage.checkRedirectedHITUrl()));
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectTPSTool()) & (mipHomePage.checkRedirectedTPSUrl()));
		
	}

	@After
	public void tearDown() {
		LogonPage logonPage = new LogonPage(driver);
		logonPage.closeLogonPage();
	}

}
