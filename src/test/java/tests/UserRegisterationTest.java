package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class UserRegisterationTest extends TestBase 
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	LoginPage LoginPageObject;

	String FirstName = "Mohamed";
	String LastName = "lolo";
	String Email = "Smimbozy1@Test.com";
	String Password = "1234567";  
	String ProductName ="Apple MacBook Pro 13-inch";

	@Test(priority=0)
	public void TestUserRegisterationPage() throws InterruptedException
	{
		HomePageObject = new  HomePage(driver);
		HomePageObject.OpenRegisterLink();
		RegisterationPageObject = new RegisterationPage(driver);
		Thread.sleep(3000);
		RegisterationPageObject.UserRegisteration(FirstName, LastName,Email,Password);
		RegisterResultPageObject = new RegisterResultPage(driver);
		Assert.assertTrue(RegisterResultPageObject.RegisterationSucssfullMessage.getText().contains("Your registration completed"));
		Thread.sleep(3000);
		
		//Logout
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		
		
	}

	/*@Test(priority=1)
	public void TestUserLogout() throws InterruptedException
	{
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = {"TestUserLogout"} )
	public void TestLoginPage() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginLink();
		Thread.sleep(3000);
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.UserLogin(Email, Password);
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}*/
	


}
