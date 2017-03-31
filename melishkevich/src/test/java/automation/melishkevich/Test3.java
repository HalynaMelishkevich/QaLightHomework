package automation.melishkevich;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test3 {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/halka/Downloads/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability("acceptInsecureCerts", true);
		driver = new FirefoxDriver(capabilities);
	}
/*In this test:
 * 1. Login into MIP and select any Tool
 * 2. Open Device section
 * 3. Click on EXPORT
 * 4. Check if export is executed successfully
 */
	@Test
	public void test3() throws IOException, InterruptedException{
		LogonPage logonPage = new LogonPage(driver);
		Assert.assertTrue((logonPage.openPageLogon()) & (logonPage.inputEmail(ConfigData.getCfgValue("EMAIL")))
				& (logonPage.inputPassword(ConfigData.getCfgValue("PASSWORD"))) & (logonPage.clickLogon())
				& (logonPage.clickConfirmLogonQA()));
		Assert.assertTrue("Acception criteria is not met.", logonPage.checkUserName(ConfigData.getCfgValue("USERNAME")));
		ApplicationPage applicationPage = new ApplicationPage(driver);
		Assert.assertTrue((applicationPage.clickOnMipApplicationIcon()) & (applicationPage.checkRedirectedMipUrl()));
		MipHomePage mipHomePage = new MipHomePage(driver);
		Assert.assertTrue(
				(mipHomePage.selectTools()) & (mipHomePage.selectURETool()) & (mipHomePage.checkRedirectedUREUrl()));
		Assert.assertTrue((mipHomePage.clickDeviceSection()) & (mipHomePage.checkRedirectedDeviceUrl()));
		DevicePage devicePage = new DevicePage(driver);
		Assert.assertTrue((devicePage.clickExport()) & (devicePage.openMyJobs()) & (devicePage.checkExportSuccess()));
	}
	
	@After
	public void tearDown() {
		LogonPage logonPage = new LogonPage(driver);
		logonPage.closeLogonPage();
	}
}
