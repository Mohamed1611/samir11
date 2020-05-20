package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.ScreenShot;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;

	public static String DownloadPath = System.getProperty("user.dir")+ "/Downloads";

	public static ChromeOptions chromeoption()
	{
		ChromeOptions ChromeBrowserOptions = new ChromeOptions();
		HashMap<String, Object> ChromePrefs = new HashMap<String, Object>();
		ChromePrefs.put("profile.default.content_settings.popups", 0);
		ChromePrefs.put("download.default_directory",DownloadPath );
		ChromeBrowserOptions.setExperimentalOption("Prefs", ChromePrefs);
		ChromeBrowserOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return ChromeBrowserOptions;
	}

	public static FirefoxOptions firefoxoption()
	{
		FirefoxOptions FireFoxBrowserOptions = new FirefoxOptions();
		FireFoxBrowserOptions.addPreference("browser.download.folderList", 2);
		FireFoxBrowserOptions.addPreference("browser.download.dir", DownloadPath);
		FireFoxBrowserOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/pdf,application/octet-stream");
		FireFoxBrowserOptions.addPreference("browser.download.manager.showWhenStarting",false);
		FireFoxBrowserOptions.addPreference("pdfjs.disabled", true);
		return FireFoxBrowserOptions;

	}


	@BeforeSuite
	@Parameters({"browser"})
	public void OpenDriver(@Optional ("chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			String ChromePath= System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromePath);
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox"))
		{
			String FireFoxPath= System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FireFoxPath);
			driver = new FirefoxDriver(firefoxoption());
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			String IEPath= System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IEPath);
			driver = new InternetExplorerDriver();
		}

		//headless browser testing
		else if(browserName.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("user.dir")+"\\Drivers\\phantomjs.exe");
			String[] phontomjsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phontomjsArgs);

			driver = new PhantomJSDriver(caps);

		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void CloseDriver()
	{
		driver.quit();
	}
	//Take screenshot when test case failed and add it to screenshots folder
	@AfterMethod
	public void TakingScreenshotOnFailure(ITestResult Result)
	{
		if (Result.getStatus()==ITestResult.FAILURE) 
		{
			System.out.println("Failed!");
			System.out.println("Taking ScreenShot...");
			ScreenShot.TakeScreenShot(driver, Result.getName());
		}
	}

}
