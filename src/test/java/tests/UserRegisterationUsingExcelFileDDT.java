package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class UserRegisterationUsingExcelFileDDT extends TestBase 
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	LoginPage LoginPageObject;

	
	@DataProvider(name="ExcelData")
	public Object [][] userRegisterData() throws IOException
	{
		//get data from excel reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
				
	}

	@Test(priority=0 , dataProvider="ExcelData")
	public void TestUserRegisterationPage(String FirstName , String LastName, String Email, String Password ) throws InterruptedException
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
		
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenLoginLink();
		Thread.sleep(2000);
		LoginPageObject = new LoginPage(driver);
		LoginPageObject.UserLogin(Email, Password);
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		Thread.sleep(2000);
		RegisterResultPageObject.UserLogout();
		
		
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
