package automation.melishkevich;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.melishkevich.UrlBuilder;

public abstract class Page {
	protected String url;
	protected WebDriver driver;
	public static String screenshotFileFolder = "log/screenshot/";
	Logger log;
	WebDriverWait wait;
	UrlBuilder urlBuilder;

	public Page(WebDriver driver) {
		this.driver = driver;
		log = LogManager.getLogger(Page.class);
		wait = new WebDriverWait(driver, 15); // 15 seconds
		urlBuilder = new UrlBuilder();
	}

	protected void openBrowser() {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			log.info("Page was opened.");
		} catch (Exception ex) {
			log.error("Page was not opened.", ex);
		}

	}

	protected String getValueFromConfig(String key) {
		try {
			String valueFromConfig = ConfigData.getCfgValue(key);
			log.info("Get value from config");
			return valueFromConfig;
		} catch (Exception e) {
			log.error("Error: " + e + "No config data for key " + key);
			return null;
		}
	}

	protected boolean openUrl(String url) {
		try {
			driver.get(url);
			log.info("Url was opened" + url);
			return true;
		} catch (Exception e) {
			log.error("Url cant be opened");
			return false;
		}

	}

	protected boolean selectFromList(By courseDropDown2, String valueNameOfCourse) {
		try {
			new Select(driver.findElement(courseDropDown2)).selectByVisibleText(valueNameOfCourse);
			log.info("Selected value from list");
			return true;
		} catch (Exception e) {
			log.error("Error: " + e);
			return false;
		}
	}

	protected boolean inputTextIntoField(By locator, String inputData) {
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(inputData);
			log.info("Data inputed.");
			return true;
		} catch (Exception ex) {
			log.error("Data not inputed", ex);
			return false;
		}
	}

	protected boolean clickButton(By locator) {
		try {
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0," + driver.findElement(locator).getLocation().y + ")");
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("document.findElement(locator).scrollDown += 100");
			*
			*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
			log.info("Button was clicked.");
			return true;
		} catch (Exception ex) {
			log.error("Error button was not clicked: " + ex);
			return false;
		}
	}

	protected boolean closeBrowser() {
		try {
			driver.close();
			driver.quit();
			log.info("Browser was closed.");
			return true;
		} catch (Exception ex) {
			log.error("Error browser was not closed: " + ex);
			return false;
		}
	}

	protected boolean findElementWithNeededCreteria(By variableLocatorOfMessage) {
		try {
			driver.findElement(variableLocatorOfMessage);
			log.info("Needed element was found " + variableLocatorOfMessage);
			return true;
		} catch (Exception e) {
			log.error("Error: Needed element was not found");
			return false;
		}
	}

	public boolean isElementPresentOnPage(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			if (element != null && element.isDisplayed()) {
				log.info("Element is found.");
				return true;
			} else {
				log.error("Element is not found.");
				return false;
			}
		} catch (Exception ex) {
			log.error("Element is not found.", ex);
			return false;
		}
	}

	public boolean isElementTextEquals(By locator, String elementText) {
		try {
			if (isElementPresentOnPage(locator) && driver.findElement(locator).getText().equals(elementText)) {
				log.info("Text matches the pattern.");
				return true;
			} else {
				log.error("Text doesn't match.");
				return false;
			}
		} catch (Exception ex) {
			log.error("Text does not match or element not found", ex);
			return false;
		}
	}

	public boolean isUrlEqualTo(String wantedUrl) {
		try {
			wait.until(ExpectedConditions.urlToBe(wantedUrl));
			log.info("URL is as expected.");
			return true;
		} catch (Exception ex) {
			log.error("URLs are not equal.", ex);
			return false;
		}
	}
	
	public boolean doesUrlContain(String wantedSubString) {
		try {
			wait.until(ExpectedConditions.urlContains(wantedSubString));
			log.info("URL is as expected.");
			return true;
		} catch (Exception ex) {
			log.error("URL doesn't contain specified substring.", ex);
			return false;
		}
	}

}
