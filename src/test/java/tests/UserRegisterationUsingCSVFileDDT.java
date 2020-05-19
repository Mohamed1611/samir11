package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;

public class UserRegisterationUsingCSVFileDDT extends TestBase 
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;
	LoginPage LoginPageObject;

	CSVReader Reader;



	@Test(priority=0)
	public void TestUserRegisterationPage() throws InterruptedException, CsvValidationException, IOException
	{
		//to get the CSV file path
		String CsvFile =System.getProperty("user.dir")+"\\src\\test\\java\\data\\CsvUserData.csv";
		Reader = new CSVReader(new FileReader(CsvFile));

		String[] CsvCell;
		
		// While loop will be executed till the last value in CSV file
		while((CsvCell = Reader.readNext())!= null)
		{
			String FirstName = CsvCell[0];
			String LastName = CsvCell[1];
			String Email = CsvCell[2];
			String Password = CsvCell[3];

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
			Thread.sleep(2000);

		}



		}



	}
