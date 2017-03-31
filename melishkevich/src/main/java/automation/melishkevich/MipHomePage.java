package automation.melishkevich;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MipHomePage extends Page {
	By textUserEmailXpath = By.xpath(".//*[@id='topNav']//strong");
	By selectToolsXpath = By.xpath("//div[@class='dropdown-container']");
	By selectUREToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/ure/dashboard']");
	By selectRVCToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/rvc/dashboard']");
	By selectMYMToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/mym/dashboard']");
	By selectRAPToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/rap/dashboard']");
	By selectTMTToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/tmt/dashboard']");
	By selectRAToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/ra/dashboard']");
	By selectCSTToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/cst/dashboard']");
	By selectHITToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/hit/dashboard']");
	By selectTPSToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/tps/dashboard']");
	By selectUTEToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/ute/dashboard']");
	By selectWINToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/win/dashboard']");
	By selectFPTToolXpath = By.xpath("//ul[@class='tool-menu-select']//*[contains(text(),'FPT')]");
	By selectMSToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/ms/dashboard']");
	By selectTPSDToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/tpsd/dashboard']");
	By selectRAFToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/sdk/RAF/dashboard']");
	By selectHPTToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/sdk/HPT/dashboard']");
	By selectHPTV1ToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/hptv1/dashboard']");
	By selectICEToolXpath = By.xpath("//ul[@class='tool-menu-select']//a[@href='/ice/dashboard']");
	By selectDeviceSectionXpath = By.xpath("//li[@class='datamanagement']/ul[@class='sub']//a[@href='Device']");

	public MipHomePage(WebDriver driver) {
		super(driver);
		UrlBuilder mipUrl = new UrlBuilder();
		url = mipUrl.builStsUrl() + "Home";
		log = LogManager.getLogger(getClass());
	}

	public boolean checkUserEmail(String userEmail) {
		return isElementTextEquals(textUserEmailXpath, userEmail);
	}

	public boolean selectTools() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectToolsXpath));
		return clickButton(selectToolsXpath);
	}

	public boolean selectURETool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectUREToolXpath));
		return clickButton(selectUREToolXpath);
	}

	public boolean checkRedirectedUREUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "ure/dashboard");
	}

	public boolean selectRVCTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectRVCToolXpath));
		return clickButton(selectRVCToolXpath);
	}

	public boolean checkRedirectedRVCUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "rvc/dashboard");
	}

	public boolean selectMYMTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectMYMToolXpath));
		return clickButton(selectMYMToolXpath);
	}

	public boolean checkRedirectedMYMUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "mym/dashboard");
	}

	public boolean selectRAPTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectRAPToolXpath));
		return clickButton(selectRAPToolXpath);
	}

	public boolean checkRedirectedRAPUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "rap/dashboard");
	}

	public boolean selectRATool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectRAToolXpath));
		return clickButton(selectRAToolXpath);
	}

	public boolean checkRedirectedRAUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "ra/dashboard");
	}

	public boolean selectTMTTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectTMTToolXpath));
		return clickButton(selectTMTToolXpath);
	}

	public boolean checkRedirectedTMTUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "tmt/dashboard");
	}

	public boolean selectCSTTool() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectCSTToolXpath));
		return clickButton(selectCSTToolXpath);
	}

	public boolean checkRedirectedCSTUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "cst/dashboard");
	}

	public boolean selectHITTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectHITToolXpath));
		return clickButton(selectHITToolXpath);
	}

	public boolean checkRedirectedHITUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "hit/dashboard");
	}

	public boolean selectTPSTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectTPSToolXpath));
		return clickButton(selectTPSToolXpath);
	}

	public boolean checkRedirectedTPSUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "tps/dashboard");
	}

	public boolean selectUTETool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectUTEToolXpath));
		return clickButton(selectUTEToolXpath);
	}

	public boolean checkRedirectedUTEUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "ute/dashboard");
	}

	public boolean selectWINTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectWINToolXpath));
		return clickButton(selectWINToolXpath);
	}

	public boolean checkRedirectedWINUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "win/dashboard");
	}

	public boolean selectFPTTool() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectFPTToolXpath));
		return clickButton(selectFPTToolXpath);
	}

	public boolean checkRedirectedFPTUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "fpt/dashboard");
	}

	public boolean selectMSTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectMSToolXpath));
		return clickButton(selectMSToolXpath);
	}

	public boolean checkRedirectedMSUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "ms/dashboard");
	}

	public boolean selectTPSDTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectTPSDToolXpath));
		return clickButton(selectTPSDToolXpath);
	}

	public boolean checkRedirectedTPSDUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "tpsd/dashboard");
	}

	public boolean selectRAFTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectRAFToolXpath));
		return clickButton(selectRAFToolXpath);
	}

	public boolean checkRedirectedRAFUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "sdk/RAF/dashboard");
	}

	public boolean selectHPTTool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectHPTToolXpath));
		return clickButton(selectHPTToolXpath);
	}

	public boolean checkRedirectedHPTUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "sdk/hpt/dashboard");
	}

	public boolean selectHPTV1Tool() {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectHPTV1ToolXpath));
		return clickButton(selectHPTV1ToolXpath);
	}

	public boolean checkRedirectedHPTV1Url() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "hptv1/dashboard");
	}

	public boolean selectICETool() {
		return clickButton(selectICEToolXpath);
	}

	public boolean checkRedirectedICEUrl() {
		return isUrlEqualTo(urlBuilder.builMipUrl() + "ice/dashboard");
	}

	public boolean clickDeviceSection() {
		return clickButton(selectDeviceSectionXpath);
	}
	
	public boolean checkRedirectedDeviceUrl(){
		return doesUrlContain("Device");
	}

}
