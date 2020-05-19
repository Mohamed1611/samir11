package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterResultPage;
import pages.RegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {

	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	RegisterResultPage RegisterResultPageObject;


	@Given("The User is On Home Page")
	public void The_User_is_On_Home_Page()
	{


	}

	@When("User Click on Register Link text")
	public void User_Click_on_Register_Link_text() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenRegisterLink();
		Thread.sleep(2000);
	}
	/*@When("User Entered the Mandatory data")
	public void User_Entered_the_Mandatory_data() throws InterruptedException
	{
		RegisterationPageObject = new RegisterationPage(driver);
		RegisterationPageObject.UserRegisteration("sheko", "neko", "beko@test.com", "12345678");
		Thread.sleep(2000);*/
		
	@When("User Entered the {string} , {string} , {string} ,{string}")
		public void user_Entered_the_Email(String FirstName, String LastName, String Email, String Password) throws InterruptedException
		{
			RegisterationPageObject = new RegisterationPage(driver);
			RegisterationPageObject.UserRegisteration(FirstName, LastName, Email, Password);
			Thread.sleep(2000);
			
		}

	
	@Then("Registeration Result Page displayed")
	public void Registeration_Result_Page_displayed() throws InterruptedException
	{
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		 throw new io.cucumber.java.PendingException();
	}

}
