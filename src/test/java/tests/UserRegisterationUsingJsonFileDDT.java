package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class UserRegisterationUsingJsonFileDDT extends TestBase 
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	LoginPage LoginPageObject;



	@Test(priority=0)
	public void TestUserRegisterationPage() throws InterruptedException, IOException, ParseException
	{
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();

		HomePageObject = new  HomePage(driver);
		HomePageObject.OpenRegisterLink();
		RegisterationPageObject = new RegisterationPage(driver);
		Thread.sleep(3000);
		RegisterationPageObject.UserRegisteration(jsonReader.FirstName, jsonReader.LastName,jsonReader.Email,jsonReader.Password);
		Thread.sleep(2000);
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
		LoginPageObject.UserLogin(jsonReader.Email,jsonReader.Password);
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		Thread.sleep(2000);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(2000);





	}



}
