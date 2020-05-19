package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailAFriendPage;
import pages.HomePage;
import pages.ProductSelectionPage;
import pages.RegisterResultPage;
import pages.RegisterationPage;
import pages.SearchPage;

public class EmailAFriendTest extends TestBase
{
	HomePage HomePageObject;
	RegisterationPage RegisterationPageObject;
	SearchPage SearchPageObject;
	ProductSelectionPage ProductSelectionPageObject;
	EmailAFriendPage EmailAFriendPageObject;
	RegisterResultPage RegisterResultPageObject;

	String FirstName= "sheha";
	String LastName = "moza";
	String Email = "lomatbekos3@testo.com";
	String Password = "12345678";
	String ProductName ="Apple MacBook Pro 13-inch";
	String FriendEmail ="kikoosamir@tetso.com";
	String PersonalMessage = "Hoba omry";

	@Test(priority=0)
	public void TestEmailAFriend() throws InterruptedException
	{
		HomePageObject = new HomePage(driver);
		HomePageObject.OpenRegisterLink();
		Thread.sleep(3000);
		RegisterationPageObject = new RegisterationPage(driver);
		RegisterationPageObject.UserRegisteration(FirstName, LastName, Email, Password);
		Thread.sleep(3000);
		HomePageObject.UserCanSearch(ProductName);
		Thread.sleep(2000);
		SearchPageObject = new SearchPage(driver);
		SearchPageObject.OpenProductLink();
		Thread.sleep(3000);
		ProductSelectionPageObject = new ProductSelectionPage(driver);
		ProductSelectionPageObject.ClickOnEmailAFriend();
		Thread.sleep(2000);
		EmailAFriendPageObject = new EmailAFriendPage(driver);
		EmailAFriendPageObject.SendEmail(FriendEmail, PersonalMessage);
		Assert.assertEquals(EmailAFriendPageObject.EmailAFriendResult.getText(), "Your message has been sent.");
		Thread.sleep(3000);
		RegisterResultPageObject = new RegisterResultPage(driver);
		RegisterResultPageObject.UserLogout();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/");
		Thread.sleep(2000);

	}
	


}
