package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class UserRegisterationParallelTesting extends TestBase2 
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	LoginPage LoginPageObject;
	
   //add java faker library in pom 
   Faker FakeData = new Faker();
   
   String FirstName = FakeData.name().firstName();
   String LastName = FakeData.name().lastName();
   String Email = FakeData.internet().emailAddress();
   String Password = FakeData.number().digits(8).toString();

	@Test(priority=0)
	public void TestUserRegisterationPage() throws InterruptedException, IOException, ParseException
	{
		HomePageObject = new  HomePage(getDriver());
		HomePageObject.OpenRegisterLink();
		RegisterationPageObject = new RegisterationPage(getDriver());
		Thread.sleep(3000);
		RegisterationPageObject.UserRegisteration(FirstName,LastName,Email,Password);
		Thread.sleep(2000);
		RegisterResultPageObject = new RegisterResultPage(getDriver());
		Assert.assertTrue(RegisterResultPageObject.RegisterationSucssfullMessage.getText().contains("Your registration completed"));
		Thread.sleep(3000);

		//Logout
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);

		HomePageObject = new HomePage(getDriver());
		HomePageObject.OpenLoginLink();
		Thread.sleep(2000);
		LoginPageObject = new LoginPage(getDriver());
		LoginPageObject.UserLogin(Email,Password);
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(getDriver());
		Thread.sleep(2000);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(2000);


	}



}

