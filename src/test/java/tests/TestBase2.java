package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helper.ScreenShot;

public class TestBase2 
{

	public static String BaseURL= "https://demo.nopcommerce.com/";

	protected ThreadLocal<RemoteWebDriver> driver=null;

	@BeforeClass
	@Parameters(value= {"browser"})
	public void Setup(@Optional("chrome") String browser) throws MalformedURLException
	{
		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseURL);
	}

	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	@AfterClass
	public void StopDriver()
	{
		getDriver().quit();
		driver.remove();
	}
	
	//Take screenshot when test case failed and add it to screenshots folder
	@AfterMethod
	public void TakingScreenshotOnFailure(ITestResult Result)
	{
		if (Result.getStatus()==ITestResult.FAILURE) 
		{
			System.out.println("Failed!");
			System.out.println("Taking ScreenShot...");
			ScreenShot.TakeScreenShot(getDriver(), Result.getName());
		}
	}

}
