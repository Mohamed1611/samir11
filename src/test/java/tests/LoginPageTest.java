package tests;


import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;


public class LoginPageTest extends TestBase
{
	HomePage HomePageObject;
	LoginPage LoginPageObject;
	RegisterResultPage RegisterResultPageObject;
	
	String Email = "Smimbozy1@Test.com";
	String Password = "1234567";

	@Test(priority=0)
	public void TestLoginPage() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginLink();
		Thread.sleep(3000);
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.UserLogin(Email, Password);
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		Thread.sleep(2000);
		RegisterResultPageObject.UserLogout();
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);

	}
	

}
