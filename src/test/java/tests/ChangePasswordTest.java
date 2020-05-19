package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class ChangePasswordTest extends TestBase
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	MyAccountPage MyAccountPageObject;
	ChangePasswordPage ChangePasswordPageObject;

	String FirstName="Mohamed";
	String LastName="Samir";
	String Email="Tesbeka11@test.com";
	String Oldpassword="12345678";
	String NewPassword="123456789";



	@Test(priority=0)
	public void TestUserChangePassword() throws InterruptedException
	{
		HomePageObject = new  HomePage(driver);
		HomePageObject.OpenRegisterLink();
		RegisterationPageObject = new RegisterationPage(driver);
		Thread.sleep(3000);
		RegisterationPageObject.UserRegisteration(FirstName ,LastName,Email, Oldpassword);
		//RegisterResultPageObject = new RegisterResultPage(driver);
		//Assert.assertTrue(RegisterResultPageObject.RegisterationSucssfullMessage.getText().contains("Your registration completed"));
		Thread.sleep(2000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.OpenMyAccountpage();
		Thread.sleep(3000);
		MyAccountPageObject = new MyAccountPage(driver);
		MyAccountPageObject.OpenChangePasswordPage();
		Thread.sleep(3000);
		ChangePasswordPageObject = new ChangePasswordPage(driver);
		ChangePasswordPageObject.UserChangePassword(Oldpassword, NewPassword);
		Assert.assertTrue(ChangePasswordPageObject.ChangePasswordResult.getText().contains("Password was changed"));
		System.out.println(ChangePasswordPageObject.ChangePasswordResult.getText());
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}

	/*@Test(priority=1)
	public void TestUserChangePassword() throws InterruptedException
	{

		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.OpenMyAccountpage();
		Thread.sleep(3000);
		MyAccountPageObject = new MyAccountPage(driver);
		MyAccountPageObject.OpenChangePasswordPage();
		Thread.sleep(3000);
		ChangePasswordPageObject = new ChangePasswordPage(driver);
		ChangePasswordPageObject.UserChangePassword(Oldpassword, NewPassword);
		Assert.assertTrue(ChangePasswordPageObject.ChangePasswordResult.getText().contains("Password was changed"));
		System.out.println(ChangePasswordPageObject.ChangePasswordResult.getText());
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);
	}*/



}