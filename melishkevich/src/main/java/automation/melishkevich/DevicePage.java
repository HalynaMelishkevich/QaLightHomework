package automation.melishkevich;

import java.time.Clock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DevicePage extends Page {
	LocalTime currentTime;

	By buttonExport = By.id("exportItems");
	By myJobsXpath = By.xpath("//div[@class='ui-jobs-widget']");
	By exportNameXpath = By.xpath(".//div[@class='ui-jobs-list']/child::div[1]/span[@class='job-title']");
	By exportStatusXpath = By.xpath(".//div[@class='ui-jobs-list']/child::div[1]/span[@class='job-step']");

	public DevicePage(WebDriver driver) {
		super(driver);
		UrlBuilder mipUrl = new UrlBuilder();
		url = mipUrl.builStsUrl() + "ure/Device";
		log = LogManager.getLogger(getClass());
	}

	public boolean clickExport() {
		try {
			clickButton(buttonExport);
			// Standard click was too sophisticatedly realized, so it was easier
			// to click with Javascript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$('.startExport:visible').click()");
			log.info("Export started.");
			currentTime = getCurrentDate();
			return true;
		} catch (Exception ex) {
			log.error("Export not started.");
			return false;
		}
	}

	public boolean openMyJobs() {
		return clickButton(myJobsXpath);
	}

	public LocalTime getCurrentDate() {
		return LocalTime.now(Clock.systemUTC());
	}

	public boolean checkExportSuccess() {
		try {
			wait.until(ExpectedConditions.textToBe(exportNameXpath, "Device Export"));
			wait.until(ExpectedConditions.textToBe(exportStatusXpath, "Done"));

			return compareExportDates(currentTime);
		} catch (Exception ex) {
			log.error("Export is ended not successfully.");
			return false;
		}
	}

	public boolean compareExportDates(LocalTime dateBeforeExportStarted) {
		try {

			int counter = 0;
			while (counter < 10) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String stringDate = (String) js.executeScript("return $('.job-startedon>span:eq(1)').text()");
				System.out.println("Output from javascript:" + stringDate);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:mm:ss");
				LocalTime dateAfter = LocalTime.parse(stringDate, formatter);
				System.out.println("Before: " + dateBeforeExportStarted);
				System.out.println("After: " + dateAfter);
				if (dateAfter.isAfter(dateBeforeExportStarted)) {
					log.info("Export ended successfully.");
					return true;
				}
				Thread.sleep(1000);
				counter++;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
