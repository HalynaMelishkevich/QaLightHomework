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

public class Test1 {
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
 * 2. Input invalid credentials and Submit
 * 3. Checks that validation message appears
 * 4. Input valid credentials and Submit
 * 5. Check that user is redirected to Application page
 * 6. Checks user's Name and Surname
 * 7. Click on MIP
 * 8. Check that user is redirected to MIP Home page
 * 9. Click on LogOff
 * 10. Check that user is redirected to LogOn page
 * */
	@Test
	public void test1() throws InterruptedException, IOException {
		LogonPage logonPage = new LogonPage(driver);
		Assert.assertTrue((logonPage.openPageLogon()) & (logonPage.inputEmail("Aaa@aaa.aaa")) & (logonPage.inputPassword("A"))
				& (logonPage.clickLogon()) & (logonPage.clickConfirmLogonQA()));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("Acception criteria is not met.", logonPage.checkValidationTest());
		Assert.assertTrue((logonPage.inputEmail(ConfigData.getCfgValue("EMAIL")))
				& (logonPage.inputPassword(ConfigData.getCfgValue("PASSWORD"))) & (logonPage.clickLogon())
				& (logonPage.clickConfirmLogonQA()));
		Assert.assertTrue("Acception criteria is not met.", logonPage.checkUserName(ConfigData.getCfgValue("USERNAME")));
		ApplicationPage applicationPage = new ApplicationPage(driver);
		Assert.assertTrue((applicationPage.clickOnMipApplicationIcon()) & (applicationPage.checkRedirectedMipUrl()));
		Assert.assertTrue((applicationPage.clickLogOff()) & (applicationPage.checkRedirectedStsUrl()));
	}

	@After
	public void tearDown() {
		LogonPage logonPage = new LogonPage(driver);
		logonPage.closeLogonPage();
	}
}
